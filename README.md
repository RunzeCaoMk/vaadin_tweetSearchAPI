# Vaadin App -- Twitter API

building with npm version 8.11.0
JDK 14

This project is tweet searching API that contains a card view of searching result. 

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/myapp-1.0-SNAPSHOT.jar`

## Project structure

- `views` package in `src/main/java` contains the server-side Java views of the application.
- `service` package in `src/main/java` contains the service that call the retrieve the data.
- `security` package in `src/main/java` contains the login page service and catch.
- `repository` package in `src/main/java` contains the HTTP connection setting for Twitter API.
- `models` package in `src/main/java` contains the class entities of Twitter API's response.
- `views` folder in `frontend/` contains the client-side JavaScript views of the application.
- `themes` folder in `frontend/` contains the custom CSS styles.

## Deploying using Docker

To build the Dockerized version of the project, run

```
docker build . -t myapp:latest
```

Once the Docker image is correctly built, you can test it locally using

```
docker run -p 8080:8080 myapp:latest
```
# vaddinApp
