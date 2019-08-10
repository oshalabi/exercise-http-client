<!--- 37 --->
# Introductie
Deze oefening is deel van de DEA Course aan de Hogeschool Arnhem/Nijmegen. 
Onderwerp is ervaring opdoen met de cient-kant van HTTP-verkeer. Concreet zullen we ingaan
op de HTTP-Client uit de Java JDK en Asynchroon programmeren.

# Oefening
Voor deze oefening is al een gedeeltelijke applicatie gemaakt. Namelijk een zeer elementaire
*Console Browser*. Na het opstarten van de `main` methode uit de klasse `DeaConsoleBrowser`, 
wordt een console-applicatie opgestart waarbinnen het mogelijk is Http-Requests uit te
voeren en die de body van de Http-Response in de console afdrukt. Er is een keuzemenu van
uit te voeren requests, waarbij het de oefening is om met behulp van de Http-Client API deze
requests ook daadwerkelijk uit te voeren. Hierbij maken we kennis met
* Uitvoeren van verschillende Http-methodes
* Content-negotiation
* Synchroon en Asynchroon uitvoeren van requests

## 1: De GitHubService
De `GitHubService` is verantwoordelijk voor alle requests naar *https://github.com*. De requests zullen
synchroon zijn en het betreft een tweetal GET-requests.

### 1.1: Synchroon request naar *github.com*
Implementeer de methode `getIndexHtml()`:
* Maak een GET request naar *github.com*
* Retourneer de *body* van de *response*

Test je implemetatie op de volgende twee manieren:
* Voer de betreffende test uit `GithubServiceTest` uit 
* Start de applicatie op en selecteer het juiste menu-item

### 1.2: Synchroon request naar deze *README.md*
Implementeer de methode `getReadme()`:
* Maak een GET request naar de correcte *url*. Probeer eerst via de browser te achterhalen wat
die correcte url is. Merk op dat je een request wilt naar de *raw* versie. 
* Retourneer de *body* van de *response*

Test je implemetatie op de volgende twee manieren:
* Voer de betreffende test uit `GithubServiceTest` uit 
* Start de applicatie op en selecteer het juiste menu-item

## 2: De JsonPlaceHolderService
De `JsonPlaceHolderService` is verantwoordelijk voor alle requests naar *https://jsonplaceholder.typicode.com/*. 
Deze url kan gebruikt worden voor het testen van een Http-client en ondersteunt verschillende Http-methodes. Als 
response wordt een [JSON](https://www.json.org/) bestand gestuurd. Dit is een formaat dat vaak gebruikt wanneer er via Http data (en dus niet
html-bestanden) wordt uitgewisseld. 

[JSON](https://www.json.org/) -bestanden bevatten een structuur die omgezet kan worden naar Java-Objecten. Daarmee is het dus mogelijk om via
[JSON](https://www.json.org/) en Http, Java-Objecten uit te wisselen.  De bestaande applicatie bevat al klasse die dit voor je kan doen, een 
zogenaamde *DataMapper*, genaamd `TodoMapper`.

### 2.1: Het asynchroon ophalen van [JSON](https://www.json.org/)
Implementeer de methode `getTodos()`:
* Maak een **asynchrone** GET naar de url *https://jsonplaceholder.typicode.com/todos*
* Deze methode is `void` en hoeft dus niks te retourneren
* Gebruik de `thenAccept()` om de `body` van de `response` te printen naar `system.out`

### 2.2: Het gebruik van een *Lambda*-expressie voor het doen van een Callback
Implementeer de methode `getTodosWithCallback`. We halen dus dezelfde data op als in de voorgaande oefening, 
maar nu gebruiken we een callback om de `ConsolePrinterService` de `body` van de `response` naar `system.out`
te printen. 

* Maak een **asynchrone** GET naar de url *https://jsonplaceholder.typicode.com/todos*
* Deze methode is `void` en hoeft dus niks te retourneren
* Merk op dat de methode nu een parameter verwacht van het type `Consumer<String> callback`. Dit kan
een *lambda*-expressie zijn die in de `thenAccept()` wordt uitgevoerd.
* Refactor je applicatie waar nodig. Mogelijk heb je *magic-strings* of *duplicate-code* die een 
refactorslag verdienen.

### 2.3: Het verzenden van een POST-Request op basis van de opgehaalde [JSON](https://www.json.org/)

## De GitHubService



