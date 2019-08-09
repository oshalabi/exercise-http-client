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

## De GitHubService
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

## De JsonPlaceHolderService
De `JsonPlaceHolderService` is verantwoordelijk voor alle requests naar *https://jsonplaceholder.typicode.com/*. 

## De GitHubService



