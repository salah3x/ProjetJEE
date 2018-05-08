# ProjetJEE
A spring boot project.

Basic crud application.

## Build and run
Spring boot maven plugin generates a standalone jar file (not  war) so we can run it without the need of an application server.
* Clone the repo 
* Check the database credentials in src/main/resources/application.properties
* Import maven project to your IDE and run it from the main class.
* or from cli :
```
mvn package && java -jar /path/to/file.jar
```
(the jar will be in target folder)
* visite http://localhost:8080

## Technologies and frameworks
This project uses :
* Maven for dependency managment.
* Spring boot for autoconfiguration.
* JPA (Hibernate) for data access (we use mysql in this case).
* Tomcat as an embedded web server.
* Thymeleaf as a template engine (parses natural html templates - no JSP).
