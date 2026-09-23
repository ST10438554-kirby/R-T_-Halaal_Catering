# R-T_-Halaal_Catering
# R&T Halaal Catering Android Application
Github link : https://github.com/ST10438554-kirby/R-T_-Halaal_Catering 
Youtube link :
# Code Overview
The R&T Halaal Catering Android application is a prototype that lets users browse catering items, register, log in, place catering orders, and see their past orders. Kotlin and Android Studio are being used to create the application. 
With distinct screens in charge of various application functions, the program has an organized activity-based design.
# Main Application
MainActivity.kt is the starting screen of the application. It displays the welcome screen and provides two options which is:
Get Started – opens the registration screen.
Login – opens the login screen.
The Activity uses Android Intent objects to navigate between screens.
# Registration and Login
RegisterActivity allows a new customer to provide their registration information.
LoginActivity allows an existing customer to enter their email address and password.
Instead of Firebase, the application is connected to a customized REST API. XAMPP is used to host a MySQL database with which the API interacts.
Retrofit facilitates communication between the Android application and the REST API.
The API has endpoints for the following:
Register of user
Logging in
In the backend database, passwords are not kept in plain text. The API protects user passwords with BCrypt password hashing.
# REST API
The Android API package contains several classes:
ApiService.kt – defines the REST API endpoints.
RetrofitClient.kt – creates the Retrofit connection to the backend API.
RegisterRequest.kt – stores registration information sent to the API.
LoginRequest.kt – stores login information sent to the API.
AuthResponse.kt – represents the response returned by the API.
Retrofit and Gson are used as external libraries to send HTTP requests and convert JSON responses into Kotlin objects.
# Products
The product section allows customers to view available catering products.
ProductsActivity displays the available products, while ProductDetailsActivity displays additional information about a selected product.
Customers can add products to their shopping cart.
# Shopping Cart
CartActivity displays the items selected by the customer.
CartManager is responsible for managing the products currently stored in the cart. It allows products to be added, removed and used when calculating the order total.
# Checkout
CheckoutActivity collects the information required to create a catering order.
The checkout process includes:
Event date
Number of guests
Collection or delivery
Delivery address
Additional notes
Payment option
Order total
Amount paid
Remaining balance
Input validation is used to prevent incomplete information from being submitted.
# Order Confirmation
OrderConfirmationActivity displays the details of a successfully created order.
An order number is generated for each order. The confirmation screen displays information such as the event date, number of guests, order type, total amount, payment amount and outstanding balance.
# Order Management
Order.kt is a data model representing an individual catering order.
It stores information including:
Order number
Event date
Number of guests
Order type
Delivery address
Notes
Total amount
Amount paid
Balance
Payment type
OrderManager.kt temporarily stores orders during the current application session.
MyOrdersActivity.kt retrieves the stored orders and displays them to the customer.
# Database and Backend
The backend is being developed using ASP.NET Core Web API.
The database is MySQL and is hosted locally through XAMPP during development.
The database contains user information required for registration and authentication.
Entity Framework Core is used by the ASP.NET Core API to communicate with MySQL.
# Security
The backend uses BCrypt to hash user passwords before storing them in the database.
The API also performs validation for registration and login requests. For example, it checks whether required fields have been entered and prevents duplicate email registrations.
# External Libraries and Technologies
The project currently uses:
Kotlin
Android Studio
Android SDK
Retrofit
Gson Converter
ASP.NET Core Web API
Entity Framework Core
MySQL
XAMPP
BCrypt
Retrofit is used as the external Android library for communicating with the REST API.
# Current Development Status
The application currently contains the main customer ordering workflow:
Welcome 
Register/Login 
 Home 
 Products 
 Product Details  
Cart 
Checkout 
Order Confirmation 
My Orders
The REST API and MySQL database have also been created for user authentication.

The remaining Android screens will be integrated with the database and REST API during further development, which will also involve more testing and final documentation.
