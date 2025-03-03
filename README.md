# ToDo List Application

This is a simple ToDo List application built using Java, Jakarta Servlet, JSP, and Maven. The application allows users to add, view, and update the status of tasks.

## Features

- User authentication
- Add new tasks
- View all tasks
- Update task status (Not Started, In Progress, Completed)
- Mark tasks as completed

## Project Structure

src/  
&ensp; &ensp;main/  
&ensp; &ensp; &ensp; &ensp;java/  
&ensp; &ensp; &ensp; &ensp; &ensp;beans/  
&ensp; &ensp; &ensp; &ensp; &ensp; &ensp;Task.java  
&ensp; &ensp; &ensp; &ensp; &ensp; &ensp;Register.java  
&ensp; &ensp; &ensp; &ensp; &ensp;dao/  
&ensp; &ensp; &ensp; &ensp; &ensp; &ensp;ToDoDAOIntf.java  
&ensp; &ensp; &ensp; &ensp; &ensp; &ensp;ToDoDAOImpl.java  
&ensp; &ensp; &ensp; &ensp; &ensp;servlets/  
&ensp; &ensp; &ensp; &ensp; &ensp; &ensp;AddTaskServlet.java  
&ensp; &ensp; &ensp; &ensp; &ensp; &ensp;ChangeTaskStatusServlet.java  
&ensp; &ensp; &ensp; &ensp; &ensp; &ensp;MarkTaskCompletedServlet.java  
&ensp; &ensp; &ensp; &ensp; &ensp; &ensp;LogoutServlet.java  
&ensp; &ensp; &ensp; &ensp;resources/  
&ensp; &ensp; &ensp; &ensp;webapp/  
&ensp; &ensp; &ensp; &ensp; &ensp;index.jsp  
&ensp; &ensp; &ensp; &ensp; &ensp;ViewTasks.jsp  
&ensp; &ensp; &ensp; &ensp; &ensp;WEB-INF/  
&ensp; &ensp; &ensp; &ensp; &ensp;web.xml  
&ensp; &ensp;test/  
&ensp; &ensp; &ensp; &ensp;java/


## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Jakarta Servlet API 4.0.4
- JUnit 4.13.2
- Mockito 4.0.0

## Setup

1. Clone the repository:
    ```sh
    git clone https://github.com/GVAravind-2911/todo-list-app.git
    cd todo-list-app
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

3. Deploy the application to a servlet container (e.g., Apache Tomcat).

## Usage

1. Access the application in your web browser at `http://localhost:8080/todo-list-app`.

2. Log in with your credentials.

3. Add new tasks using the form on the main page.

4. View and update the status of tasks on the `ViewTasks.jsp` page.

