# Rev-Tech

Project 3 - E-Commerce Store (Team Project)

## Table of Contents

* [Project Description](#project-description)
* [Technologies Used](#technologies-used)
* [Project Requirements](#project-requirements)
* [Features](#features)
* [Tests](#tests)
* [Getting Started](#getting-started)
* [Application Screenshots](#application-screenshots)
* [Entity Relationship Diagram](#entity-relationship-diagram)
* [File Structure](#file-structure)
* [Team Structure](#team-structure)
* [Contributors](#contributors)

## Project Description
The Revtech E-Commerce Application is an Angular Single Page Application (SPA) that will allow users to sign up and login as a customer, browse all available products, view an individual product, and add products to their carts for purchase. Any user can browse the database of products, however, in order to purchase one you must be logged into an account. A new account can be created using the sign-up button. After an account is created the user will be able to login and purchase the products(s) of their choice. With our products route, the user is able to view all of the products we have in our database on a single page. When the user clicks on a product that they are interested in, it will redirect them to that product’s specific page to see additional details. Here, the user will be able to see the title, cost, discount and description of the product. This page will also include a button that will add the product to their cart if they would like to purchase it. The cart is the user’s final destination and where they will be able to see the products they wish to purchase, review the total costs of selected products, and also be able to check the products out to complete their purchase.

## Technologies Used
* Java (Programming Language) - version 11.0.12
* TypeScript (Programming Language)
* HTML (HyperText Markup Language)
* CSS / SCSS (Cascading Style Sheets)
* Eclipse (IDE)
* Apache Maven (Project Management)
* H2 (Database)
* Amazon Web Services - Elastic Cloud Computing (AWS EC2)
* Amazon Web Services - Simple Storage Service (AWS S3)
* Jenkins (Automation Server)
* Hibernate ORM (Object Relational-Mapping Tool)
* Spring Framework (Spring Boot, Spring Data, Spring Web, Spring AOP)
* Spring Security w/ JWT (JSON Web Token)
* JUnit 5 (Testing Framework - Back)
* Angular2+ (Web Framework)
* Jasmine / Karma (Testing Framework - Front)
* Microsoft Visual Studio Code (Source Code Editor)
* Postman (API Platform)
* Selenium(Browser Automation)

## Project Requirements
1. As a User, I should be able to register a new account.
2. As a User, I should be able to log into the application.
3. As a User, I should be able to log out of the application.
4. As a User, I should be able to see a list of available products for me to add to my cart.
5. As a User, I should be able to search the product list to better find the item(s) I am interested in.
6. As a User, I should be able to see and purchase items that are on sale for a lower price.
7. As a User, I should be able to add items to my cart that I will later purchase or remove from my cart.
8. As a User, I should be able to select an amount of an item to add to my cart as I am adding an item.
9. As a User, I should be able to checkout with the items in my cart, purchasing them and removing them from the inventory.

## Features
List of features ready and TODOs for future development
* Ability to register as a customer
* Ability to login as a customer or administrator
* Ability to view appropriate interfaces upon login dependent upon level of access (admin or customer)
* Ability to add a product to storefront as an administrator
* Ability to add a discounted product to storefront as an administrator
* Ability to update or remove a product from storefront as an administrator
* Ability to update or remove a discounted product from storefront as an administrator
* Ability to view account information as a user
* Ability to view the storefront as a user (including guest)
* Ability to view the discounted items as a user (including guest)
* Ability to view the product description page as a user
* Ability to add items to cart as a user
* Ability to select quantity of a particular item to add to cart as a user
* Ability to checkout as a user
* Ability to logout as a user
* Ability to add and view customer reviews as a user
* Ability to view orders history as a user

## Testing Status
* 76% coverage of methods in the service layer.
* 72% coverage of methods in the controller layer.
* Except for the Storage Controller and Test Controller, all routes are currently tested in Postman.
* All features are tested in Selenium end-to-end tests.
* Had to use Selenium 3.141.59 to avoid dependency conflicts.

To-do list:
* Ability to update account information as a user
* Ability to add items and checkout instantly (buy now) as a user
* Ability to contact customer support (live chat)
* Add more sad path testing to admin features in the end-to-end tests.

## Getting Started
Please refer to `STARTUP.md` file

# Application Screenshots
![Store](https://i.postimg.cc/3R4p6GPB/Screen-Shot-2022-01-14-at-12-25-43-PM.png)
![Login / Register / Profile](https://i.postimg.cc/sgMh172R/Screen-Shot-2022-01-14-at-12-40-20-PM.png)
![Product Details / Review](https://i.postimg.cc/wMbDbVB0/Screen-Shot-2022-01-14-at-12-51-19-PM.png)
![Cart / Checkout / Confirmation / Orders History](https://i.postimg.cc/NGPTtdgx/Screen-Shot-2022-01-14-at-12-54-49-PM.png)
![Manage Store](https://i.postimg.cc/rst534tT/Screen-Shot-2022-01-14-at-1-09-55-PM.png)
![Manage Store Forms](https://i.postimg.cc/1XJZxgxW/Screen-Shot-2022-01-14-at-1-04-27-PM.png)


# Entity Relationship Diagram
![ERD Image](https://i.postimg.cc/q75nz3yn/image.png)

# File Structure
Within the download you'll find the following directories and files:

```
Project-3-Front-End-Beta • E-Commerce

├── README.md
├── angular.json
├── package-lock.json
├── package.json
├── src
│   ├── app
│   │   ├── app-routing.module.ts
│   │   ├── app.component.html
│   │   ├── app.component.scss
│   │   ├── app.component.spec.ts
│   │   ├── app.component.ts
│   │   ├── app.module.ts
│   │   ├── header
│   │   │   ├── header.component.html
│   │   │   ├── header.component.scss
│   │   │   ├── header.component.spec.ts
│   │   │   └── header.component.ts
│   │   ├── models
│   │   │   ├── cart.model.ts
│   │   │   ├── instance.ts
│   │   │   ├── product.model.ts
│   │   │   ├── purchased-item.model.ts
│   │   │   ├── review.model.ts
│   │   │   ├── transaction.model.ts
│   │   │   └── user.model.ts
│   │   ├── services
│   │   │   ├── auth.service.spec.ts
│   │   │   ├── auth.service.ts
│   │   │   ├── cart-and-items.service.spec.ts
│   │   │   ├── cart-and-items.service.ts
│   │   │   ├── cart-item.service.spec.ts
│   │   │   ├── cart-item.service.ts
│   │   │   ├── cart.service.spec.ts
│   │   │   ├── cart.service.ts
│   │   │   ├── file-upload.service.spec.ts
│   │   │   ├── file-upload.service.ts
│   │   │   ├── product-and-discount.service.spec.ts
│   │   │   ├── product-and-discount.service.ts
│   │   │   ├── product.service.spec.ts
│   │   │   ├── product.service.ts
│   │   │   ├── purchased-item.service.spec.ts
│   │   │   ├── purchased-item.service.ts
│   │   │   ├── review.service.spec.ts
│   │   │   ├── review.service.ts
│   │   │   ├── token-storage.service.spec.ts
│   │   │   ├── token-storage.service.ts
│   │   │   ├── transaction.service.spec.ts
│   │   │   ├── transaction.service.ts
│   │   │   ├── user.service.spec.ts
│   │   │   └── user.service.ts
│   │   ├── shop  
│   │   │   ├── checkout
│   │   │   │   ├── checkout.component.html
│   │   │   │   ├── checkout.component.scss
│   │   │   │   ├── checkout.component.spec.ts
│   │   │   │   └── checkout.component.ts
│   │   │   ├── confirmation-checkout
│   │   │   │   ├── confirmation-checkout.component.html
│   │   │   │   ├── confirmation-checkout.component.scss
│   │   │   │   ├── confirmation-checkout.component.spec.ts
│   │   │   │   └── confirmation-checkout.component.ts
│   │   │   ├── order-history
│   │   │   │   ├── order-history.component.html
│   │   │   │   ├── order-history.component.scss
│   │   │   │   ├── order-history.component.spec.ts
│   │   │   │   └── order-history.component.ts
│   │   │   ├── product-page
│   │   │   │   ├── product-page.component.html
│   │   │   │   ├── product-page.component.scss
│   │   │   │   ├── product-page.component.spec.ts
│   │   │   │   └──  product-page.component.ts
│   │   │   ├── store-product
│   │   │   │   ├── store-product.component.html
│   │   │   │   ├── store-product.component.scss
│   │   │   │   ├── store-product.component.spec.ts
│   │   │   │   └── store-product.component.ts
│   │   ├── users
│   │   │   ├── admin
│   │   │   │   ├── admin.component.html
│   │   │   │   ├── admin.component.scss
│   │   │   │   ├── admin.component.spec.ts
│   │   │   │   ├── admin.component.ts
│   │   │   │   ├── admin.guard.spec.ts
│   │   │   │   └── admin.guard.ts
│   │   │   ├── login
│   │   │   │   ├── login.component.html
│   │   │   │   ├── login.component.scss
│   │   │   │   ├── login.component.spec.ts
│   │   │   │   └── login.component.ts
│   │   │   ├── profile
│   │   │   │   ├── profile.component.html
│   │   │   │   ├── profile.component.scss
│   │   │   │   ├── profile.component.spec.ts
│   │   │   │   └── profile.component.ts
│   │   │   ├── register
│   │   │   │   ├── register.component.html
│   │   │   │   ├── register.component.scss
│   │   │   │   ├── register.component.spec.ts
│   │   │   │   └── register.component.ts
│   ├── assets
│   │   ├── image
│   │   ├── images
│   │   ├── js
│   │   └── webfonts
│   │  
│   ├── browserslist
│   ├── environments
│   ├── favicon.ico
│   ├── index.html
│   ├── karma.conf.js
│   ├── main.ts
│   ├── polyfills.ts
│   ├── styles.scss
│   ├── test.ts
│   ├── tsconfig.app.json
│   ├── tsconfig.spec.json
│   └── tslint.json
├── tsconfig.json
└── tslint.json
```

```
Project-3-Back-End • E-Commerce

├── src/main/java
│   ├── com.project3.revtech
│   │   └── RevtechApplication.java
│   ├── com.project3.revtech.aop
│   │   └── LoggingAspect.java
│   ├── com.project3.revtech.config
│   │   └── StorageConfig.java
│   ├── com.project3.revtech.controller
│   │   ├── AuthController.java
│   │   ├── CartController.java
│   │   ├── CartItemController.java
│   │   ├── CartItemProductController.java
│   │   ├── DiscountController.java
│   │   ├── DscountedProductController.java
│   │   ├── ProductAndDiscountController.java
│   │   ├── ProductController.java
│   │   ├── StorageController.java
│   │   ├── TestController.java
│   │   ├── TransactionController.java
│   │   └── UserController.java
│   ├── com.project3.revtech.dao
│   │   ├── CartItemRepository.java
│   │   ├── CartRepository.java
│   │   ├── DiscountRepository.java
│   │   ├── ImageControllerRepository.java
│   │   ├── ProductRepository.java
│   │   ├── RoleRepository.java
│   │   ├── TransactionRepository.java
│   │   └── UserRepository.java
│   ├── com.project3.revtech.entity
│   │   ├── Cart.java
│   │   ├── CartItem.java
│   │   ├── Discount.java
│   │   ├── ERole.java
│   │   ├── Image.java
│   │   ├── Product.java
│   │   ├── Role.java
│   │   ├── Transaction.java
│   │   └── User.java
│   ├── com.project3.revtech.exception
│   │   ├── ApplicationException.java
│   │   └── GlobalExceptionHandler.java
│   ├── com.project3.revtech.joinedPojo
│   │   ├── CartAndItemsPojo.java
│   │   ├── ItemProductDiscountPojo.java
│   │   └── ProductAndDiscountPojo.java
│   ├── com.project3.revtech.pojo
│   │   ├── CartItemPojo.java
│   │   ├── CartPojo.java
│   │   ├── DiscountPojo.java
│   │   ├── ImagePojo.java
│   │   ├── ProductPojo.java
│   │   ├── TransactionPojo.java
│   │   └── UserPojo.java
│   ├── com.project3.revtech.request
│   │   ├── LoginRequest.java
│   │   └── SignupRequest.java
│   ├── com.project3.revtech.response
│   │   ├── JwtResponse.java
│   │   └── MessageResponse.java
│   ├── com.project3.revtech.security
│   │   └── WebSecurityConfig.java
│   ├── com.project3.revtech.security.jwt
│   │   ├── AuthEntryPointJwt.java
│   │   ├── AuthTokenFilter.java
│   │   └── JwtUtils.java
│   ├── com.project3.revtech.security.service
│   │   ├── UserDetailsImpl.java
│   │   └── UserDetailsServiceImpl.java
│   ├── com.project3.revtech.service
│   │   ├── CartItemProductService.java
│   │   ├── CartItemProductServiceImpl.java
│   │   ├── CartItemService.java
│   │   ├── CartItemServiceImpl.java
│   │   ├── CartService.java
│   │   ├── CartServiceImpl.java
│   │   ├── DiscountService.java
│   │   ├── DiscountServiceImpl.java
│   │   ├── ProductAndDiscountService.java
│   │   ├── ProductAndDiscountServiceImpl.java
│   │   ├── ProductService.java
│   │   ├── ProductServiceImpl.java
│   │   ├── StorageService.java
│   │   ├── TransactionService.java
│   │   ├── TransactionServiceImpl.java
│   │   ├── UserService.java
│   │   └── UserServiceImpl.java
├── scrc/main/resources
│   ├── application.properties
│   ├── application.yml
│   ├── data.sql
│   ├── logback.xml
│   └── schema.sql
├── src/test/java
│   ├── com.project3.revtech
│   ├── com.project3.revtech.prototype
│   └── com.project3.revtech.service
├── JRE System Library
├── Maven Dependencies
├── bin
├── logs
├── target
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

Team Structure
----
![Team Structure Image](https://i.postimg.cc/fL0gMJGz/Screen-Shot-2022-01-14-at-12-03-42-PM.png)

Contributors
-----
Scrum Master: 
* Michelle Ng - Scrum Master / Technical Lead

Team Leads: 
* Rowel Selidio - Technical Lead (User Development Team)
* James Lemaire - Technical Lead (Product Development Team)
* Aimen Altaiyeb - Technical Lead (Transaction Development Team)

Team Members: 
* Derrice Wright (User Development Team)
* Tulika Ghosh (User Development Team)
* Anthony Johnson (Product Development Team)
* Austin Noel (Product Development Team)
* Tareeq Hamilton (Transaction Development Team)
* Sameh Botros (Transaction Development Team)

Test Team: 
* Amanda Gonzalez (Unit Test Development)
* Eric Jennings (Integration Test Development)
* Alejandro Lara (Unit Test Development)
* David Zazulak (End-to-End Test Development)


