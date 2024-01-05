# SpringBootScaffold
`SpringBootScaffold` is a scaffold for Spring Boot project. It contains basic configurations and common used components.
- Spring Boot: `3.1.0`
  - Spring JPA
  - Spring Web
  - Spring Test
  - Thymeleaf
- Spring Doc (Swagger): `2.3.0`
- Lombok: `1.18.30`
- MySQL Connector: `8.0.33`
- Mapstruct: `1.5.5.Final`


## How to use
1. Make sure your IDEA IDE setting to JDK 17.
   ![](ide.png)
2. Create a MySQL database named `springboot_scaffold`.
3. Change MySQL connection string in `application.yml`, or add environment variables. Default MySQL configuration is:
    - host: `localhost`
    - port: `3306`
    - database: `springboot_scaffold`
    - username: `root`
    - password: `12345678`
4. Run `MainApplication.java` to start the server.
5. Open `http://localhost:8080/swagger-ui/index.html` to see the swagger doc.

## How to Build Jar
```shell
java --version  # make sure your java version is 17
./gradlew clean build
java -jar build/libs/scaffold-0.0.1.jar
```


## One key deploy

### Deploy to Fly.io
### Deploy to render.com
### Deploy to Heroku