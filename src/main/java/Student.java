import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Student {
    public static void giveQuiz() throws IOException, ParseException {
        Scanner input = new Scanner(System.in);
        JSONParser parser = new JSONParser();
        JSONArray quizArray = (JSONArray) parser.parse(new FileReader("./src/main/resources/quiz.json"));

        while (true) {
            String choice = input.nextLine();

            if (!choice.equalsIgnoreCase("s")) {
                if (choice.equalsIgnoreCase("q")) {
                    break;
                }
                System.out.println("Invalid choice. Please press 's' to start or 'q' to quit.");
                continue;
            }

            int score = 0;
            Random random = new Random();
            HashSet<Integer> askedQuestions = new HashSet<>();

            for (int i = 0; i < 10; i++) {
                int randIndex;

                do {
                    randIndex = random.nextInt(quizArray.size());
                } while (askedQuestions.contains(randIndex));

                askedQuestions.add(randIndex);

                JSONObject questionObj = (JSONObject) quizArray.get(randIndex);

                System.out.println("[Question " + (i + 1) + "] " + questionObj.get("question"));
                System.out.println("1. " + questionObj.get("option 1"));
                System.out.println("2. " + questionObj.get("option 2"));
                System.out.println("3. " + questionObj.get("option 3"));
                System.out.println("4. " + questionObj.get("option 4"));
                System.out.print("Answer: ");

                int userAnswer = input.nextInt();
                input.nextLine();

                int correctAnswer = ((Long) questionObj.get("answerkey")).intValue();
                if (userAnswer == correctAnswer) {
                    score++;
                }
            }

            System.out.println("You got " + score + " out of 10.");
            if (score >= 8) {
                System.out.println("Excellent!");
            } else if (score >= 5) {
                System.out.println("Good.");
            } else if (score >= 2) {
                System.out.println("Very poor.");
            } else {
                System.out.println("Very sorry, you have failed.");
            }

            System.out.println("Would you like to start again? Press 's' to start or 'q' to quit.");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("q")) {
                break;
            }
        }
    }
}
