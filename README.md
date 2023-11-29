##  Your Library Manager

This repository will help your buid your own library manager in just a few steps using springBoot! 

## 1. Clone the repository


```bash
git clone https://github.com/Efhowell/libsys.git
cd librarydatabase

```


## 2. Dependencies

!! in pom.xml check that the version of java you are using matches the version indicated in the pom.xml. This project uses version 21. You might have to downgrade depending on what you use.

The project relies on these following dependencies. spring-boot-starter-security, spring-security-test and thymeleaf-extras-springsecurity6 are relevant can be excluded if you are not interested in having the login homepage. Make sure you use the appropriate version that can be checked at on [mvn website](https://mvnrepository.com)
```bash

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>

<dependency>
	<groupId>org.thymeleaf.extras</groupId>
	<artifactId>thymeleaf-extras-springsecurity6</artifactId>
	<version>3.1.1.RELEASE</version>
</dependency>

<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-test</artifactId>
	<scope>test</scope>
</dependency>
```


## 3. Run the springBoot app 

First install mvn

```bash
mvn clean install
```

Your springboot app should be ready to run!

```bash
mvn clean spring-boot:run 
```

Navigate you to localhost:8080 and you are good to go!

## 3. Credentials additional notes

The default credentials are:

username=admin
password=password

Update authorizations and credentials using this file: WebSecurityConfig.java

Relevant documents can be found using spring-boot documentation [spring-boot-security](https://spring.io/guides/topicals/spring-security-architecture/)
