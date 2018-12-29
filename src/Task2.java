import java.io.*;
import java.util.*;

public class Task2 {

    public static void run(){

        List<Integer> alpha = new ArrayList<Integer>();
        List<Integer> beta = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < 150; i++){
            alpha.add(rand.nextInt(200)+1);
        }

        for (int k=200; k>=0; k--) {
            for (int i = 0; i < 150; i++) {
                if (beta.size() == 15) break;
                else if (alpha.get(i).equals(k)) beta.add(k);
            }
        }

        try(FileWriter writer = new FileWriter("Task2.txt", false);){
            String answer = beta.toString();
            writer.write(answer.substring(1, answer.length()-1));
        }
        catch (IOException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

}