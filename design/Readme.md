# System Design Document

## Software Design patterns
* Factory method
* Dependency Injection
+ Spring Boot Builtin (Strategy, Singleton, etc)

## Software Behaviour
System can be designed as a _Spring Boot Web Application Rest API_ and have proper business:
```
   1. Mobile or Web or other client sending request with json body to controller registerUser method
      a. Web client -> we build registration form with proper fields, username, password, mobileNumber, etc
      b. Smart Phone Mobile -> we can build form and taked all user model data
      c. Nokia 3310 without internet access -> send sms to mobile provider -> provider calling our rest service with proper body with serviceType (if those specification accepting)
      c. Nokia 3310 without internet access -> send sms to mobile provider -> provider push message into topic (if those specification accepting), our system can be subscribe to that topic and when message from provider will be published, our system will take the message, transform it to user model and call register user

   * REGISTER USER POST /user/register
   
       {
           fullName: "My Full Name"
           role : "ROLE_IN_PROPER_SYSTEM"
           email: "my_email@gmail.com"
           mobileNumber: "my_unique_mobile_number@gmail.com"
           userName: "my_user_name"
           password: "my_password"
       }
    
    2. Validation service will check if the user already exist and registered previously ion our system
    3. Registration Service Factory based on service type provide the proper registration service implementation (WEB, MOBILE, etc)
    4. Transformation Service based on service type provide  will take the model and transform to User Model
    5. Web or Mobile Registration service taken from step 3 will call register and pass UserModel, which will use PaymentAggregatorService wich will call third party Lipisha Client to create and register our user
    6. Notification service will notify that our registration was done succesfuly or not - in future can improve for more things
   ```
User Registration Request Example: 

 
## Software Service Design and Class Diagram
Please check the [Class Diagramm](ClassDiagram.png)
Please check the [Service Diagramm](ServiceDiagram.png)
 
# Nice To have
All this should be discussed with the team members, getting some approval or rejection, because this is just POC.