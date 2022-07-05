# About
This project is a simple portfolio backend , 
writer can add here contact and formation and 
experience and some skills and languages or update it 

# Setup
```
> git clone https://gitlab.com/anasabbal/nPortfolio.git
> cd nPortfolio
> mvn clean compile
> mvn spring-boot:run
```
# Database Setup 
`application.yml`
```
datasource:
    driver-class-name: org.postgresql.Driver
    url: ${DATABASE_URL:jdbc:postgresql://localhost:5432/xPortfolio}
    username: ${DATABASE_USER:postgres}
    password: ${DATABASE_PASSWORD:postgres}
```

# Login
```
username = admin
password = admin
```

# Swagger documentation
```
http://localhost:8080/api/swagger-ui.html#/
```