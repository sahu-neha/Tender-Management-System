> # Tender Management System

![tms](https://user-images.githubusercontent.com/109987397/236569887-8214b120-29f1-4245-8783-69e9630b246b.png)

> ## Domain Description

The Tender Management System is a web-based application designed for companies to manage tenders, empaneled vendors, and bids. The system has two types of users: administrators and vendors. Administrators can create new tenders, view all the vendors and tenders, and assign tenders to vendors. Vendors can view current tenders, place bids, view their bid history, and search for tenders by tender id or date range.

<!--
> ## Domain Description
Whenever a company requires a service/merchandise, a tender is floated. The company maintains an empaneled list of Vendors. An empaneled vendor can only bid for a tender. Every vendor can bid only once against each tender. Against each tender, there may be bids from several vendors. The company will then select the most suitable bid and places the order with that vendor. 
-->

> ## REST A.P.I.
The API is designed to provide a wide range of functionalities for managing tenders, vendors, and bids along with different functionalities of admin and its information.
It offers features for browsing for tenders, including the ability to place a bid for any tender against each other, to the vendors. It also supports CRUD operations for managing the data.
The application also includes user and admin validation and authentication.

> ## Users in the System
1. Administrator
2. Vendor

> ## Administrator Functions
1. View all the vendors.
2. Create new tenders.
3. View All the Tenders.
4. Update Existing Tender's Details.
5. Delete A Tender.
6. View All the Tenders according to its status (Available/Booked).
7. View All the Bids of a tender.
8. Assign tender to a vendor.
9. Deactivate a vendor.
10. Bar particular vendors from participating in the tender bid.

> ## Vendor Functions
1. Login with their account.
2. Update his account details and change password.
3. View all the current Tenders.
4. Place a Bid against a Tender.
5. View his own Bid History with bid status.
6. Search for a tender by tender id or date range.


> ## Tech Stack

- JAVA
- SPRING
- SPRINGBOOT
- HIBERNATE
- MAVEN
- J.D.B.C
- MYSQL
- JPQL
- POSTMAN
- HTML
- CSS
- JAVASCRIPT

> ## Dependencies

- SPRING DATA JPA
- SPRING BOOT DEVTOOLS
- SPRING WEB
- HIBERNATE
- MYSQL DRIVER
- VALIDATION
- LOMBOK
- SWAGGER UI


> ## Setting & Installation 

Install the Spring Tools Suite 
```bash
https://spring.io/tools
```

Install MySQL Community Server

```bash
https://dev.mysql.com/downloads/mysql/
```

Clone the Repository

```bash
git clone hhttps://github.com/sahu-neha/clever-flesh-3840.git
```

Open MySQL Server
```bash
Create a New Database in SQL: "TMS" 
```

> ## Run Locally

Go to the Project Directory

```bash
Open the Tender-Management-System Folder with S.T.S
```

Go to **src/main/resources > application.properties** & change your username and password (MySQL server username & password)

```bash
spring.datasource.username="username"
spring.datasource.password="password"
```

To change the **Server Port**

```bash
server.port=8080
```

Go to **com.masai package > TenderManagementSystemApplication.java**

```bash
Run as Spring Boot App
```

Open the following URL for Swagger-UI 
```bash
http://localhost:8080/swagger-ui/
```

> ## URL
```bash
http://localhost:8080
```

> ## ER Diagram

//


> ## Contributors

#### Neha Sahu

> Github: [sahu-neha](https://github.com/sahu-neha) 
(Teamlead)

> => created the controller of Admin.

> => Implemented the service methods of Admin.

> => Implemented the UI/Front-end for Admin Panel.

#### Hoshiyar Singh Jyani

> Github: [hoshiyarjyani](https://github.com/hoshiyarjyani)

> => Created controller of Vendor.

> => Implemented the service methods of Vendor.

> => Implemented the UI/Front-end for Vendors.

#### Paras Jamwal

> Github: [ParasThakur199](https://github.com/ParasThakur199)

> => Created controller of User Log In, Bid.

> => Implemented the service methods of User Log In, Bid.

> => Implemented the UI/Front-end for User Login.

