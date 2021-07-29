# sample app for a RESTful random number generator service

HOW TO RUN:

This project was generated with maven support

1. Project über Git in IDE einbinden
2. run 'mvnw spring-boot:run'

Danach wird der Server lokal gestartet.

Die App ist erreichbar über "localhost:8080"

Zur Funktion: Um eine random Zahl generieren zu lassen, rufe man die URL 'localhost:8080/random/{id}' auf, wobei '{id}' die ID der Resource sei.

Beispiel: Der Aufruf mit URL "localhost:8080/random/1" liefert eine Resource mit ID '1' und dazugehöriger Zufallszahl als JSON zurück.

ID-Nummern können nur ganze Zahlen sein.


Tests oder ansprechendes Front-End wurden nicht implementiert.
