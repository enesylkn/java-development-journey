import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    
        String wordFile = "words.txt";
        char guess;
        File file = new File(wordFile);
        
        Scanner scanner = new Scanner(System.in);
        
        Random random = new Random();
        
        ArrayList<String> words = new ArrayList<>();
        
        
        ArrayList<Character> wordState = new ArrayList<>();
        
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            
            String line;
            
            while((line = reader.readLine()) != null){
                words.add(line.trim());
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Could not found file location");
        } catch (IOException e) {
            System.out.println("Something went wrong!");;
        }
        int randomWordIndex = random.nextInt(words.size());
        String randomWordPulling = words.get(randomWordIndex);
        int lengthOfWord = randomWordPulling.length();
        int wrongGuesses = 0;
        ArrayList<Character> guessList = new ArrayList<>();
        
        for (int i = 0; i < lengthOfWord; i++) {
            wordState.add('_');
        }
        System.out.println("**********************");
        System.out.println("Welcome to The Hangman");
        System.out.println("**********************");
        while(!(wrongGuesses == 6)) {
            if (!(wordState.contains('_'))){
                System.out.println("Well Done! You found it!");
                break;
            }
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.print("Word: ");
            for (Character character : wordState) {
                System.out.print(character + " ");
            }
            System.out.println();
            System.out.print("Guess a letter: ");
            guess = scanner.nextLine().charAt(0);
            if (guessList.contains(guess)){
                System.out.println("You've already guess that");
                continue;
            }
            guessList.add(guess);
            
            boolean isCorrect = false;
            
            
            for (int i = 0; i < lengthOfWord; i++) {
                if (randomWordPulling.charAt(i) == guess) {
                    wordState.set(i, guess);
                    isCorrect = true;
                }
            }
            
            if (isCorrect)
                System.out.println("Correct Guess");
            else {
                System.out.println("Wrong Guess!!");
                wrongGuesses++;
            }
        }
        if (wrongGuesses == 6){
            System.out.println(getHangmanArt(6));
            System.out.println("Word was "+ randomWordPulling);
        }
        
        
        scanner.close();
        
    
    }
    static String getHangmanArt(int wrongGuesses){
        return switch (wrongGuesses){
            case 0 -> """
                      
                      
                      
                      """;
            case 1 -> """
                       O
                      
                      
                      """;
            case 2 -> """
                       O
                      /
                      
                      """;
            case 3 -> """
                       O
                      /|
                      
                      """;
            case 4 -> """
                       O
                      /|\\
                      
                      """;
            case 5 -> """
                       O
                      /|\\
                      /
                      """;
            case 6 -> """
                       O
                      /|\\
                      / \\
                      """;
            default -> "";
        };
    }
}
