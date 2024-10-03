import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Admin {

    public static void addQuizQuestions() throws IOException, ParseException {
        Scanner input = new Scanner(System.in);
        JSONParser parser = new JSONParser();
        String filepath = "./src/main/resources/quiz.json";

        JSONArray quizArray = (JSONArray) parser.parse(new FileReader(filepath));

        while (true) {
            System.out.println("Input your question");
            String question = input.nextLine();

            System.out.println("Input option 1:");
            String option1 = input.nextLine();

            System.out.println("Input option 2:");
            String option2 = input.nextLine();

            System.out.println("Input option 3:");
            String option3 = input.nextLine();

            System.out.println("Input option 4:");
            String option4 = input.nextLine();

            int answerKey;
            while (true) {
                System.out.println("What is the answer key? (1-4)");
                answerKey = input.nextInt();
                input.nextLine();

                if (answerKey >= 1 && answerKey <= 4) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                }
            }

            JSONObject questionObj = new JSONObject();
            questionObj.put("question", question);
            questionObj.put("option 1", option1);
            questionObj.put("option 2", option2);
            questionObj.put("option 3", option3);
            questionObj.put("option 4", option4);
            questionObj.put("answerkey", answerKey);

            quizArray.add(questionObj);

            FileWriter writer = new FileWriter(filepath);
            writer.write(quizArray.toJSONString());
            writer.flush();
            writer.close();
            System.out.println("Saved successfully!");

            String choice;
            while (true) {
                System.out.println("Do you want to add more questions? (Press 's' to start adding, 'q' to quit)");
                choice = input.nextLine();

                if (choice.equalsIgnoreCase("s")) {
                    break;
                } else if (choice.equalsIgnoreCase("q")) {
                    return;
                } else {
                    System.out.println("Invalid input. Please press 's' to start adding more or 'q' to quit.");
                }
            }
        }
    }
}
