# SpringBootScaffold
`SpringBootScaffold` is a scaffold for Spring Boot project. It contains basic configurations and common used components.
- Spring Boot: `3.1.0`
  - Spring JPA
  - Spring Web
  - Thymeleaf
  - Validation
  - Spring Test
- Database Connector:
  - H2 Database: `2.2.224`
  - MySQL Connector: `8.2.0`
  - PostgreSQL: `42.7.1`
- Spring Doc (Swagger): `2.3.0`
- Lombok: `1.18.30`
- Mapstruct: `1.5.5.Final`


## 1 Run in IDEA IDE
<details>
<summary>Click to expand</summary>

1. Make sure your IDEA IDE setting to JDK 17.
   ![](ide.png)
2. Run `MainApplication.java` to start the server.
3. Open [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) to see the swagger doc.
4. The data will save to H2 database file `./springboot_scaffold.mv.db` by default.
</details>

## 2 Database configuration
<details>
<summary>Click to expand</summary>

**SpringBootScaffold** uses `H2` memory database default. It can be changed easily to other database by specifying environment variables or `application.yml`.

Following shows how to change by environment variables.

### 2.1 H2 database (default)
H2 is **DEFAULT database** for **SpringBootScaffold**. Its configuration is:
```dotenv
DB_JDBC_URL=jdbc:h2:mem:springboot_scaffold
DB_USERNAME=sa
DB_PASSWORD=password
DB_DRIVER_CLASS=org.h2.Driver
DB_JPA_DIALECT=org.hibernate.dialect.H2Dialect
```
Once Spring Boot started, H2 can be access by [http://localhost:8080/h2-console](http://localhost:8080/h2-console).

### 2.2 MySQL
Create a MySQL database named `springboot_scaffold`, then setup environment variables as following (change accordingly):
```dotenv
DB_JDBC_URL=jdbc:mysql://localhost:3306/springboot_scaffold?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=GMT%2B8
DB_USERNAME=root
DB_PASSWORD=12345678
DB_DRIVER_CLASS=com.mysql.cj.jdbc.Driver
DB_JPA_DIALECT=org.hibernate.dialect.MySQLDialect
```

### 2.3 PostgreSQL
Create a PostgreSQL database named `springboot_scaffold`, then setup environment variables as following (change accordingly):
```dotenv
DB_JDBC_URL=jdbc:postgresql://localhost:5432/springboot_scaffold
DB_USERNAME=postgres
DB_PASSWORD=12345678
DB_DRIVER_CLASS=org.postgresql.Driver
DB_JPA_DIALECT=org.hibernate.dialect.PostgreSQLDialect
```
</details>

## 3 How to Build Jar
<details>
<summary>Click to expand</summary>

```shell
java --version  # make sure your java version is 17
./gradlew clean build
java -jar build/libs/SpringbootScaffold.jar
```
</details>

## 4 One Click Deployment

[![Deploy to Render](https://render.com/images/deploy-to-render-button.svg)](https://render.com/deploy?repo=https://github.com/runlala/SpringBootScaffold.git) (free)


[![Deploy to DigitalOcean](https://www.deploytodo.com/do-btn-blue.svg)](https://cloud.digitalocean.com/apps/new?repo=https://github.com/runlala/SpringBootScaffold/tree/main&refcode=026c8249359c)

[![amplifybutton](https://oneclick.amplifyapp.com/button.svg)](https://console.aws.amazon.com/amplify/home#/deploy?repo=https://github.com/runlala/SpringBootScaffold) (AWS)


