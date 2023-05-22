# [simple sample mongo](https://github.com/sombriks/simple-sample-mongo)

Sample for [this question](https://stackoverflow.com/questions/76281550/mongodb-document-how-to-convert-into-model-class#comment134559921_76281550)

## Getting Started

This project requires 

- maven
- java 17
- docker and docker-compose

## Running

### Starting mongodb

```bash
docker-compose -f src/infrastrucutre/docker-compose-dev.yml -d up
```

### Starting spring application

```bash
./mvnw package spring-boot:run 
```

### Inserting a few items in database 

See `src/test/resources/sample-mongo.http`

## Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#web)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#data.nosql.mongodb)

## Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

