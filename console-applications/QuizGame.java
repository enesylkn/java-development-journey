import java.util.Random;
import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args){
        String[] questions = {"Which method is used to append a single item to the end of a list in Python?",
                                "Which of the following is an immutable data type in Python?",
                                "What does 'typeof null' evaluate to in JavaScript?",
                                "What is the key difference between '==' and '===' in JavaScript?",
                                "In Java, what is the default value of an uninitialized boolean instance variable in a class?"};
        String[][] options = {
                {"1) add()", "2) append()", "3) push()", "4) insert()"},
                {"1) list", "2) dict", "3) tuple", "4) set"},
                {"1) null", "2) undefined", "3) object", "4) boolean"},
                {"1) '==' only compares numbers", "2) '===' checks value and type without coercion", "3) '===' only works on strings", "4) There is no difference"},
                {"1) true", "2) false", "3) null", "4) 0"}
        };
        String[] answers = {"2", "3", "3", "2", "2"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int question_number = 0;
        int correct_answer = 0;
        int totalQuestions = questions.length;
        boolean isFinal = false;
        boolean[] asked = new boolean[totalQuestions];
        String guess;


        System.out.println("*************************************");
        System.out.println("Welcome to the Programming Quiz Game!");
        System.out.println("*************************************");
        int[] questionProblem = {};

        while (!isFinal){
            int random_number;

            // Henüz sorulmamış bir soru bulana kadar rastgele sayı üret
            do {
                random_number = random.nextInt(totalQuestions); // 0 ile 4 arası
            } while (asked[random_number]);

            // Soruldu olarak işaretle
            asked[random_number] = true;
            String question_pick = questions[random_number];
            System.out.println(question_pick);
            for (int i = 0 ; i < options[random_number].length ; i++){
                System.out.println(options[random_number][i]);
            }
            System.out.print("Enter your guess: ");
            guess = scanner.nextLine().trim();
            question_number += 1;
            if (answers[random_number].equals(guess)){
                System.out.println("*******");
                System.out.println("CORRECT");
                System.out.println("*******");
                correct_answer += 1;
            }
            else{
                System.out.println("*****");
                System.out.println("WRONG");
                System.out.println("*****");
                System.out.println("The answer was " + answers[random_number]);
            }
            if (question_number == totalQuestions){
                isFinal = true;
            }
        }
        System.out.println("***************************************");
        System.out.println("Your final score is " + correct_answer + " out of " + question_number);
        scanner.close();
    }
}
