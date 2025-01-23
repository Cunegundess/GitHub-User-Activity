# GitHub-User-Activity

A simple project to fetch and display GitHub User Activity 

Solution for the [Github User Activity](https://roadmap.sh/projects/github-user-activity) challenge from [roadmap.sh](https://roadmap.sh/).

## Requirements
------------
To run this project, you need:
- Java version 17 or higher
- Maven 3.9

## How to Compile and Run the Project
----------------------------------

### Step 1: Compile the Project
---------------------------
To compile the project, navigate to the root directory of the project (where `pom.xml` is located) and run:
```sh
mvn compile
```

### Step 2: Build the Project
-------------------------
To build the project and package it, run the following command:
```sh
mvn clean install
```

### Step 3: Run the Project
-----------------------
After compiling, use the following command to run the application:
```sh
mvn exec:java -Dexec.mainClass="com.cunegundess.Main" -Dexec.args="USERNAME"
```

## Todo
- [x] Setup Maven
- [] Setup Docker
- [] Setup Frontend