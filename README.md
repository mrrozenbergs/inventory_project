# Spring Boot Inventory system Web App invenIT

## About

This is a demo project for practicing Spring + Thymeleaf. The idea was to build some basic shopping cart web app.

It was made using **Spring Boot**, **Spring Security**, **Thymeleaf**, **Spring Data JPA**.
**mySQL** database.

There is a login functionality, admin panel.
Clients can order products. Each user has his own shopping cart (session functionality).
Clients can have more then one user. Checkout is transactional.

## Configuration

### Configuration Files

Folder **src/resources/** contains config files for **shopping-cart** Spring Boot application.

* **src/resources/application.properties** - main configuration file. In this file You must change database, database user, password.

## How to run

When You done with database setup start Maven project.
Hibernate will create all tables for You and then in project folder find import_database.sql with queries for set up demo data for our aplication!
This will create our admin user to login into app later on.


Once You done, just restart the app. When it starts, go to the web browser and visit `http://localhost:8080`

Admin username: **user**

Admin password: **password**

User username: **xxx**

User password: **password**

You Can create new users in admin panel - Client directory.
