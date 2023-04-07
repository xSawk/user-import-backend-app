# User Import Application

The application allows for importing user data from a JSON file, saves it to a database, and then displays a list of users with sorting and searching capabilities.



It consists of three screens:

- A home page that contains two navigation buttons
- A page with a form allowing to choose a file for import
- A page displaying a list in the form of a table with users

# Used Technologies

**Backend**

- Java 17
- Spring Boot
- MySQL
- JPA/Hibernate
- Maven 
- Docker

**Frontend**

- Angular
- Angular Material UI
- TypeScript
- HTML5
- Sass


# Features

- Importing user data from a JSON format file
- Sorting users in the table by a chosen column (first name, last name, login)
- Searching for a specific user based on their first name, last name, or login
- Anonymizing data by adding an MD5 hash to last names


# Installation

### **Backend**

Navigate to the project directory and compile the project using Maven:
```sh
mvn clean install
```  
Configure or run a container for MySQL using Docker Compose:
```sh
Default configuration

spring.datasource.url=jdbc:mysql://localhost:3306/db_test
spring.datasource.username=root
spring.datasource.password=qwerty
``` 
```sh
or docker-compose up
```  
Run the application:
```sh
mvn spring-boot:run
```  
The application should now be running at http://localhost:8080

### **Frontend**

Navigate to the project directory (frontend4system) and install dependencies using npm:
```sh
npm ci
```  
Run the application:
```sh
npm start
```  
The application should now be running at http://localhost:4200

# User Data Files

To generate data, I used the tool https://json-generator.com/. Sample files are located in the data/examples folder, and they should be selected from this location.

```sh
  {

      "users": [
        '{{repeat(60000)}}',
        {
          "name": "name{{index()}}",
          "surname": "surname{{index()}}",
          "login": "login{{index()}}"
        }
      ]
    
  }
```  
The file structure looks as follows:
```sh
{
  "users": [
    {
      "name": "name0",
      "surname": "surname0",
      "login": "login0"
    },
    {
      "name": "name1",
      "surname": "surname1",
      "login": "login1"
    },
    ...
    {
      "name": "nameN",
      "surname": "surnameN",
      "login": "loginN"
    }
  ]
}
    

```  



