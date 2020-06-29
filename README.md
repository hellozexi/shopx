# DataSchema
![Data schema](/images/DataSchema.png)
# Milestone
- [x] p1 | Finish the data schema part and build the related ecommerce database. 
- [x] p1 | Finish the user login/registration. Spring security might be helpful. Finish the authentication part.
- [x] p1 | User can create their profile. And user can modify their profile.
- [x] p1 | Design all the routers for the app. Finish authoriazation part of project. 
- [x] p1 | List all the items on the main page. User can add some items into their cart.
- [x] p1 | User can checkout their cart. Items will be listed in their cart. When checking out, they need to provide their information.
- [x] p1 | User can post their product onto this website. Including some information of the product. eg. The description and the image...
- [ ] p2 | Set up a chat service for owner and customer to communicate with each other.
- [ ] p2 | Using react to build the front end webpage.
- [ ] p2 | Enable users to pay online. This part might be interesting.
- [ ] p2 | Use docker to store the database and try to find a way to store the prod server and test server into different containers.
- [ ] p2 | Find a way to record metrics of the websites and write unit tests.
- [ ] p3 | Try to explore some cool features about React. eg. animation to make website more appealing to customers.
- [ ] p3 | Enable search engine for the website. eg. Elasticsearch
- [ ] p3 | Design the recommendation system or algorithm. Based on user's browsing behavior, give him/her related recommendations on product. eg. recommendation algorithms like famous item-item or user-user.
- [ ] p3 | Deploy the website and try to make it into production.


# Authentication API
## Signin /api/auth/signIn (POST)  
### request body
```
{  
  "usernameOrEmail" : "abc",  
  "password": "123456"  
}  
```  
## Signup /api/auth/signUp (POST)  
### request body
```
{  
  "username": "abc",  
  "email": "abc@gmail.com",  
  "password": "123456"  
}  
```

# Add/Update Customer Information API
## /api/customer/update (POST)  
### request body
```
{
  	"firstName": "Mik",
	"lastName": "Liu",
	"customerPhone": "3146855203",
	"billingAddress" : "5941 KingsBury Ave",
	"billingCity": "Saint Louis",
	"billingState": "MO",
	"billingZipCode": "63113",
	"billingCountry": "USA",
	"shippingAddress" : "Leland Ave 811",
	"shippingCity": "Saint Louis",
	"shippingState": "MO",
	"shippingZipCode": "63112",
	"shippingCountry": "USA"
}
```


# Add Product API
## /api/product/add (POST)  
### request body
```
{
	"name": "macbook",
	"category": "computer",
	"description": "This is a brand new mac",
	"price": 500,
	"unit": 1
}
```


# View all products API
## /api/product/getall (GET)  
### response body
```
[
    {
        "unit": 1,
        "provider": "mikeliu",
        "price": 500,
        "name": "macbook",
        "description": "This is a brand new mac",
        "category": "computer"
    },
    {
        "unit": 1,
        "provider": "mikeliu",
        "price": 500,
        "name": "macbook2",
        "description": "This is a brand new mac",
        "category": "computer"
    }
]
```

# View all products from current user API
## /api/product/getAllFromCurrentUser (GET)  
### response body
```
[
    {
        "unit": 1,
        "price": 500,
        "name": "macbook",
        "description": "This is a brand new mac",
        "category": "computer"
    },
    {
        "unit": 1,
        "price": 500,
        "name": "macbook2",
        "description": "This is a brand new mac",
        "category": "computer"
    }
]
```

# Delete a product by productid API
## /api/product/delete/{productid} (DELETE)  
### response body if delete successfully
```
delete: {productid}
```

# Add a product to cart API
## /api/cart/add/{productId} (POST)  


# Remove a product from cart API
## /api/cart/delete/{cartItemId} (POST)  


# Show all cartItems of current user API
## /api/cart/getItems (GET)  


# Show current user's cart's total price
## /api/cart/getPrice (GET)  




