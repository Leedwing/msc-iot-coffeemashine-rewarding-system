# IOT Projekt – Bewertungssystem Kaffeemaschine HHZ

## Inhaltsverzeichnis
* Allgemein
	* Idee
	* MVP
	* Architektur
	* Komponenten
	* Teilnehmer & Zuständigkeiten
* Durchführung
	* Datenerhebung und -verarbeitung
	* REST-Services
* Ergebnis 
	* Bewertungssytem-Webfrontend
	* Übersicht REST-Services
	* Beispielanwendungen der Services


## Allgemein
Das folgende Projekt entstand im Rahmen eines zweitägigen ‚Hackathons‘ der Veranstaltung Internet of Things (kurz IoT) des Herman Hollerith Zentrums (HHZ) in Böblingen. Dabei bestand die Aufgabe darin, Anwendungen von IoT zu finden, welche das Studieren am HHZ in irgendeiner Form verbessern bzw. bereichern soll, und die gewählte Anwendung anschließend in einer zweitägigen Umsetzungsphase (als ‚Hackathon‘ bezeichnet) in die Realität umzusetzen.
Bei der Planung des zu realisierenden Projekts ist der Fokus so zu wählen, dass die Hauptfunktionalität des Projekts am Ende der zwei Tage präsentierbar ist. Dieser Fokus wird im Folgenden als MVP bezeichnet und beschreibt eben genau diese Hauptfunktionen des Projekts um die Realisierbarkeit des gesamten Projekts bzw. der Idee dahinter zu veranschaulichen.

### Idee
Die von uns verfolgte Idee basiert auf einem Projekt, welches ebenfalls wie dieses, im Rahmen eines Hackathons entstanden ist. Das damalige Projekt ‚msc bla Link‘ ermöglichte es, den Füllstand der im HHZ befindlichen Kaffeemaschine anhand einer Waage zu ermitteln und anhand dieser Daten Informationen über den aktuellen Status der Maschine per Twitter abzurufen.
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

### Teilnehmer & Zuständigkeiten
Pascal Schmidt (Raspberry Pi Setup, Python Sensor, Python mit SQL, Webfrontend, Dokumentation)
Lee Edwing Nguepedja (Implementierung REST Services, Apache Tomcat Setup, Webfrontend, Dokumentation)
Adil Sahiner (Präsentation)

## Durchführung
### Datenerhebung und -verarbeitung
Als ersten Schritt galt es, die Daten aus der Waage auszulesen. Das aktuelle Gewicht auf der Waage kann wie im Vorgängerprojekt bereits beschrieben anhand eines USB-Adapters ausgelesen werden. Die Waage wird am Rechner als HID-Gerät interpretiert, wodurch  nach Anschluss kontinuierlich Gewichtsdaten in Form von Tastatureingaben an den Rechner gesendet werden.
Die genauere Form der Daten und deren Interpretation ist im Wiki des Vorgängerprojekts nachzulesen (siehe LINK).
Der Einfachheit halber haben wir uns das für die Datenverarbeitung verwendete Python-Skript der Vorgänger zur Hand genommen und auf unsere eigenen Bedürfnisse angepasst bzw. um Funktionen erweitert.
Das Skript verarbeitet die per USB ankommenden Daten und speichert diese in bestimmten Zyklen in der von uns neu aufgesetzten SQLite-Datenbank. Da die Waage sehr hochfrequent Gewichtsdaten bereitstellt wird hierbei nicht jedes empfangene Gewicht gespeichert, sondern nur der Median von Gewichtsdaten aus einem variabel festlegbaren Zeitintervall.

Die Funktion der Datenbank übernimmt wie bereits beschrieben eine SQLite-Datenbank, welche, ebenfalls wie auch das zum Auslesen verwendete Python-Skript, auf dem Raspberry Pi beheimatet ist.
Die Datenbank besteht aus drei Tabellen: User, CoffeeLevel und UserCoffeeLevel.
Die Tabelle User enthält dabei alle registrierten Benutzer. D.h. registriert sich ein Benutzer über das Webfrontend, wird eine Zeile in dieser Tabelle angelegt.
Die Tabelle CoffeeLevel enthält die Messdaten der Kaffeemaschine, d.h. diese Tabelle wird kontinuierlich vom o.a. Python-Skript gefüttert und speichert somit pro übermittelter Messung den Füllstand inklusive des Zeitpunktes der Messung.
Die Tabelle UserCoffeeLevel enthält die Daten über durchgeführe Kochvorgänge, d.h. wird ein Kochvorgang durchgeführt und dieser anschließend über das Webfrontend einem User zugeordnet, wird der Kochvorgang in Form einer Zeile in dieser Tabelle festgehalten.

**Datenbankmodell**

![BLABLA](https://raw.githubusercontent.com/Leedwing/msc-iot-coffeemashine-rewarding-system/DB_Modell.png "Datenbankmodell")


### REST-Services

## Ergebnis
### Bewertungssytem-Webfrontend
GRAFIK

kurze Beschreibung

### Übersicht REST-Services
SWAGGER-Screenshot

kurze Beschreibung

### Beispielanwendungen der Services
kurze Beschreibung der Anwendungsmöglichkeiten (Was kann ich bspw mit Alexa abfragen, welchen mehrwert?)
