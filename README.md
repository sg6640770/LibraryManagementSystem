The Library Management System is a simple console-based application that helps librarians efficiently manage books in a library.

Technology Stack

Programming Language: Java

Database: MySQL

Database Connectivity: JDBC

Development Environment: IntelliJ IDEA

Setup & Installation

Prerequisites

Ensure you have the following installed:

Java Development Kit (JDK) 8 or later

MySQL Server

IntelliJ IDEA (or any Java IDE)

MySQL Connector/J (JDBC Driver)

##Step 1: Clone the Repository
git clone https://github.com/sg6640770/LibraryManagementSystem.git

Step 2: Set Up the MySQL Database
    1.Open MySQL Workbench or MySQL Command Line.
    2.Create a new database:
    
     CREATE DATABASE library_management_system;
     
     USE library_management_system;

    CREATE TABLE books (
    book_id INT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    availability_status BOOLEAN DEFAULT TRUE
    );

Step 3: Update Database Credentials

private static final String URL = "jdbc:mysql://localhost:3306/library_db";
private static final String USER = "your-username";
private static final String PASSWORD = "your-password";

Step 4: Compile and Run the Application

1.Open the project in IntelliJ IDEA.

2.Compile and run LibraryManagementSystem.java.

3.Follow the on-screen menu to add, update, search, or delete books.

Challenges Faced During Development:

1️⃣ Database Connectivity Issues

2️⃣ Handling User Input and Validation

3️⃣ CRUD Operations Efficiency

Future Enhancements

🌐 Convert to a Spring Boot Web Application with a REST API.

🖥️ Upgrade to a GUI-based system using JavaFX or Swing.

☁️ Deploy on a Cloud Server for remote access.
