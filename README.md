# About the project

During one month work on project, I had the opportunity to learn a simplified software development process, from the identification of user requirements to the concrete implementation of the application.

I went through simplified **Larman's method of software development**, which consists of 5 stages:

 - Requirements definition stage
 - Analysis stage
 - Design stage
 - Implementation stage
 - Test stage


This project includes four of them.

## Requirements definition stage

In the first phase of development, I decided to develop a system that would simplify the project management. 

For the purposes of modeling requirements, I used the *UML Use Case diagram*. I identified 8 Use Cases.

![Screenshot 2024-03-12 195802](https://github.com/pejovicanja/project-management-system-DESKTOP/assets/88293878/3c24ec7e-0fe9-4257-8286-a03a36e5e930)


Each Use Case is described in detail and these descriptions are available in the documentation, which is currently available only in Serbian language. 


## Analysis stage


As a result of the **analysis phase**, a description of the dynamics of each Use Case and the structure of the software were obtained.

An *UML System Sequence Diagram* was used to describe the dynamics of every Use Case. The purpose of these diagrams is to show the interaction of actors with the system and the messages they exchange.
Below is the example of System Sequence diagram for Login Use Case:


![image](https://github.com/pejovicanja/project-management-system-DESKTOP/assets/88293878/44f67d96-f554-4ac7-9060-195a6fdc05b6)


Conceptual model of the system is created using *UML Class Diagram*:

![image](https://github.com/pejovicanja/project-management-system-DESKTOP/assets/88293878/effc169b-83d5-4882-8811-e4f2320dd1c8)
Here is the *Relational Model*:

```
administrator (id, username, password, employmentDate) 
employee(id, firstname, lastname, birthDate, creationDate, administrator_id) 
project (id, name,  startDate, endDate, administrator_id) 
task (project_id, id, name, dueDate, taskStatus, team_id) 
team (id, name, numberOfMembers) 
membership (employee_id, team_id, joiningDate, membershipStatus) 

```
## Design stage

At the beginning of this phase, I designed *user forms* for each use case. Here are some examples of forms:

**Projects form**

![image](https://github.com/pejovicanja/project-management-system-DESKTOP/assets/88293878/94d74b80-4880-4ed4-b7d5-72e19e8bf45a)



**Employees form**

![image](https://github.com/pejovicanja/project-management-system-DESKTOP/assets/88293878/009d22b2-41ca-409e-bf3c-5bdf79be5291)

After GUI design I worked on communication between Controller and Database Broker on server side, which result in new sequential diagrams.

Here is one example of communication betweeen controller and database broker

![image](https://github.com/pejovicanja/project-management-system-DESKTOP/assets/88293878/785e2177-da3a-4310-8bc6-3d999bde548f)

In the picture below we can see the design of *Generic Database Broker*:

![image](https://github.com/pejovicanja/project-management-system-DESKTOP/assets/88293878/d3bd79e8-4ae3-4fc2-be4d-af195a60fb54)

And finally we can see the complete *architecture* of my software system:

![image](https://github.com/pejovicanja/project-management-system-DESKTOP/assets/88293878/1967dc80-255a-452b-ace4-f0941a45f2c3)

## Implementation stage

**Tech Stack:**
```
-Java SE 17
-MySQL
-JDBC API

```
**Tools:**
```
-Apache Netbeans 15
-SQLyog Community Version
```

**Short description:**

The entire application was made using Core Java, both client and server side. Things I would like to point out:

- **Generic Database Broker** is made for communication with database
- Plain java and JDBC API was used for DB communication
- FlatFlaf library is used for making GUI look prettier



## Run Locally

Clone the project

```bash
  git clone https://github.com/pejovicanja/project-management-system-DESKTOP
```
Execute DDL SQL script in some MySQL client and make sure thah the MySQL server is running.

Download and add missing JARs in Apache Netbeans IDE.

