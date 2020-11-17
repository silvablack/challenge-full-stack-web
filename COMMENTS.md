# Grupo A Educação Challenge

This project consist in a list and form to read, create, update and delete student.

- Student manager (register new students and retrieve student information)
- Institution (retrieve institution information)
- Course (retrieve all the courses made by a institution)

## Technology stack

This project was built using the following technologies and languages:

- Java 8
- Spring Boot
- MyBatis Persistence Framework
- Swagger
- PostgreSQL
- Docker
- Vuejs
- Vuetify
- Vuex
- ESLint
- Typescript

The frontend and backend of this project was designed with the scalability and ease of reading the code in mind.

## Project Execution

The whole project (PostgreSQL database layer + Spring Boot application layer + Frontend application layer) is containerized and can be executed having [Docker](https://docs.docker.com/get-docker/) and [docker-compose](https://docs.docker.com/compose/install/) installed on the host machine. The command that builds the project is the following:

```shell
    docker-compose up -d
```

This command will create PostgreSQL image and container with the initial configurations and registers needed by the application. It will also build the Spring Boot application inside a maven container and execute the build .jar file inside another container. Both containers are linked, so that the application can access the database. t will also build the Frontend Vue application inside a node container and execute the build inside nginx container.

Both application and database will be accessible through the following (assuming localhost as host address):

- PostgreSQL Database - localhost:5432
- Backend application - localhost:8080
- Frontend application - localhost:8090

## API Docs

Once the project is running, the API docs can be accessed at:

http://localhost:8080/swagger-ui.html

## How it works

The project features three main parts, which will be briefly presented below:

**Student management**

By default, one user is already registered in the application:

```json
{
  "registration": 1,
  "name": "Miguel",
  "cpf": "12312312399",
  "email": "miguel@email.com"
}
```

Students can be retrieved by ID through the endpoint:

    GET: http://localhost:8080/api/v1/student/1

New students can also be registered through the endpoint:

    POST: http://localhost:8080/api/v1/student

with the body as follows:

```json
{
  "name": "Miguel",
  "cpf": "12312312399",
  "email": "miguel@email.com"
}
```

Students can also be updated through the endpoint:

    POST: http://localhost:8080/api/v1/student

with the body as follows:

```json
{
  "registration": 1,
  "name": "Miguel",
  "cpf": "12312312399",
  "email": "miguel@gmail.com"
}
```

**Impediments**
Some challenge requirements could not be fully implemented, such as:

- Student editing flow
- Student delete has been blocked by CORS policy (wrong configuration for container)
- Tests on business components
- Tests on base components

Note: CORS configuration is unstable in the container
