API Overview

A software intermediary that allows two applications to talk to each other.This API is designed to be easy to integrate with front-end applications, mobile apps, or other third-party services to facilitate grocery store operations in a reliable and scalable manner. This project is a RESTFULL API for a POS system.

Table Of Contents

Key Features

Technologies Used

Api Documentation


Key Features
Customer Management : CRUD Operation for Customers.
Item Management : CRUD Operation for Items.
Order Management : Placement and management of customer orders including handling of discounts, sub-collections and balances.
Transaction : maintains data integrity during ordering and administration and facilitates intricate transaction processes.

Technologies Used 
Tomcat 11
Maven
Java Version 21
MySQL
Spring  with Jakarta EE
Hibernate

API Documentation

Customer Api
saved customer : POST api/v1/customers 
    {
    "firstName":"nimal",
    "city":"maggona",
    "email":"nimal4@gmail.com",
    "address":"maggona,kapugoda"
    }
update Customer : PUT api/v1/customers/{customerId}
    {
    "firstName":"sandul",
    "city":"maggona",
    "email":"sandul4@gmail.com",
    "address":"Colombo"
    }
Delete Customer : DELETE api/v1/customers/{customerId}
    {
    "message":""Customer delete succesfully"
    }
Get Customer : GET api/v1/customers/{customerId}
    {
    "customerId":"CUSTOMER-5f240c74-cc3f-4d4f-8245-da7cda6c57cb"
    "firstName":"sandul",
    "city":"maggona",
    "email":"sandul4@gmail.com",
    "address":"Colombo"
    }
Get All Customer : GET api/v1/customers
    [
        {
        "customerId":"CUSTOMER-5f240c74-cc3f-4d4f-8245-da7cda6c57cb"
        "firstName":"sandul",
        "city":"maggona",
        "email":"sandul4@gmail.com",
        "address":"Colombo"
        },
        {
        "customerId":"CUSTOMER-5f240c74-cc3f-4d4f-8245-da7cda6c57cb"
        "firstName":"sandul",
        "city":"maggona",
        "email":"sandul4@gmail.com",
        "address":"Colombo"
        },
        {
        "customerId":"CUSTOMER-5f240c74-cc3f-4d4f-8245-da7cda6c57cb"
        "firstName":"sandul",
        "city":"maggona",
        "email":"sandul4@gmail.com",
        "address":"Colombo"
        }

    ]
Item Api and Order Api
The item and the order are done in the same way as the above customer.
