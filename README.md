# simple issue tracker
The goal is to develop a very simple REST API for an issue tracker of a small team of developers

In this application I have 2 Entity:

1. **Developer** : the **Developer** entity created for  developers

2. **Issue**: the **Issue** entity created for handling issues.we have two type of issue:

   1. Bug
   2. Story

   - Both Types have an issue-ID, as well as a title, a description a creation date and an assigned developer.

   - Stories also have an estimated point value, as well as a status that can switch between "New", "Estimated" and "Completed"

   - Bugs have a priority ("Critical", "Major" or "Minor") as well as a status ("New", "Verified" or "Resolved")

   

------
## Stack

- Docker
- Java
- Spring Boot
- Mysql
- Maven
- Git

------

## What you'll need

Docker-ce and docker-compose

For installing docker you can use this 

[Docker installation]: https://docs.docker.com/install/

After installing docker and docker-compose you need just run below command:

## Run

In this Project I use docker-compose for building my application through maven and next build docker image and also running a Mysql container.

- Clone the Project
- Run command `docker-compose up --build`  in the root folder
- Access to http://localhost:8765

------

## EndPoints

 1. **make assignment** 

    ```
    GET http://localhost:8765/assignment
    ```

     header:

    ```
    Content-Type:application/json
    ```
    
    
    
2. **Get Assignment List** 

   ```
   GET http://localhost:8765/assignments
   ```

   Response should be like this:
   
   ```
   {
       "1": [
           {
               "id": 8,
               "version": null,
               "title": "test story 3",
               "description": "story 3 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 3,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 3,
               "assignedWeek": 1
           },
           {
               "id": 16,
               "version": 2,
               "title": "test story 11",
               "description": "story 11 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 1,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 1,
               "assignedWeek": 1
           },
           {
               "id": 12,
               "version": 2,
               "title": "test story 7",
               "description": "story 7 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 3,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 2,
               "assignedWeek": 1
           },
           {
               "id": 11,
               "version": 2,
               "title": "test story 6",
               "description": "story 6 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 2,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 8,
               "assignedWeek": 1
           },
           {
               "id": 10,
               "version": 2,
               "title": "test story 5",
               "description": "story 5 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 1,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 8,
               "assignedWeek": 1
           },
           {
               "id": 9,
               "version": 2,
               "title": "test story 4",
               "description": "story 4 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 3,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 5,
               "assignedWeek": 1
           },
           {
               "id": 7,
               "version": null,
               "title": "test story 2",
               "description": "story 2 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 2,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 2,
               "assignedWeek": 1
           }
       ],
       "2": [
           {
               "id": 15,
               "version": 2,
               "title": "test story 10",
               "description": "story 10 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 1,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 8,
               "assignedWeek": 2
           },
           {
               "id": 17,
               "version": 2,
               "title": "test story 12",
               "description": "story 12 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 1,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 2,
               "assignedWeek": 2
           },
           {
               "id": 19,
               "version": 2,
               "title": "test story 14",
               "description": "story 14 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 2,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 8,
               "assignedWeek": 2
           },
           {
               "id": 20,
               "version": 2,
               "title": "test story 15",
               "description": "story 15 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 3,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 8,
               "assignedWeek": 2
           },
           {
               "id": 22,
               "version": 2,
               "title": "test story 17",
               "description": "story 17 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 2,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 2,
               "assignedWeek": 2
           },
           {
               "id": 23,
               "version": 2,
               "title": "test story 18",
               "description": "story 18 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 3,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 2,
               "assignedWeek": 2
           }
       ],
       "3": [
           {
               "id": 13,
               "version": 2,
               "title": "test story 8",
               "description": "story 8 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 2,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 3,
               "assignedWeek": 3
           },
           {
               "id": 14,
               "version": 2,
               "title": "test story 9",
               "description": "story 9 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 2,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 5,
               "assignedWeek": 3
           },
           {
               "id": 18,
               "version": 2,
               "title": "test story 13",
               "description": "story 13 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 3,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 3,
               "assignedWeek": 3
           },
           {
               "id": 21,
               "version": 2,
               "title": "test story 16",
               "description": "story 16 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 2,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 1,
               "assignedWeek": 3
           },
           {
               "id": 24,
               "version": 2,
               "title": "test story 19",
               "description": "story 19 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 3,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 5,
               "assignedWeek": 3
           },
           {
               "id": 25,
               "version": 2,
               "title": "test story 20",
               "description": "story 20 description",
               "creationDate": "2019-06-12T00:00:00",
               "developerId": 1,
               "developerName": null,
               "issueType": 2,
               "status": 2,
               "point": 8,
               "assignedWeek": 3
           }
       ]
   }
   ```
   
   
   
3. **Get Summary of Assignment.**

   ```
   GET http://localhost:8765/assignment/summary
   ```

   Response should be like this:

   ```
   [
       "There are currently 3 developers. ",
       "There are total 0 estimated and unassigned stories. ",
       "Total points of the estimated and unassigned stories are 0",
       "There are 10 weeks defined."
   ]
   ```
   
   # Notice
   
   In resource folder in project create a `data.sql` file containing data and each time the application run these data push to the DB.if you don't want put this data you can change it in application.yaml from 
   
   ```
   spring:
       datasource:
        initialization-mode: always
   ```
   
   to:
   
   ```
   spring:
       datasource:
           initialization-mode: never
   ```
   
   
