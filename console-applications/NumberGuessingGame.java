import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int guess = 0;
        int randomNumber = 0;
        int min = 1;
        int max = 100;
        int attempts = 0;

        System.out.println("Number Guessing Game");
        System.out.println("Guess a number between 1-100");
        randomNumber = random.nextInt(min,max + 1);

        do{
            System.out.print("Enter a Guess: ");
            guess = scanner.nextInt();
            attempts++;
            if (guess > randomNumber){
                System.out.println("TOO HIGH! Try again");
            }
            else if (guess < randomNumber){
                System.out.println("TOO LOW! Try again");
            }
            else {
                System.out.println("CORRECT! The number was " + guess);
                System.out.printf("%d of attemps you did",attempts);
            }

        }while(guess != randomNumber);
        System.out.println("\nYou have won! Number is " + guess);

        scanner.close();

    }
}
