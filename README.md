> # Tender Management System

![tms](https://user-images.githubusercontent.com/109987397/236569887-8214b120-29f1-4245-8783-69e9630b246b.png)

> ## Domain Description

The Tender Management System is a web-based application designed for companies to manage tenders, empanelled vendors, and bids. The system has two types of users: administrators and vendors. 
<!-- Administrators can create new tenders, view all the vendors and tenders, and assign tenders to vendors. Vendors can view current tenders, place bids, view their bid history, and search for tenders by tender id or date range. -->

<!--
> ## Domain Description
Whenever a company requires a service/merchandise, a tender is floated. The company maintains an empaneled list of Vendors. An empaneled vendor can only bid for a tender. Every vendor can bid only once against each tender. Against each tender, there may be bids from several vendors. The company will then select the most suitable bid and places the order with that vendor. 
-->

> ## REST A.P.I.
The API is designed to provide a wide range of functionalities for managing tenders, vendors, and bids along with different functionalities of admin and its information.
It offers features for browsing for tenders, including the ability to place a bid for any tender against each other, to the vendors. It also supports CRUD operations for managing the data.
<!-- The application also includes user and admin validation and authentication. -->

> ## Users in the System
1. Administrator
2. Vendor

> ## Administrator Functions
1. View all vendors.
2. Create new tenders.
3. View All the Tenders.
4. Update Existing Tender's Details.
5. Delete A Tender.
6. View All the Bids of a tender.
7. Assign tender to a vendor.
8. Deactivate a vendor.
9. Bar particular vendors from participating in the tender bid.

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

Go to **Front-end > Html > index.html** on VS Code

```bash
Open with Live Server
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

![ER-Digram](https://github.com/sahu-neha/clever-flesh-3840/assets/110700928/4dcf3e86-5224-4681-b2f3-d1934157f827)

<hr>

> ## Landing Page

![Landing Page](https://github.com/sahu-neha/clever-flesh-3840/assets/109987397/ee63d660-a36f-411f-be64-5133974cfd08)

> ## Login Page

<!-- ![Login Page](https://github.com/sahu-neha/clever-flesh-3840/assets/109987397/a69d816b-e58e-425d-9f73-91401e6fec43) -->

![image](https://github.com/sahu-neha/clever-flesh-3840/assets/109987397/7358d884-5462-44e1-a578-23a2e7fdd937)

> ## Admin can create a new Tender

![Create Tender](https://github.com/sahu-neha/clever-flesh-3840/assets/109987397/4b7914e7-666a-4967-a209-353f638342f6)

> ## Admin can view list of all Tenders

![image](https://github.com/sahu-neha/clever-flesh-3840/assets/109987397/f1a7a820-89f9-40a9-8e36-2c8f9c1ceb5a)

> ## Admin can view list of all Vendors

![image](https://github.com/sahu-neha/clever-flesh-3840/assets/109987397/1ab18c89-c998-4eb9-a74f-130076425cc6)

> ## Admin can view list of all the bids for a particular tender

![image](https://github.com/sahu-neha/clever-flesh-3840/assets/109987397/4dad90fb-2e86-4785-a938-fc3ce5cb586a)

<!--  -->

> ## Vendor can create a new account by signing up

<!-- ![Vendor Created](https://github.com/sahu-neha/clever-flesh-3840/assets/109987397/9c80cd13-f78a-4118-bfc4-4052c5b858ff) -->

![Vendor Created](https://github.com/sahu-neha/clever-flesh-3840/assets/109987397/5649463b-f603-4ea1-af22-5b9b75dedc7b)


> ## Visit Vendor Portal

![Vendor Portal](https://github.com/sahu-neha/clever-flesh-3840/assets/109987397/96c90ea8-587a-41d5-8a3f-3d9cc6557f18)

> ## Vendor can view all the Tenders available for bidding

![image](https://github.com/sahu-neha/clever-flesh-3840/assets/109987397/03c2953d-a827-4fa9-868c-ff4c8504c478)

> ## Vendor can place a bid against any Tender

![image](https://github.com/sahu-neha/clever-flesh-3840/assets/109987397/df37f42f-acfd-4bcd-971f-e25616fff228)

> ## Vendor can view their bidding history

![image](https://github.com/sahu-neha/clever-flesh-3840/assets/109987397/16ea5eed-3636-4193-8e86-d50bcc6e5523)

<hr>

> ## Contributors

#### Neha Sahu

> Github: [sahu-neha](https://github.com/sahu-neha) 
(Teamlead)

> => created the controller of Admin.

> => Implemented the service methods of Admin.

> => Implemented the UI/Front-end for Admin Panel, Landing Page.

#### Hoshiyar Singh Jyani

> Github: [hoshiyarjyani](https://github.com/hoshiyarjyani)

> => Created controller of Vendor.

> => Implemented the service methods of Vendor.

> => Implemented the UI/Front-end for Vendor Portal.

#### Paras Jamwal

> Github: [ParasThakur199](https://github.com/ParasThakur199)

> => Created controller of User Log In, Bid.

> => Implemented the service methods of User Log In, Bid.

<!-- > ## Conclusion
The Tender Management System is an essential tool for companies that want to manage tenders efficiently. With this system, companies can easily manage tenders, empaneled vendors, and bids, making the tendering process more transparent and effective. -->
