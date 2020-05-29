# Deployment Insructions
An example of how to deploy the app is here:
https://youtu.be/ht6yVkLW1xY


# Step 1: Create Heroku Account 

You will need a Heroku Account to use our app. 
If you don’t have a Heroku Account yet, please create a Heroku account by logging in at https://heroku.com
Click the “Sign up for Free” link.
You’ll be asked for:
* First Name, Last Name
* Email 
* Company 
* Preferred Development Language: choose Java
Don’t worry; your choice doesn’t prevent you from using the account with other languages later such as Ruby or Python

If you already have a Heroku account on the free tier, you might need to delete old apps to make space for new ones. There is a limit of five apps on the free tier of Heroku 
 
# Step 2: Install Heroku CLI 
CLI stands for Command Line Interface. The Heroku CLI gives you the ability to type heroku as a command at the shell/terminal prompt.
Instructions are here: https://devcenter.heroku.com/articles/heroku-cli
 
# Step 3: Install Java 11 and Maven on your machine
Follow the instructions here for installing Java 11 and Maven
* Make sure you have Java 11
* Install instructions for Mac OS: https://ucsb-cs56.github.io/topics/macos/
* For Windows, see: https://ucsb-cs56.github.io/topics/windows/
* Install Maven. Instructions are here: https://maven.apache.org/index.html
* If you are a Mac user, try to install Maven using Homebrew. https://ucsb-cs56.github.io/topics/macos/ Type “brew install maven” in your Terminal. (Check if your mac have Homebrew installed firstly)
 

# Step 4: Create Heroku App 
After you have created a heroku account, you should:
login to the Heroku Dashboard https://dashboard.heroku.com
create a new Heroku app called anything you want
 
# Step 5: Fetch Source Code
After your app’s ready, put it aside for a second and navigate github.com
* On github.com, search project-s0-t4-new-city
* Fork the project repo to your own personal GitHub account by clicking on the “Fork” button at the upper right hand of the repo’s page on Github
* After a few seconds you should have a repo contains the source code

# Step 6: Deploy App 
You should have the heroku app handy, then:
* Navigate to the https://dashboard.heroku.com
* Bring up the app you just created
* Navigate to the Deploy tab
* Under Deployment Method, select GitHub
* To select your repo, type in your GitHub account for the owner, and then search for the repo you created in last step
* Click to connect your repo to the app
* (Optional) Go down to “Automatic Deploys” and set up your repo to deploy the master branch automatically.

If you deploy now, you should see an error since we still need to set things up 
 
# Step 7: Git clone
Now let's have the code in your local end
* Go to your repo, find the green clone or download button, copy the link there
* In your terminal do "git clone URL", Where URL should be the one you just copied

# Step 8: Setting up OAuth for Spring Boot

Follow this link for a more detailed explaination: https://ucsb-cs48.github.io/topics/oauth_google_setup/

### Step 8a: Setting up localhost
At this point, let’s try to run the app on localhost first
* Navigate to https://developers.google.com/identity/sign-in/web/sign-in to create a Google OAuth Application.
* If you are asked “Where are you calling from”, select “Web Server”
* Set the Authorized Redirect URI to: http://localhost:8080/login/oauth2/code/google

### Step 8b: Get Google Map Key
(You will need to input a credit card for this, but google gives you $300 for free) 

We also include google map feature in our app, so you will need to get a key for that

Please get an API key no matter whether you choose to use the map feature or not, getting the key is free and without inputing credit information. And our app requires a key to run successfully

To get an API key:
* Go to the Google Cloud Platform Console: cloud.google.com
* Click on "console"
* Click the project drop-down and select or create the project for which you want to add an API key.
* Click the menu button  and select APIs & Services > Credentials.
* On the Credentials page, click +CREATE CREDENTIALS > API key.
* The API key created dialog displays your newly created API key.
* Click Close.
* The new API key is listed on the Credentials page under API keys.
* Copy that key somewhere handy

If you don't want to give your credit card away, skip following two steps, and don't include map feature in the app.

* Now go to the drop down menu, find the billing option and input your credit info
* Link your project with this billing acount and you are ready to go

Now let's go to your directory

Create a file called secrets-localhost.properties, and add these three items to it, filling out the client-id, client-secret, google-map-key with the values from your Google OAuth application

spring.security.oauth2.client.registration.google.client-id=PUT-CLIENT-ID-HERE<br/>
spring.security.oauth2.client.registration.google.client-secret=PUT-CLIENT-SECRET-HERE<br/>
newCity.googleMapKey=PUT-YOUR-KEY-HERE

* Run in your command line:<br/>
mvn spring-boot:run -Dspring-boot.run.arguments="--filename=sheet.csv"

And now you should see the app functioning on your localhost, and if you don't see it working, its ok to ignore it for now

Let’s proceed to next step
 

### Step 8c: How to set up Google OAuth for Heroku
Basically repeat 8a and 8b with minor changes
* Navigate to https://developers.google.com/identity/sign-in/web/sign-in to create a Google OAuth Application.
* If you are asked “Where are you calling from”, select “Web Server”
* Set the Authorized Redirect URI to: https://your-app-name.herokuapp.com/login/oauth2/code/google
* NOTE: replace the "your-app-name" part of the Redirect URI with the app name you created in part 4
* You can use the same map key obtained in above instruction

Create a file called secrets-heroku.properties, add the following items to it, filling out them the values from your Google OAuth application and key

spring.security.oauth2.client.registration.google.client-id=PUT-CLIENT-ID-HERE<br/>
spring.security.oauth2.client.registration.google.client-secret=PUT-CLIENT-SECRET-HERE<br/>
newCity.googleMapKey=PUT-YOUR-KEY-HERE
 
* Run the script:<br/> 
./setHerokuEnv.sh --app YOUR-HEROKU-APP-NAME

If you don’t have a setHerokuEnv.sh script for your app, create one that looks like this:<br/>
#!/usr/bin/env bash<br/>
heroku config:set PRODUCTION_PROPERTIES="$(cat secrets-heroku.properties)" "$@"

If you deploy now, you will probably see our app without any data! That's fine and let's put data into it

# Step 9: Connection to database
* Run: <br/>
source loaddata.sh YOUR_HEROKU_APP_NAME

* When it is done, run:<br/>
echo $PRODUCTION_PROPERTIES<br/>
To check if everything is there. You should see your client-id, client-secret, etc.


# Step 10: Fully functioning website
* On your terminal run: <br/>
mvn spring-boot:run -Dspring-boot.run.arguments="--filename=sheet.csv"<br/>
* By doing so, we are injecting data into the database. If you go to your app’s website now, you should see a fully functioning New-County-Searcher app.
