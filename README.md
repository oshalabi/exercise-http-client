<!--- 37 --->
# Introductie
*Deel van de DEA Course aan de Hogeschool Arnhem/Nijmegen.*

Doel van deze oefening is ervaring opdoen met de client-kant van HTTP-verkeer. Concreet gaan we in op de HTTP-Client uit de Java JDK en asynchroon programmeren.

# Oefening
Voor deze oefening krijg je een gedeeltelijke applicatie. Namelijk een zeer elementaire
*Console Browser*. De de `main` methode uit de klasse `DeaConsoleBrowser` start een console-applicatie op die HTTP requests uit kan voeren en de body van de HTTP response in de console afdrukt. Er is een keuzemenu van uit te voeren requests, waarbij je in de oefening mogelijk moet maken om met behulp van de Http-Client API deze requests ook daadwerkelijk uit te voeren. 

## 1: De GitHubService
De `GitHubService` is verantwoordelijk voor alle requests naar *https://github.com*. De requests zijn synchroon en het betreft een tweetal GET-requests.

### 1.1: Synchroon request naar *github.com*
Implementeer de methode `getIndexHtml()`:
* Maak een GET request naar *github.com*
* Retourneer de *body* van de *response*

Test je implementatie op de volgende twee manieren:
* Voer de betreffende test uit `GithubServiceTest` uit 
* Start de applicatie op en selecteer het juiste menu-item

### 1.2: Synchroon request naar deze *README.md*
Implementeer de methode `getReadme()`:
* Maak een GET request naar de correcte *url*. Probeer eerst via de browser te achterhalen wat
die correcte url is. Merk op dat je een request wilt naar de *raw* versie, klik hiervoor bij de file in GitHub op de RAW-knop en kopieer de URL die nu in de browser staat. 
* Retourneer de *body* van de *response*

Test je implementatie op de volgende twee manieren:
* Voer de betreffende test uit `GithubServiceTest` uit 
* Start de applicatie op en selecteer het juiste menu-item

## 2: De JsonPlaceHolderService
De `JsonPlaceHolderService` is verantwoordelijk voor alle requests naar *https://jsonplaceholder.typicode.com/*. 

Met deze url kun je je HTTP client testen, en deze ondersteunt verschillende Http-methodes. Als response stuurt deze site je een [JSON](https://www.json.org/) bestand. JSON is een vaakgebruikt formaat wanneer webservices via HTTP data uitwisselen (JSON vervangt dan dus HTML, waarvoor Tim Berners Lee HTTP initieel maakte, maar wat geschikt is voor mensen dan voor systemen/applicaties onderling).

[JSON](https://www.json.org/) -bestanden bevatten een structuur die je kunt omzetten naar Java-Objecten. Daarmee is het dus mogelijk om via [JSON](https://www.json.org/) en Http, Java-Objecten uit te wisselen.  De bestaande applicatie bevat al een klasse die dit voor je kan doen, een zogenaamde *DataMapper*, genaamd `TodoMapper`.

### 2.1: Het asynchroon ophalen van [JSON](https://www.json.org/)
Implementeer de methode `getTodos()`:
* Maak een **asynchrone** GET naar de url *https://jsonplaceholder.typicode.com/todos*
* Deze methode is `void` en hoeft dus niks te retourneren
* Gebruik de `thenAccept()` om de `body` van de `response` te printen naar `system.out`

Test je implementatie op de volgende manier:
* Start de applicatie op en selecteer het juiste menu-item

### 2.2: Het gebruik van een *Lambda*-expressie voor het doen van een Callback
Implementeer de methode `getTodosWithCallback`. We halen dus dezelfde data op als in de voorgaande oefening, 
maar nu gebruiken we een callback om de `ConsolePrinterService` de `body` van de `response` naar `system.out`
te printen. 

* Maak een **asynchrone** GET naar de url *https://jsonplaceholder.typicode.com/todos*
* Deze methode is `void` en retourneert dus niks
* Merk op dat de methode nu een parameter verwacht van het type `Consumer<String> callback`. Dit kan een *lambda*-expressie zijn die de `thenAccept()` dan (pas) uitvoert.
* Refactor je applicatie waar nodig. Mogelijk heb je *magic-strings* of *duplicate-code* of andere code smells die een refactorslag verdienen.

Test je implementatie op de volgende manier:
* Start de applicatie op en selecteer het juiste menu-item

### 2.3: Het verzenden van een POST-Request op basis van de opgehaalde [JSON](https://www.json.org/)
Implementeer de methode `createNewTodoItemOnServer()`. Deze methode verstuurt eerst een GET versturen, waarna een POST volgt. Beide zijn asynchroon, zodat de `thenAccept` veel werk moet zetten. Hierbij geeft deze de Lambda-expressie die als Callback dient vanuit het eerste request (de GET) doorgegeven aan het tweede request (de POST). Pas in de `thenAccept` van het tweede request roep je de callback aan.

* Maak een **asynchrone** GET naar de url *https://jsonplaceholder.typicode.com/todos*
* Gebruik de `thenAccept` om de [JSON](https://www.json.org/) via de aangeleverde `TodoMapper` om te zetten naar een `TodoDto[]`.
* Bepaal hoe lang deze array is en bepaal op basis hiervan het `id` van het nieuw te maken `TodoItem`. Gebruik de aangeleverde methode `createNewTodoItem()` om hiermee een nieuw `TodoItem` te maken.
* Maak een **asynchrone** POST naar de url *https://jsonplaceholder.typicode.com/todos* met het nieuwe `TodoItem` in de `body`.
Merk hierbij op dat de body van een request een `String` moet zijn. Je zult het Java-Object dan ook eerst moet serializeren naar [JSON](https://www.json.org/). Gebruik hiervoor weer de `TodoMapper`. Merk overigens op dat dit request normaal
gesproken de nieuwe `TodoItem` ook op de server toevoegt en je deze dus ook weer via een GET kunt ophalen.
De server is echter een gratis test-server en wekt dus enkel in zijn response de indruk ook het nieuwe `TodoItem` te hebben toegevoegd.
* Zet ook de Content-Type in de Request-header op de juiste waarde. Voor meer informatie, bekijk de [RFC](https://tools.ietf.org/html/rfc7230) van Http.
* Roep nu vanuit de `.thenAccept` van de POST de callback aan die parameter was voor methode `createNewTodoItemOnServer()`.

Test je implementatie op de volgende manier:
* Start de applicatie op en selecteer het juiste menu-item
