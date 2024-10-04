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
## Details about the features:
### User Class

This `User` class handles the authentication system for the quiz application. It consists of the following:

#### Attributes:
- **username**: Stores the username.
- **password**: Stores the password.
- **role**: Defines the user role (either "admin" or "student").

#### Methods:
- **login()**: 
  - This method prompts the user for their username and password, and then checks the `users.json` file to validate the credentials. 
  - If valid, it returns a `User` object with the corresponding role.
  
- **getRole()**: 
  - Retrieves the role of the authenticated user.

- **getName()**: 
  - Retrieves the username of the authenticated user.

#### Usage:
- The class is used to handle user logins, and based on the role, it directs the user to perform specific actions in the system (either administering quizzes or taking them).

### Admin Class

This `Admin` class is responsible for adding quiz questions to the quiz bank. It consists of the following:

#### Method:
- **addQuizQuestions()**:
  - This method allows the admin to input a new question, along with four options and the correct answer (answer key).
  - It stores the question and its options in a JSON format inside the `quiz.json` file.
  - After each question, the admin can either continue adding more questions or quit.

#### Functionality:
- **Input**: The admin provides the question, four answer options, and selects the correct answer (1-4).
- **Storage**: Questions are saved in `quiz.json` in JSON format.
- **Loop**: The admin is prompted to add more questions or quit after each save.

### Student Class

The `Student` class handles the quiz-taking process. It consists of the following:

#### Method:
- **giveQuiz()**:
  - Allows students to take a 10-question quiz selected randomly from the `quiz.json` file.
  - Ensures that no duplicate questions are asked using a `HashSet` to track asked questions.
  - Scores the student's answers and provides feedback based on their performance.

#### Functionality:
- **Input**: Students choose an answer for each multiple-choice question (1-4).
- **Scoring**: Correct answers increase the score.
- **Feedback**: After the quiz, feedback is given based on the score:
  - 8+ : Excellent
  - 5-7 : Good
  - 2-4 : Very poor
  - 0-1 : Failed

### Home Class

The `Home` class acts as the main entry point of the application. It handles user authentication and directs the user based on their role.

#### Functionality:
- **User Authentication**: The user is prompted to log in with their credentials.
- **Admin Role**: If the user is an admin, they are directed to add questions to the quiz bank.
- **Student Role**: If the user is a student, they are welcomed by name and prompted to take the quiz.

### How to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/QuizSystem-Java.git
   cd QuizSystem-Java
   ```
2. **Run the Application**: Use your preferred IDE (like IntelliJ IDEA) or run it click on the run button.

   ```bash
   java src/main/java/Home
   ```
### Project Demo

A demo video has been recorded showcasing the execution of the project for both Admin and Student roles. You can view the step-by-step process of:

- Admin logging in, adding quiz questions to the question bank, and saving them.
- Student logging in, attending the quiz, and receiving the results.

[Watch the demo video here](https://drive.google.com/drive/folders/1OV5_RGlltZVWvp-vmj86_r8JMB0MVmcs?usp=sharing).
