# DataSchema
![Data schema](/images/DataSchema.png)
# Milestone
| priority | task |
| ----  | ----- | 
|- [ ] p1 | Finish the data schema part and build the related ecommerce database. |
- [ ] p1 | Finish the user login/registration. Spring security might be helpful. Finish the authorization part.
- [ ] p1 | List all the items on the main page. User can add some items into their cart.
- [ ] p1 | User can checkout their cart. Items will be listed in their cart. When checking out, they need to provide their information.
- [ ] p1 | User can post their product onto this website. Including some information of the product. eg. The description and the image...
- [ ] p2 | Set up a chat service for owner and customer to communicate with each other.
- [ ] p2 | Using react to build the front end webpage.
- [ ] p2 | Use docker to store the database and try to find a way to store the prod server and test server into different containers.
- [ ] p2 | Find a way to record metrics of the websites and write unit tests.

tip: This website is very similar to amazon.com


# DevelopGuide: 
1. Clone this project to your local environment.(I personally prefer Intellij Ultimate version, other IDE will be fine if you are comfortable with)
2. Download MAMP on your computer, doesn't need Pro version.(Once again, you can also use PHPAdmin and some other Database management tools if you want)
3. Create a new table called 'ecommerce'
4. After importing the project from github, you can start the server in intellij by simply click 'start button'. 
5. If success, you will see this in your MAMP webpage:

![Database](/images/DatabaseReview.png)


# Authentication Backend
Download Postman on your local machine. Send POST requests to both URIs
1. Signin /api/auth/signin  
    ```
    requestbody {  
      "usernameOrEmail" : "abc",  
      "password": "123456"  
    }  
    ```  
2. Signup /api/auth/sighup  
    ```
    requestbody {  
      "username": "abc",  
      "email": "abc@gmail.com",  
      "password": "123456"  
    }  
    ```
if successful, you will see response correct on your postman.  

# Front end 
I also used React as our front-end framework. The files are located at /webapp. You can check out how to set up your front-end  
environment through README.md in that folder. Basicly you need to install node.js on your local machine.

