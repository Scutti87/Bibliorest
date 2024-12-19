Gestione Biblioteca - Web App

Descrizione: Questa è una Web App per la gestione di una biblioteca, sviluppata utilizzando Spring Boot, JPA, e un database MySQL. L'applicazione consente di gestire i libri in biblioteca, permettendo operazioni come l'inserimento, la ricerca e il prestito. I dati relativi agli Autori, Editori, Operatori e Utenti sono già presenti nel database, ma in un contesto reale sarebbe necessario aggiungere tutte le operazioni CRUD (Create, Read, Update, Delete) per ciascuna di queste entità.
Tecnologie Utilizzate:

    Spring Boot: per la creazione di una RESTful Web Application.
    JPA (Java Persistence API): per l'interazione con il database MySQL.
    MySQL: come sistema di gestione del database.
    RestTemplate: per l'integrazione con altri servizi tramite chiamate REST.
    Postman: per testare le API.
    Swagger: per la documentazione interattiva delle API.

Funzionalità:

    Gestione Libri:
        Inserimento dei libri (i dati relativi ad Autori, Editori, Operatori e Utenti devono essere già presenti nel database).
        Ricerca dei libri con filtri per Autore, Editore, e altri parametri.
        Prestito dei libri agli utenti (funzione di prestito, con gestione delle date di restituzione).

    Gestione Utenti:
        Gli utenti possono prendere in prestito i libri disponibili.
        Ogni utente può vedere i libri che ha preso in prestito e la relativa data di restituzione.

        Documentazione Swagger:

La documentazione interattiva dell'API è disponibile tramite Swagger all'indirizzo:

http://localhost:8080/swagger-ui/

Swagger fornisce una vista completa di tutti gli endpoint disponibili, inclusi i dettagli su ciascun metodo HTTP, parametri, risposte e codici di stato.
