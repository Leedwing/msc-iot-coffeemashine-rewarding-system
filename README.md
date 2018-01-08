# IOT Hackathon – Bewertungssystem für die Kaffeemaschine des HHZ

## Inhaltsverzeichnis
- [Allgemein](#allgemein)
  * [Idee](#idee)
  * [MVP](#mvp)
  * [Architektur](#architektur)
  * [Value Proposition Canvas](#value-proposition-canvas)
  * [Teilnehmer und Zuständigkeiten](#teilnehmer-und-zuständigkeiten)
- [Durchführung](#durchführung)
  * [Datenerhebung und -verarbeitung](#datenerhebung-und--verarbeitung)
  * [REST-Services](#rest-services)
- [Ergebnis](#ergebnis)
  * [Bewertungssytem-Webfrontend](#bewertungssytem-webfrontend)
  * [Übersicht REST-Services](#Übersicht-rest-services)
  * [Anwendung der Parallelgruppe](#anwendung-der-parallelgruppe)


## Allgemein
Das folgende Projekt entstand im Rahmen eines zweitägigen ‚Hackathons‘ der Veranstaltung Internet of Things (kurz IoT) des Herman Hollerith Zentrums (HHZ) in Böblingen. Dabei bestand die Aufgabe darin, Anwendungen von IoT zu finden, welche das Studieren am HHZ in irgendeiner Form verbessern oder bereichern soll, und anschließend die gewählte Anwendung in einer zweitägigen Umsetzungsphase (als ‚Hackathon‘ bezeichnet) in die Realität umzusetzen.
Bei der Planung des zu realisierenden Projekts ist der Fokus so zu wählen, dass die Hauptfunktionalität des Projekts am Ende der zwei Tage anhand eines sogenannten MVP (minimal viable product). D.h. es wurde versucht eben genau diese Hauptfunktionen umzusetzen um die Realisierbarkeit des gesamten Projekts bzw. der Idee dahinter zu veranschaulichen.

### Idee
Die von uns verfolgte Idee basiert auf einem Projekt, welches ebenfalls wie dieses, im Rahmen eines Hackathons entstanden ist. Das damalige Projekt [IoT Kaffeekanne](https://github.com/miwurster/msc-iot-kaffeekanne) ermöglichte es, den Füllstand der im HHZ befindlichen Kaffeemaschine anhand einer Waage zu ermitteln und anhand dieser Daten Informationen über den aktuellen Status der Maschine per Twitter abzurufen.
Die Realisierung erfolgte anhand einer Digitalwaage, welche per USB angesteuert wurde und somit Gewichtsdaten live aus dem Gerät ausgelesen werden konnten. Entsprechende Cloud-Dienste verarbeiteten die Daten und sendeten Twitter-Nachrichten sobald bestimmte Schwellenwerte überschritten wurden.
Unsere Idee war es, auf diesem Projekt aufzusetzen und weitere bzw. andere Services bereitzustellen. Der für uns dabei wichtigste neue Service ist das Kaffeekochen-Bewertungssystem, welcher es ermöglichen soll die Kaffeekoch-Vorgänge nachverfolgen zu können indem der entsprechende Koch seine getane Arbeit nach dem Kochen vermerkt.
Hintergrund dafür ist es, dass ggf. Belohnungen für getane Arbeit für und am HHZ vergütet werden sollen. Um das Kaffeekochen in dieses Belohnungssystem einfließen zu lassen, müssen entsprechende Daten erhoben und verarbeitet werden.
Ein weiterer wichtiger Fokus lag bei unserem Projekt darin, eine Schnittstelle bereitzustellen um Live-Daten über die Kaffeemaschine zu erhalten, wie z.B. den Füllstand oder der Zeitpunkt des letzten Kochvorgangs.

### MVP
Da der Hackathon nur ein zweitägiges Arbeiten vorsieht, mussten wir den großen Ideenpool an Services auf das MVP (minimal viable product) herunterbrechen.
Unsere Anforderungen haben wir wie folgt definiert:

* Inbetriebnahme und Adaptierung der Ausleseprozedur der Messdaten der Waage
* Speicherung der gesammelten (Mess-)Daten in einer SQL-Datenbank
* Implementierung von folgenden REST-Services:
	* Abfrage des Kaffee-Füllstandes
	* Abfrage der Kaffeefrische
	* Abfrage des letzten Kochs
	* Benutzerbezogene Speicherung von Kochvorgängen
* Bewertungssystem zur Speicherung von durchgeführten Kochvorgängen in Form eines Webfrontends

### Architektur

![Architektur.png](https://github.com/Leedwing/msc-iot-coffeemashine-rewarding-system/blob/master/Architektur.png)

* Die **Waage** (GRAM RZ-30): misst das Gewicht der darauf liegenden Kaffeekanne und übergibt die Daten per USB an dem Raspberry Pi
* Der **Raspberry Pi**: darauf wird ein Python-Skript aufgespielt, der die Daten ausliest und in einer **SQLite** Datenbank abspeichert.
* **Apache Tomcat**: dient als Open-Source-Webserver. Hier wird die **Bewertungssystem-Webseite** deployed.
* Die **REST-APIs** wurden mit **Spring Boot** Framework implementiert. Mit diesem Framework können Applikationen selbständig (ohne externen Webserver) starten. Die realisierten APIs greifen auf der SQLite Datenbank zu, um die benötigten Daten auszulesen bzw. zu schreiben.


### Value Proposition Canvas
![value_proposition_canvas.png](https://github.com/Leedwing/msc-iot-coffeemashine-rewarding-system/blob/master/value_proposition_canvas.PNG)
The most important customer jobs are project work and creative work.
In the "Pains" segment of the VPC we enter the problems of students. After a strenuous lecture mostly coffee is no longer available and must be freshly made. It takes a long time to make coffee. In the worst case, the break is over when coffee is available again

We implement the services that are in the VPCs 'Gains' segment.
The students regularly check the coffee so they have hot coffee during the break.

As the most important part of the "Pain Reliever" segment, we mention the claim that coffee is always present. The students check the coffee stand before they go to the break.

For the "Gain Creator" we mention that when the coffee level is low, the students fill up the coffee pot to drink hot coffee during the break and collect the bonus points.

For 'Products & Services' we would need a scale to determine the coffee stock and a Respberry Pi to forward the data to the database.


### Teilnehmer und Zuständigkeiten
Pascal Schmidt (Raspberry Pi Setup, Python SQL- und Sensor-Implementierung, SQLite Setup, Webfrontend, Dokumentation) 

Lee Edwing Nguepedja (Implementierung REST Services, Apache Tomcat Setup, Webfrontend, Dokumentation) 

Adil Sahiner (Präsentation, Value Proposition Canvas)

## Durchführung
### Datenerhebung und -verarbeitung
Als ersten Schritt galt es, die Daten aus der Waage auszulesen. Das aktuelle Gewicht auf der Waage kann wie im Vorgängerprojekt bereits beschrieben anhand eines USB-Adapters ausgelesen werden. Die Waage wird am Rechner als HID-Gerät interpretiert, wodurch  nach Anschluss kontinuierlich Gewichtsdaten in Form von Tastatureingaben an den Rechner gesendet werden.
Die genauere Form der Daten und deren Interpretation ist im Wiki des Vorgängerprojekts nachzulesen ([siehe hier](https://github.com/miwurster/msc-iot-kaffeekanne)).
Der Einfachheit halber haben wir uns das für die Datenverarbeitung verwendete Python-Skript der Vorgänger zur Hand genommen und auf unsere eigenen Bedürfnisse angepasst bzw. um Funktionen erweitert.
Das Skript ([scale_handler.py](https://github.com/Leedwing/msc-iot-coffeemashine-rewarding-system/blob/master/Raspberry/scale_handler.py)) verarbeitet die per USB ankommenden Daten und speichert diese in bestimmten Zyklen in der von uns neu aufgesetzten SQLite-Datenbank. Da die Waage sehr hochfrequent Gewichtsdaten bereitstellt wird hierbei nicht jedes empfangene Gewicht gespeichert, sondern nur der Median von Gewichtsdaten aus einem variabel festlegbaren Zeitintervall.



Die Funktion der Datenbank übernimmt wie bereits beschrieben eine SQLite-Datenbank, welche, ebenfalls wie auch das zum Auslesen verwendete Python-Skript, auf dem Raspberry Pi beheimatet ist.
Die Datenbank besteht aus drei Tabellen: User, CoffeeLevel und UserCoffeeLevel.
Die Tabelle User enthält dabei alle registrierten Benutzer. D.h. registriert sich ein Benutzer über das Webfrontend, wird eine Zeile in dieser Tabelle angelegt.
Die Tabelle CoffeeLevel enthält die Messdaten der Kaffeemaschine, d.h. diese Tabelle wird kontinuierlich vom o.a. Python-Skript gefüttert und speichert somit pro übermittelter Messung den Füllstand inklusive des Zeitpunktes der Messung.
Die Tabelle UserCoffeeLevel enthält die Daten über durchgeführe Kochvorgänge, d.h. wird ein Kochvorgang durchgeführt und dieser anschließend über das Webfrontend einem User zugeordnet, wird der Kochvorgang in Form einer Zeile in dieser Tabelle festgehalten.

**Datenbankmodell**

![DB_Modell.png](https://github.com/Leedwing/msc-iot-coffeemashine-rewarding-system/blob/master/DB_Modell.png)


### REST-Services
Wie im MVP bereits erwähnt mussten Ressourcen über den Füllstand und der Frische des Kaffees sowie weitere Infos wie den User, der zuletzt Kaffee gekocht hat, zur Verfügung gestellt werden.
Mit der Bereitstellung der Kaffeekanne-Infos in Form von REST-APIs wurde ein Architekturstil geschafft, welcher die Anforderungen des modernen Webs gut darstellt. Somit ist eine Integration mit weiteren Systemen erleichtert und eine hohe Flexibilität erreicht.
Für die Implementierung der REST-APIs wurde Java EE mit dem Framework Spring Boot  verwendet. Die Anwendung gliedert sich in 3 Hauptmodulen:
* Das Modul **Model**: besteht aus Klassen, welche die Datenmodelle der zu liefernden Ressourcen beschreiben. Die wichtigsten Modellen sind:
	* User     
	```
	{
 	 "cookingCount": "integer",
 	 "firstName": "string",
 	 "lastName": "string",
 	 "registrationNo": "string"
	}
	```   
	
	* CoffeeLevel   
	```
	{
 	 "date": "date",
 	 "weight": "integer",
	}
	```     
	
	* UserCoffeeLevel     
	```
	{
 	 "user": "user",
 	 "date": "date",
	}
	```

* Das Modul **Service**: besteht aus einer Klasse, wo die Kernfunktionen der API implementiert wurden. Die Funktion getCoffeeChef() ist hierbei ein konkretes Beispiel, wo die Logik implementiert wurde, um herauszufinden welcher User am meisten Kaffee kocht.

* Das Modul **Controller**: greift auf die Funktionen des Moduls Service zu. Hier ist die Klasse implementiert über die die APIs tatsachlich nach Außen bereitgestellt werden.

Auf die folgenden APIs  können zugegriffen werden:   

**Coffee chef API**: stellt Daten zur Verfügung über den User, der am meisten Kaffee kocht.     
Link: http://localhost:8080/coffeemachine/coffeechef     

**Coffee level API**: stellt Daten über den aktuellen Kaffeestand in der Kaffeekanne zur Verfügung.     
Link: http://localhost:8080/coffeemachine/coffeelevel      

**Have brewed last API**: stellt Daten zur Verfügung über den User, der zuletzt Kaffee gekocht hat.     
Link: http://localhost:8080/coffeemachine/havebrewedlast     

**Last time brewed API**: stellt Daten zur Verfügung darüber, zu welchem Zeitpunkt Kaffee zuletzt gekocht wurde.     
Link: http://localhost:8080/coffeemachine/lasttimebrewed     

**Warm coffee API**: stellt Daten zur Verfügung darüber, wie warm der Kaffee in der Kanne ist.     
Link: http://localhost:8080/coffeemachine/warmcoffee

## Ergebnis
### Bewertungssytem-Webfrontend
Das Bewertungssystem ist über ein Webfrontend erreichbar. Man erreicht diese Seite allerdings nur aus dem Netzwerk des HHZ, sodass sichergestellt ist, dass dies auch nur von Personen innerhalb des HHZ aufgerufen werden kann.

![Webfrontend_Bewertungssystem.png](https://github.com/Leedwing/msc-iot-coffeemashine-rewarding-system/blob/master/Webfrontend_Bewertungssystem.png?raw=true)

Wie im Schaubild zu sehen kann man sich im oberen Teil der Seite registrieren. Hierfür müssen nur Matrikelnummer, Vorname und Nachname angegeben werden un anschließend der Registrieren-Button gedrückt werden.
Wird der Button gedrückt wird eine REST-Anfrage gesendet, welche weitere Schritte zur Speicherung der Credentials in der Datenbank vornimmt.

Im unteren Teil der Seite kann ein durchgeführtes Kaffeekochen festgehalten werden. Hierfür muss nur die eigene Matrikelnummer angegeben werden und der Eintragen-Button gedrückt werden. Daraufhin wird eine REST-Anfrage gesendet, welche die erforderlichen Schritte zur Speicherung des Kochvorgangs in der Datenbank vornimmt.

### Übersicht REST-Services
Um die implementierten Services ordentlich zu dokumentieren, zu visualisieren sowie direkt über den Browser testen zu können wurde eine Web-UI mit dem Spring-Swagger realisiert. Die Weboberflaesche ist über den folgenden Link innerhalb des HHZ Netzes erreichbar: http://localhost:8080/swagger-ui.html.

![swagger_uebersicht.png](https://github.com/Leedwing/msc-iot-coffeemashine-rewarding-system/blob/master/swagger_uebersicht.PNG)  

Auf der Grafik ist außer den Informationen über den Titel der Seite sowie über die Entwickle eine Übersicht von den verschiedenen Services zu sehen. Recht zu den Services kann gelesen werden was genau die einelnen Operationen zurückgeben. Ein Klick auf einen Service blendet weitere Informationen ein.

![swagger_resource_expand_example](https://github.com/Leedwing/msc-iot-coffeemashine-rewarding-system/blob/master/swagger_resource_expand_example.PNG)

Wichtige davon sind das Datenmodel bzw. ein Beispiel vom Datensatz, den zurückgeliefert wird und der Button *try it out*. Dieser Button dienst dazu den Service zu testen. Der Test des Services GET coffeechef liefert folgendes Beispielergebnis zurück:

![swagger_response_getcoffeechef](https://github.com/Leedwing/msc-iot-coffeemashine-rewarding-system/blob/master/swagger_response_getcoffeechef.PNG)

Somit ist eine schnelle Übersicht über die bereitgestellte API vorhanden, sodass weitere Integrationen erleichtert werden.

### Anwendung der Parallelgruppe
Die implementierten Services wurden z.T. zur Unterstützung eines parallel laufenden Projekts erstellt, da diese auf die von uns gesammelte Daten auf verschiedene Art und Weise zugreifen mussten. Die bereitgestellten REST-Services erfüllten genau diese Kriterien bzw. wurden z.T. genau für diese Anforderungen entworfen und implementiert.

Anhand der REST-Services konnten Füllstand, Frische, fleißigster Koch etc. ganz einfach abgefragt werden. Die Parallelgruppe konnte diese Services verwenden, um die Daten per Amazon Alexa zu erfragen und dabei für das HHZ sinnvolle und in der Praxis anwendbare Anfragen zu generieren.
Das Speichern von Kochvorgängen war hierbei allerdings noch nicht berücksichtigt.
