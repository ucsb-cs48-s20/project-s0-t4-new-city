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
* Go down to “Automatic Deploys” and set up your repo to deploy the master branch automatically.

If you deploy now, you should see an error since we still need to set things up 
 
# Step 7: Git clone
Now let's have the code in your local end
* Go to your repo, find the green clone or download button, copy the link there
* In your terminal do "git clone URL", Where URL should be the one you just copied

# Step 8: Setting up OAuth for Spring Boot

Follow this link for a more detailed explaination: https://ucsb-cs48.github.io/topics/oauth_google_setup/

Step 8a: Setting up localhost
At this point, let’s try to run the app on localhost first
* Navigate to https://developers.google.com/identity/sign-in/web/sign-in to create a Google OAuth Application.
* If you are asked “Where are you calling from”, select “Web Server”
* Set the Authorized Redirect URI to: http://localhost:8080/login/oauth2/code/google

Step 8b: Get Google Map Key

We also includ google map feature in our app, so you will need to get a key for that

To get an API key:
* Go to the Google Cloud Platform Console: cloud.google.com
* Click the project drop-down and select or create the project for which you want to add an API key.
* Click the menu button  and select APIs & Services > Credentials.
* On the Credentials page, click Create credentials > API key.
* The API key created dialog displays your newly created API key.
* Click Close.
* The new API key is listed on the Credentials page under API keys.
* Copy that key somewhere handy

Now let's go to your directory

Create a file called secrets-localhost.properties, and add these three items to it, filling out the client-id, client-secret, google-map-key with the values from your Google OAuth application

spring.security.oauth2.client.registration.google.client-id=PUT-CLIENT-ID-HERE

spring.security.oauth2.client.registration.google.client-secret=PUT-CLIENT-SECRET-HERE

newCity.googleMapKey=PUT-YOUR-KEY-HERE

* Run mvn spring-boot:run -Dspring-boot.run.arguments="--filename=sheet.csv"

And now you should see the app functioning on your localhost

Let’s proceed to next step
 

Step 8c: How to set up Google OAuth for Heroku
Basically repeat 9a and 9b with minor changes
* Navigate to https://developers.google.com/identity/sign-in/web/sign-in to create a Google OAuth Application.
* If you are asked “Where are you calling from”, select “Web Server”
* Set the Authorized Redirect URI to: https://your-app-name.herokuapp.com/login/oauth2/code/google
* Get map key as above instruction


Add the following items to your secrets-heroku.properties file, filling out them the values from your Google OAuth application and key

spring.security.oauth2.client.registration.google.client-id=PUT-CLIENT-ID-HERE

spring.security.oauth2.client.registration.google.client-secret=PUT-CLIENT-SECRET-HERE

newCity.googleMapKey=PUT-YOUR-KEY-HERE
 
* Run the script ./setHerokuEnv.sh --app appname
If you don’t have a setHerokuEnv.sh script for your app, create one that looks like this:
#!/usr/bin/env bash
heroku config:set PRODUCTION_PROPERTIES="$(cat secrets-heroku.properties)" "$@"

If you deploy now, you will see the error still there. But don’t worry, we still need to connect our app to heroku psql database

# Step 9: Connection to database
* Go to the Heroku Dashboard of your app, under `Settings`, and then `Reveal Config Vars`. Copy the current value of `PRODUCTION_PROPERTIES` and paste it somewhere handy.  You'll need to copy and paste that value in a moment.

* Get the jdbc database url for your Heroku app by running the following command at a terminal prompt where you have the Heroku CLI installed, and are logged in to your Heroku account with `heroku login -i`

  heroku run -a YOUR_PROJECT_NAME echo \$JDBC_DATABASE_URL

* Have the output of this command (the full output, not just the URL) ready to copy and paste as well.

* Now, type the following `export` command at the shell prompt, in the same shell (terminal window) where you are going to run your app in a moment (with `mvn spring-boot:run...`)
Copy/paste the values from steps 1 and 2 above before you press enter.


export PRODUCTION_PROPERTIES="

(paste the PRODUCTION_PROPERTIES from Step 1 here)

spring.datasource.url=PASTE_URL_FROM_STEP2_HERE

"

* Basically, you want the `PRODUCTION_PROPERTIES` environment variable to be all of the `PRODUCTION_PROPERTIES` from your existing Heroku app, plus in addition, you want `spring.datasource.url` set equal to the value of `JDBC_DATABASE_URL` for your Heroku app. You can check whether it worked by typing
echo $PRODUCTION_PROPERTIES

* Go to heroku.com and redeploy the master branch again. You should see our app, excpt there’s no data in it! And we have one last step to do.

# Step 10: Fully functioning website
* Run mvn spring-boot:run -Dspring-boot.run.arguments="--filename=sheet.csv" on your terminal. By doing so, we are injecting data into the database. If you go to your app’s website now, you should see a fully functioning New-County-Searcher app.
