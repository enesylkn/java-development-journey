import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    
        // ALARM CLOCK
        
        String filePath = "src/alarmSound.wav";
        File file = new File(filePath);
        
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        
        while (alarmTime == null){
            try{
                System.out.print("Enter an alarm time (HH:MM:SS): ");
                String inputTime = scanner.nextLine();
                
                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for " + alarmTime);
            }
            catch (DateTimeParseException e){
                System.out.println("Invalid format. Please use HH:MM:SS");
            }
        }
        
        AlarmClock alarmClock = new AlarmClock(alarmTime);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();
        
        try {
            alarmThread.join();
        } catch (InterruptedException e) {
            System.out.println("Runtime issue");
        }
        
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){
            
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            
            Thread.sleep(1000);
            clip.setFramePosition(0);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
            System.out.print("\nPlease push enter to stop alarm!");
            scanner.nextLine();
            
            clip.stop();
            clip.close();
            
            
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported file1");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        
        scanner.close();
        
    }
}
