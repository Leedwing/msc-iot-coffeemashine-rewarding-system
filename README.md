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

* Die **Waage** (GRAM RZ-30): misst das Gewicht der darauf liegenden Kaffeekanne und übergibt die Daten per USB an den Raspberry Pi
* Der **Raspberry Pi**: 
	* hierauf wird das Python-Skript betrieben, welches die Daten ausliest und in einer **SQLite** Datenbank abspeichert.
	* **Apache Tomcat**: dient als Open-Source-Webserver. Hierauf wird die **Bewertungssystem-Webseite** deployed.
	* Die **REST-APIs** wurden mittels **Spring Boot** Framework implementiert. Anhand dieses Frameworks können Applikationen selbständig (ohne externen Webserver) gestartet und betrieben werden. Die realisierten APIs greifen auf der SQLite Datenbank zu, um die benötigten Daten auszulesen bzw. zu schreiben.


### Value Proposition Canvas
![value_proposition_canvas.png](https://github.com/Leedwing/msc-iot-coffeemashine-rewarding-system/blob/master/value_proposition_canvas.PNG)
Die wichtigsten Kundenjobs sind Projektarbeit und kreative Arbeit.

In das "Pains" -Segment der VPC tragen wir die Probleme von Studenten ein. Nach einem anstrengenden Vorlesungen ist meistens Kaffee nicht mehr vorhanden und muss frisch gemacht werden. Es dauert lange, um Kaffee zu machen. Im schlimmsten Fall ist die Pause vorbei, wenn Kaffee wieder vorhanden ist.

Wir implementieren die Dienste, die sich im Segment 'Gewinne' der VPC befinden. Die Studenten kontrollieren den Kaffee stand regelmäßig damit sie in der Pause warmes Kaffee zu Verfügung haben.

Als wichtigster Teil des "Pain-Relievers" -Segments erwähnen wir die Behauptung, dass der immer Kaffee vorhanden ist. Die Studenten kontrollieren den Kaffeestand bevor die in die Pause gehen.

Für den "Gain Creator" erwähnen wir das wenn der Kaffeestand niedrig ist, füllen die Studenten die Kaffeekanne auf. Somit hätten die Studenten in der Pause einen heißen Kaffee zu verfügung und gleichzeitig könnten sie Bonuspunkte sammeln.

Für 'Products & Services' bräuchten wir eine Waage um den Kaffeestand ermitteln zu können und einen Raspberry Pi der die Daten an die Datenbank weiterleitet.



### Teilnehmer und Zuständigkeiten
Pascal Schmidt (Raspberry Pi Setup, Python SQL- und Sensor-Implementierung, SQLite Setup, Webfrontend, Dokumentation) 

Lee Edwing Nguepedja (Implementierung REST Services, Apache Tomcat Setup, Webfrontend, Dokumentation) 

Adil Sahiner (Präsentation, Value Proposition Canvas, Dokumentation)

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
Wie im MVP bereits erwähnt mussten Ressourcen über den Füllstand und die Frische des Kaffees sowie weitere Infos wie den User, der zuletzt Kaffee gekocht hat, zur Verfügung gestellt werden.
Mit der Bereitstellung der Kaffeekannen-Infos in Form von REST-APIs wurde ein Architekturstil geschafft, welcher die Anforderungen des modernen Webs gut darstellt. Somit ist eine Integration mit weiteren Systemen erleichtert und eine hohe Flexibilität erreicht.
Für die Implementierung der REST-APIs wurde Java EE mit dem Framework Spring Boot verwendet. Die Anwendung gliedert sich in 3 Hauptmodule:
* Das Modul **Model**: besteht aus Klassen, welche die Datenmodelle der zu liefernden Ressourcen beschreiben. Die wichtigsten Modelle sind:
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

* Das Modul **Service**: besteht aus einer Klasse, in welcher die Kernfunktionen der APIs implementiert wurden. Die Funktion getCoffeeChef() ist hierbei ein konkretes Beispiel, wobei die Funktion implementiert wurde, herauszufinden welcher User am meisten Kaffee kocht.

* Das Modul **Controller**: greift auf die Funktionen des Moduls Service zu. Hier ist die Klasse implementiert, über die die APIs tatsächlich nach Außen bereitgestellt werden.

Auf die folgenden APIs  können zugegriffen werden:   

**Coffee chef API**: stellt Daten zur Verfügung über den User der am meisten Kaffee kocht.     
Link: http://localhost:8080/coffeemachine/coffeechef     

**Coffee level API**: stellt Daten über den aktuellen Kaffeefüllstand in der Kaffeekanne zur Verfügung.     
Link: http://localhost:8080/coffeemachine/coffeelevel      

**Have brewed last API**: stellt Daten zur Verfügung über den User, der zuletzt Kaffee gekocht hat.     
Link: http://localhost:8080/coffeemachine/havebrewedlast     

**Last time brewed API**: stellt Daten über den Zeitpunkt des letzten Kochens zur Verfügung.     
Link: http://localhost:8080/coffeemachine/lasttimebrewed     

**Warm coffee API**: stellt Daten über die Wärme des Kaffees aus der Kanne zur Verfügung.     
Link: http://localhost:8080/coffeemachine/warmcoffee

Um die REST-API-App zu starten die Datei /coffeemachine-api/target/kaffeemaschine-api-0.0.1-SNAPSHOT.jar mit Java ausführen:
Folgende Zeile ausführen   
```
java -jar kaffeemaschine-api-0.0.1-SNAPSHOT.jar
```    
Wenn die App gestartet hat kann direkt auf die Ressourcen zugegriffen werden.

## Ergebnis
### Bewertungssytem-Webfrontend
Das Bewertungssystem ist über ein Webfrontend erreichbar. Man erreicht diese Seite allerdings nur aus dem Netzwerk des HHZ, sodass sichergestellt ist, dass dies auch nur von Personen innerhalb des HHZ aufgerufen werden kann.

![Webfrontend_Bewertungssystem.png](https://github.com/Leedwing/msc-iot-coffeemashine-rewarding-system/blob/master/Webfrontend_Bewertungssystem.png?raw=true)

Wie im Schaubild zu sehen kann man sich im oberen Teil der Seite registrieren. Hierfür müssen nur Matrikelnummer, Vorname und Nachname angegeben werden un anschließend der Registrieren-Button gedrückt werden.
Wird der Button gedrückt wird eine REST-Anfrage gesendet, welche weitere Schritte zur Speicherung der Credentials in der Datenbank vornimmt.

Im unteren Teil der Seite kann ein durchgeführtes Kaffeekochen festgehalten werden. Hierfür muss nur die eigene Matrikelnummer angegeben werden und der Eintragen-Button gedrückt werden. Daraufhin wird eine REST-Anfrage gesendet, welche die erforderlichen Schritte zur Speicherung des Kochvorgangs in der Datenbank vornimmt.

### Übersicht REST-Services
Um die implementierten Services ordentlich zu dokumentieren, zu visualisieren sowie direkt über den Browser testen zu können wurde eine Web-UI mit Spring-Swagger realisiert. Die Weboberflaeche ist über den folgenden Link innerhalb des HHZ Netzes erreichbar: http://localhost:8080/swagger-ui.html.

![swagger_uebersicht.png](https://github.com/Leedwing/msc-iot-coffeemashine-rewarding-system/blob/master/swagger_uebersicht.PNG)  

Auf der Grafik ist außer den Informationen über den Titel der Seite sowie über die Entwickler eine Übersicht von den verschiedenen Services zu sehen. Rechts kann zu den Services gelesen werden, welche Werte die einzelnen Operationen zurückgeben. Ein Klick auf einen Service blendet weitere Informationen über den Service ein.

![swagger_resource_expand_example](https://github.com/Leedwing/msc-iot-coffeemashine-rewarding-system/blob/master/swagger_resource_expand_example.PNG)

Ein wichtiger Bestandteil dieser Infos ist das Datenmodell bzw. die Beispiele vom Datensatz, welcher anhand des Buttons *try it out* live getestet werden kann. Beispielsweise liefert der Test des Services GET coffeechef folgendes Beispielergebnis zurück:

![swagger_response_getcoffeechef](https://github.com/Leedwing/msc-iot-coffeemashine-rewarding-system/blob/master/swagger_response_getcoffeechef.PNG)

Somit ist eine schnelle Übersicht über die bereitgestellten APIs vorhanden, sodass weitere Integrationen erleichtert werden.

### Anwendung der Parallelgruppe
Die implementierten Services wurden z.T. zur Unterstützung eines parallel laufenden Projekts erstellt, da diese auf die von uns gesammelte Daten auf verschiedene Art und Weise zugreifen mussten. Die bereitgestellten REST-Services wurden auf diese Anforderungen und bestimmte Kriterien abgestimmt.

Anhand der REST-Services konnten Füllstand, Frische, fleißigster Koch etc. ganz einfach abgefragt werden. Die Parallelgruppe konnte diese Services verwenden, um die Daten per Amazon Alexa per Sprachsteuerung zu erfragen und hat damit unser Projekt durch eine weitere Schnittstelle bereichert.
