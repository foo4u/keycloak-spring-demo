# Keycloak Spring Security Examples

Demonstrates how to use the Keycloak Spring Security adapter, including:

* Login
* Distributed SSO
* Distributed Logout
* OAuth2 Bearer Tokens

## Requirements

The following examples are standalone Spring Boot applications.

They require the Keycloak appliance 1.2.0, running locally on port 8080 (the default for the
standalone appliance).

There are multiple Spring Boot projects.  These will all run on independently on the localhost
listening on differnt ports.

* **customer-app** A Spring Boot application that does remote login using OAuth2 browser redirects with the auth server
* **product-app** A Spring Boot application that does remote login using OAuth2 browser redirects with the auth server
* **database-service** A Spring Boot RESTful application service authenticated by bearer tokens only. The customer and product app invoke it to get data.


### Step 1: Make sure you've set up the Keycloak Server

The Keycloak Appliance Distribution comes with a preconfigured Keycloak server (based on Wildfly).  You must use it this server to run the Spring Security demos.  

### Step 2: Boot Keycloak Server

Where you go to start up the Keycloak Server depends on which distro you installed.

From appliance:

```
$ cd keycloak/bin
$ ./standalone.sh
```

### Step 3: Import the Test Realm

Import the test realm for the demo.  Clicking on the below link will bring you to the
create realm page in the Admin UI.  The username/password is admin/admin to login in.  Keycloak will ask you to create a new admin password before you can go to the create 
realm page.

http://localhost:8080/auth/admin/master/console/#/create/realm

Import the spring-demo-realm.json file that is in this project's root directory.


### Step 4: Build and deploy

Launch each application (use a new terminal for each application):

```
$ ./gradlew database-service:bootRun
$ ./gradlew customer-app:bootRun
$ ./gradlew product-app:bootRun
```

### Step 5: Login and Observe Apps

Try going to the customer app and view customer data:

http://localhost:9092/customer-portal/

This should take you to the auth-server login screen.  Enter username: srossillo and password: password.

If you click on the products link, you'll be taken to the products app and show a product listing.  The redirects
are still happening, but the auth-server knows you are already logged in so the login is bypassed.

If you click on the logout link of either of the product or customer app, you'll be logged out of all the applications.


## Admin Console

http://localhost:8080/auth/admin/index.html
