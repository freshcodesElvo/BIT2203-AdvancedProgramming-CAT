Please Click the code tab above to view the correct structure
BIT2203 – Advanced Programming CAT

This repository contains practical implementations and demonstrations for the BIT2203 Advanced Programming cat. The project covers Java programming concepts including URL parsing, JDBC, Servlets, session management, RMI, Spring Dependency Injection, and MVC architecture.

++Topics Covered++
 
>> Java URL Parsing
>> JDBC Database Connectivity
>> Servlet Lifecycle
>> Session Management
>> Java RMI
>> Spring Dependency Injection
>> Inversion of Control (IoC)
>> MVC Architecture
>> DAO Pattern
>> Repository Pattern
>> JSP
>> Library Management System


++Project Structure++


BIT2203-AdvancedProgramming-CAT/
│
├── lib/
│   ├── mysql-connector-j-26.7.0.jar
│   ├── spring-aop-6.2.19.jar
│   ├── spring-beans-6.2.19.jar
│   ├── spring-context-6.2.19.jar
│   ├── spring-core-6.2.19.jar
│   ├── spring-expression-6.2.19.jar
│   └── spring-jcl-6.2.19.jar
│
├── src/
│   ├── AppConfig.java
│   ├── Book.java
│   ├── BookController.java
│   ├── BookDAO.java
│   ├── LifecycleDemoServlet.java
│   ├── RMIClient.java
│   ├── RMIServer.java
│   ├── ShoppingCartServlet.java
│   ├── TemperatureConverter.java
│   ├── TemperatureConverterImpl.java
│   ├── URLParser.java
│   ├── UniversityDatabase.java
│   ├── UserRepository.java
│   └── UserService.java
│
├── webapp/
│   └── bookList.jsp
│
├── .gitignore
│
└── README.md

Directory Description
..................................................................................
 Directory/File  Purpose                                                    
 ..............................................................................
 `src/`          Contains the Java source code and implementations.         
 `lib/`          Contains external JAR dependencies used by the project.    
 `webapp/`       Contains JSP/web resources for the web-based applications. 
 `.gitignore`    Specifies files that should not be tracked by Git.         
 `README.md`     Provides documentation for the project.                    
..................................................................................

Libraries and Dependencies

The project uses external JAR files stored in the `lib/` directory.

MySQL Connector/J

mysql-connector-j-26.7.0.jar

Used to provide JDBC connectivity between Java applications and a MySQL database.

It is used by:
UniversityDatabase.java


++Spring Framework++
The project includes the following Spring libraries:

.................................................................................
 Library                         Purpose                                    
.................................................................................
 `spring-aop-6.2.19.jar`         Spring Aspect-Oriented Programming support 
 `spring-beans-6.2.19.jar`       Spring Bean functionality                  
 `spring-context-6.2.19.jar`     Application context and configuration     
 `spring-core-6.2.19.jar`        Core Spring functionality                  
 `spring-expression-6.2.19.jar`  Spring Expression Language support         
 `spring-jcl-6.2.19.jar`         Spring logging abstraction 
 .....................................................................................                

These libraries are used by the Spring Dependency Injection example.


++Implementations++

1. URL Parsing

File: `URLParser.java`

Demonstrates how Java can parse a URL and extract information such as:

>> Protocol
>> Host
>> Port
>> Path
>> Query information



2. JDBC University Database

File: UniversityDatabase.java
Demonstrates database connectivity using JDBC (Java Database Connectivity) and MySQL.

The implementation demonstrates:
>> Establishing a database connection
>> Executing SQL statements
>> Retrieving database records
>> Working with a relational database



3. Servlet Lifecycle

File: LifecycleDemoServlet.java

Demonstrates the lifecycle of a Java Servlet.

text
        init()--> service()-->destroy()

The servlet is initialized by the servlet container, processes requests through its service methods, and is eventually destroyed.


4. Session Management

File: ShoppingCartServlet.java
Demonstrates HTTP session management using a shopping cart scenario.
Sessions allow information associated with a user to be maintained across multiple HTTP requests.



5. Java RMI

Files:
>> RMIClient.java
>> RMIServer.java
>> TemperatureConverter.java
>> TemperatureConverterImpl.java

Demonstrates Java Remote Method Invocation (RMI)

The application separates the remote service into a server and client. The client can invoke methods provided by the remote temperature conversion service.


RMI Client --------------------------->RMI Server ------>Temperature Converter
               Remote Method Call


6. Spring Dependency Injection

Files:

AppConfig.java
UserService.java
UserRepository.java
Demonstrates Dependency Injection (DI) using the Spring Framework

Instead of UserService creating its own UserRepository, Spring manages and provides the dependency.

        Spring Container -> UserRepository -> UserService

This demonstrates the principle of Inversion of Control (IoC), where the responsibility for creating and managing objects is transferred to the Spring container.


7. MVC Library Management System
The project includes a simple Library Management System demonstrating the Model-View-Controller (MVC) architecture.

Components
..........................................................................................................
 Component      File                   Responsibility 
 .........................................................................................................                                         
 Model         `Book.java`             Represents book data                                    
 Controller    `BookController.java`   Handles application requests and coordinates operations 
 DAO           `BookDAO.java`          Handles database/data-access operations                 
 View          `bookList.jsp`          Displays the list of books to the user   
 ..........................................................................................................               

MVC Flow

        User --> BookController.java --> BookDAO.java --> Data Source --> BookController.java --> bookList.jsp --> User


++Model++

`Book.java` represents the book entity and contains the data associated with a book.

++Controller++

BookController.java` acts as the controller. It receives requests and coordinates communication between the view and data-access layer.

`BookDAO.java` handles operations related to accessing book data.

++View++

`bookList.jsp` is the presentation layer. It displays book information to the user using JSP.

This separation of responsibilities makes the application easier to understand, maintain, and extend.


++Technologies Used++

>> Java
>> JDBC
>> MySQL
>> Java Servlets
>> JSP
>> Java RMI
>> Spring Framework
>> MVC Architecture
>> Apache Tomcat
>> Git
>> GitHub


++ How to set up++

++Prerequisites++

The following software is recommended:

>> Java JDK
>> MySQL
>> Apache Tomcat
>> A Java IDE such as IntelliJ IDEA, Eclipse, or NetBeans

++Clone the Repository++

git clone https://github.com/freshcodesElvo/BIT2203-AdvancedProgramming-CAT.git
cd BIT2203-AdvancedProgramming-CAT

++External Libraries++

The required JAR dependencies are included in the `lib/` directory.
When running the project manually, make sure the required JAR files are added to the project's classpath.
For the web-based applications, deploy the application to a compatible servlet container such as Apache Tomcat.


++Purpose++

The purpose of this repository is to demonstrate practical understanding of concepts covered in BIT2203 Advanced Programming through working Java implementations.

Each implementation focuses on a specific programming concept and demonstrates how it can be applied in practical software development.


++Author++

Elvis Mudamba

BIT2203 – Advanced Programming
