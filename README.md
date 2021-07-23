# Tiniesturl
This is an application named Tiniesturl similar to tiny url. 

Tiniesturl is a service that converts long urls into short url links to save space when sharing urls.
When user opens the short url, it will be automatically redirected to original the (long) url.


## To Run the Application

- Clone the git repository 
   `git clone https://github.com/Viveniac/tiniest-url`
   
- In the command line open the tiniest-url from the folder location
   `cd tiniest-url`

## How to use 
+ With Docker and docker-compose:
   `docker-compose up -d`

- Without Docker: 
  `git clone https://github.com/Viveniac/tiniest-url`

    - Make sure you have access to local or any MySQL server.
    - Open project in your favorite editor and change application.properties file to point to your MySQL database
    - Build Spring project 
    - Open localhost:8080/swagger-ui.html to see endpoints.


