import org.json.simple.parser.ParseException;
import java.io.IOException;

public class Home {
    public static void main(String[] args) throws IOException, ParseException {
        User user = null;

        while (user == null) {
            user = User.login();
        }

        if (user.getRole().equals("admin")) {
            System.out.println("Welcome admin! Please create new questions in the question bank.");
            Admin.addQuizQuestions();
        } else if (user.getRole().equals("student")) {
            System.out.println("Welcome " + user.getName() + " to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start.");
            Student.giveQuiz();
        }
    }
}
