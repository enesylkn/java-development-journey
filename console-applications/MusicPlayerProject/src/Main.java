import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // How to PLAY AUDIO with Java (.wav,.au,.aiff)
        
        String filePath = "src\\Gel_Kacalim_Beat.wav";
        File file = new File(filePath);
        
        try(Scanner scanner = new Scanner(System.in);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {
            
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            
            String response = "";
            
            while (!response.equals("Q")) {
                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("R = Reset");
                System.out.println("Q = Quit");
                System.out.print("Enter your choice: ");
                
                response = scanner.nextLine().toUpperCase();
                
                switch (response){
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("Invalid choice");
                }
                
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Could not locate this file");
        }
         catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported Audio File!");
        } catch (LineUnavailableException e) {
            System.out.println("Unable to access audio resource");
        }
        catch (IOException e){
            System.out.println("Something went wrong");
        }
        finally {
            System.out.println("Ears have to sleep:(");
        }
        
    }
}
