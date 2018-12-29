import javax.sound.sampled.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Task4 {

    public static void guess(){

        Random rand = new Random();
        int random = rand.nextInt(101);
        int low = 0;
        int high = 100;
        Scanner in = new Scanner(System.in);
        int attempt;
        System.out.println(String.format("Behold the great RANDOMIZATOR. Try to guess an Integer in range %d-%d", low, high));
        while (true){

            String line = in.nextLine();
            try {
                attempt = Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.print("Try again\n");
                continue;
            }
            if (attempt > high || attempt < low) {
                System.out.print(String.format("Don't you know how to read? Try %d-%d\n", low, high));
                try {
                    File soundFile = new File("1.wav");
                    AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.setFramePosition(0);
                    clip.start();
                    Thread.sleep(clip.getMicrosecondLength()/1000);
                    clip.stop();
                    clip.close();
                } catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
                    exc.printStackTrace();
                } catch (InterruptedException exc) {  continue; }
            }

            else if (attempt == random){
                System.out.print(String.format("Well done. It's exactly %d\n", attempt));
                break;
            }
            else if ((low==random || high==random)&&(Math.abs(attempt-random)==1)) {
                System.out.print(String.format("You're the fool. It's %d. I won\n", random));
                break;
            }
            else if (attempt < random){
                low = attempt+1;
                System.out.print(String.format("Too little, try %d-%d\n", low, high));
            }
            else if (attempt > random){
                high = attempt-1;
                System.out.print(String.format("Too big, try %d-%d\n", low, high));
            }
        }
    }
}