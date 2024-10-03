# QuizSystem-Java

This is a Java-based Multiple Choice Questions (MCQ) Quiz System where an admin can manage a quiz bank, and students can log in to take quizzes. The system uses JSON files to store user credentials and quiz data.

---
## Prerequisites
- **JDK Version**: 11
- **IDE**: IntelliJ IDEA
- **Build Tool**: Gradle
- **DSL**: Groovy
- **JSON Simple Library**: This project uses `json-simple` for JSON manipulation. It is included as a dependency in the Gradle build file. You can find the `json-simple` library [here](https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1).

### Gradle Dependency for `json-simple`
Ensure that your `build.gradle` file includes the following dependency:
```groovy
dependencies {
    implementation 'com.googlecode.json-simple:json-simple:1.1.1'
}
```
---
## Features

1. **User Role Management**:
   - This module serves as the entry point of the system. It checks if the user is an admin or a student and then directs them accordingly:
     - **Admins**: Can add questions to the quiz bank.  
     - **Students**: Can take a quiz and get their results.

2. **User login System**:
   - User credentials are stored in a `users.json` file.
   - Users are categorized as "admin" or "student" based on their roles in the `users.json` file.

3. **Admin Functionalities**:
   - Admin can log in to the system using a username and password.
   - Admin can add multiple MCQ questions, each having four options, to the quiz bank.
   - Questions and answers are stored in a `quiz.json` file.
   - The system ensures only valid inputs are accepted for options and answer keys.
   
4. **Student Functionalities**:
   - Students can log in with their username and password.
   - Students can take a quiz generated from randomly selected questions from the quiz bank.
   - After answering 10 random questions, the system displays the result based on the score.

---
## Source File Structure

```plaintext
|── src
│   ├── main
│   │   ├── java
│   │   │   ├── Admin.java
│   │   │   ├── Student.java
│   │   │   ├── User.java
│   │   │   └── Home.java
│   │   └── resources
│   │       ├── quiz.json
│___│       └── users.json

```
---
## JSON File Usage

There uses two main JSON files to manage data:

1. **users.json**:
   - **File Path**: `./src/main/resources/users.json`
   - login credentials and roles (admin or student) for users.
   - Each user is saved with the following structure:
     ```json
     [
      {
       "username": "admin",
       "password": "1234",
       "role": "admin"
      },
      {
       "username": "Efter",
       "password": "1234",
       "role": "student"
      }
     ]
     ```
   - This file is used to authenticate users during login and direct them based on their role.

3. **quiz.json**:
   - **File Path**: `./src/main/resources/quiz.json`
   - When Admin generate question then the question writes in this file, along with their options and the correct answer.
   - Each question is saved as an object with the following structure:
     ```json
     [
        {
       "question": "question text",
       "option 1": "First option",
       "option 2": "Second option",
       "option 3": "Third option",
       "option 4": "Fourth option",
       "answerkey": 1
        },
        {
       "question": "question text",
       "option 1": "First option",
       "option 2": "Second option",
       "option 3": "Third option",
       "option 4": "Fourth option",
       "answerkey": 1
        }
     ]
     ```
   - This file is updated whenever an admin adds new questions.

