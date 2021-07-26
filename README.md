# Tiniesturl
This is an application named Tiniesturl similar to tiny url. 

Tiniesturl is a service that converts long urls into short url links to save space when sharing urls.
When user opens the short url, it will be automatically redirected to original the (long) url.

Functional Requirements:
- Users should be able to enter a long URL and our service should save that URL and generate a short link.
- On using the short link should redirect the user to the original long URL

Non-Functional Requirements:
- The service should be up and running all the time. High Availability.
- Redirecting should not last longer than two seconds.

For UI:
I have made use of Swagger UI
After developing an API, it is good to document it in a good way. Documentation makes APIs easier to understand and use. 
The API in this project is documented using Swagger UI.



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


