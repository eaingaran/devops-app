# Spring Boot, MySQL, JPA, Hibernate Rest API Application

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/eaingaran/devops-app.git
```

**2. Create Mysql database**
``bash
create database notes
``

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/devops-app-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /api/notes
    
    POST /api/notes
    
    GET /api/notes/{noteId}
    
    PUT /api/notes/{noteId}
    
    DELETE /api/notes/{noteId}

You can test them using postman or any other rest client.


# DataOps
This is a simple DataOps attempt using Liquibase.. 


### Following are the commands to use this project
`mvn liquibase:update`

`mvn liquibase:updateSQL`

`mvn liquibase:rollback -DrollbackCount=1`

`mvn liquibase:rollbackSQL -DrollbackCount=1 `

`mvn liquibase:futureRollbackSQL`

`mvn liquibase:generateChangeLog -Dliquibase.diffTypes=data -DoutputChangeLogFile=output.xml`
