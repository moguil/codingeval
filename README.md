#Coding Evaluation

Restfull App to store request sent from customer using Spring Boot, H2, JPA

## Run and compile 

In root folder of the app (/requeststat) run the following command
```bash
mvn spring-boot:run
```

or import the the application as a maven project in an IDE
and run RequeststatApplication as a Java application

The app will start running at <http://localhost:8080>


The application uses a H2 database that is store in memory and so does not require any particular initializaton

## GET the tables

To retrieve a table of all customers:

    GET /customers

To retrieve a table of all requests
    
    GET /requests

To retrieve all requests made by a specific customer
    
    GET /requests/customers/{customerId}

To retrieve all requests made on a specific day
    
    GET /requests/days/{day}

## Send requests with PUT

To store the request with one entry per hour per customer:
    
    PUT /requests/{id}

##Resources used

Packt RESTful Java WebServices 3rd Edition by B.M. Balachandar

3 online courses available on Udemy:
-Master Java Web Services and REST API with Spring Boot
<https://www.udemy.com/spring-web-services-tutorial>
-Spring & Hibernate for Beginners
<https://www.udemy.com/spring-hibernate-tutorial/>
- API and Web Service Introduction 
<https://www.udemy.com/api-and-web-service-introduction/>



https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#_native_queries
https://www.baeldung.com/global-error-handler-in-a-spring-rest-api
https://stackoverflow.com/questions/17326976/spring-rest-using-jackson-400-bad-request-logging#17327843
https://stackoverflow.com/questions/8262333/convert-epoch-seconds-to-date-and-time-format-in-java
https://stackoverflow.com/questions/25229124/format-instant-to-string






