# Getting Started - Backend

* git clone `https://github.com/revature-rev-tech/project-3-back-end.git`

TO RUN APPLICATION LOCALLY:
----
1. Open IDE and import project to workspace
2. Navigate to src/main/java -> com.project3.revtech package -> RevtechApplication.java
3. Run as Java Application to start the server
4. Application and H2 database will run on server.port=7777
5. Once the application is running, on your web browser navigate to `http://localhost:7777/h2-console` in order to access H2 console

THINGS TO NOTE:
----
* The application.properties file contains the H2 database configuraton
* The schema.sql and data.sql files located in src/main/resources will auto generate the tables and data within the H2 database
* The application.yml file contains the AWS credentials to access the S3 bucket which we use to host the images from product image upload

TO RUN THE APPLICATION REMOTELY:
----
1. Navigate to http://ec2-50-16-74-43.compute-1.amazonaws.com:8080/jenkins/ to login to Jenkins connection to EC2
2. Use login credentials: `username: jenkinsadmin` `password: Password123!`
3. Build Jenkins Job `Project-3-Back-End` which handles the building of the backend (along with H2 database)
4. Build Jenkins Job `Project-3-Back-End-Pipeline` which deploys the backend (allows working with the back end remotely)

THINGS TO NOTE:
----
* To access the H2 database console deployed on EC2 Instance, navigate to http://ec2-50-16-74-43.compute-1.amazonaws.com:7777/h2-console

# Getting Started - Frontend
* git clone `https://github.com/revature-rev-tech/project-3-front-end-beta.git`

TO RUN APPLICATION LOCALLY w/ LOCAL BACKEND:
----
1. Run `npm install` to install the node_modules folder
2. Open source-code editor (ex.Visual Studio Code) and open project to load into workspace
3. Make sure the index.html file located in the src file has `<base href"/">` uncommented and `<base href="/dist/rev-tech/">` commented out
4. Make sure the instance.ts file located in app -> models has `static url: string = "http://localhost:7777";` uncommented and `static url: string = "http://ec2-50-16-74-43.compute-1.amazonaws.com:7777";` commented out 
5. Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.
6. Follow steps for how to run the backend locally

TO RUN APPLICATION LOCALLY w/ REMOTE BACKEND:
----
1. Run `npm install` to install the node_modules folder
2. Open source-code editor (ex.Visual Studio Code) and open project to load into workspace
3. Make sure the index.html file located in the src file has `<base href"/">` uncommented and `<base href="/dist/rev-tech/">` commented out
4. Make sure the instance.ts file located in app -> models has `static url: string = "http://localhost:7777";` commented out and `static url: string = "http://ec2-50-16-74-43.compute-1.amazonaws.com:7777";` uncommented
5. Follow steps for how to run the backend remotely

TO RUN APPLICATION REMOTELY:
----
1. Navigate to http://ec2-50-16-74-43.compute-1.amazonaws.com:8080/jenkins/ to login to Jenkins connection to EC2
2. Build Jenkins Job `Project-3-Back-End` is the Jenkins Job which handles the building of the backend (along with H2 database)
3. Build Jenkins Job `Project-3-Back-End-Pipeline` is the Jenkins Job which deploys the backend (allows working with the back end remotely)
3. Build Jenkins Job `Project-3-Front-End-Beta` which handles the building of the frontend (which is connected to and hosted by AWS S3)
4. Navigate to `http://revature-tech.s3.amazonaws.com/dist/rev-tech/index.html` to access the application
