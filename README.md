# URLShortenerApi
URL Shortener API

Demo of a Web Application that exposes an API, which shortens a url that has been specified and some statistics about his used.

### About the application ###

Web application developed in Java language. Implementing a simple architecture for the development of a RESTFul API using the "Spring Boot" framework.

This API consists of 5 main components:

1. The "Main" class is what is the responsibility to lift the service.
2. The "Controller" Classes that exposes the main API "endpoints".
3. The "Service" Classes are responsible for encapsulating and implementing the business logic.
4. The "Repository" Class that is responsible for accessing the database.
5. The "Dto" class that functions as "Data Transfer Object" encapsulating the data and representing the API response

This application was created with a project using the Eclipse development IDE.

### About version ###

It is the initial version of the development.

* Version: 1.0

### Configuration and test ###

#### Clone this repository ####

Download the source code to your local development environment:

```
git clone https://github.com/Rart3001/URLShortenerApi
```

Go to the URLShortenerApi folder:

```
cd URLShortenerApi
```

#### Compile and run the App ####

Compile the application and download its dependencies with the following command.

```
  mvn install
```

#### Start the server ####

```
java -jar target / URLShortenerApi-0.0.1-SNAPSHOT.jar

```

#### Proof that the application is active ####

 
Enter your web browser and place the following address:

[http://localhost:8080/api/v1/short/status](http://localhost:8080/api/v1/short/status)


If everything goes well you can see in your browser the following message.

> Service running! :)

####  Endpoints availables #### 

(GET) http://localhost:8080/api/v1/short/status

(POST) http://localhost:8080/api/v1/short/ + www.mylargeurl.com... "url to shorten in the body request"

(GET) http://localhost:8080/api/v1/short/{idUrl}

(GET) http://localhost:8080/api/v1/statistics/status

(GET) http://localhost:8080/api/v1/statistics/?date=yyyy-MM-dd

(GET) http://localhost:8080/api/v1/statistics/?start_date=yyyy-MM-dd&end_date=yyyy-MM-dd


### Contribution ###

* Test writing
* Code review.
