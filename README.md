# DataSchema
![Data schema](/images/DataSchema.png)
# Milestone
- [x] p1 | Finish the data schema part and build the related ecommerce database. 
- [x] p1 | Finish the user login/registration. Spring security might be helpful. Finish the authentication part.
- [ ] p1 | Design all the routers for the app. Finish authoriazation part of project. 
- [ ] p1 | List all the items on the main page. User can add some items into their cart.
- [ ] p1 | User can checkout their cart. Items will be listed in their cart. When checking out, they need to provide their information.
- [ ] p1 | User can post their product onto this website. Including some information of the product. eg. The description and the image...
- [ ] p2 | Set up a chat service for owner and customer to communicate with each other.
- [ ] p2 | Using react to build the front end webpage.
- [ ] p2 | Enable users to pay online. This part might be interesting.
- [ ] p2 | Use docker to store the database and try to find a way to store the prod server and test server into different containers.
- [ ] p2 | Find a way to record metrics of the websites and write unit tests.
- [ ] p3 | Try to explore some cool features about React. eg. animation to make website more appealing to customers.

tip: This website is very similar to amazon.com

# Authentication Backend
Download Postman on your local machine. Send POST requests to both URIs
1. Signin /api/auth/signin  
    ### requestbody 
    ```
    {  
      "usernameOrEmail" : "abc",  
      "password": "123456"  
    }  
    ```  
2. Signup /api/auth/sighup  
    ### requestbody 
    ```
    {  
      "username": "abc",  
      "email": "abc@gmail.com",  
      "password": "123456"  
    }  
    ```
if successful, you will see response correct on your postman.  

# Front end 
I also used React as our front-end framework. The files are located at /webapp. You can check out how to set up your front-end  
environment through README.md in that folder. Basicly you need to install node.js on your local machine. [needs to be done]

