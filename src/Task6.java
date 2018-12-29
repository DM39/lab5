import java.util.Scanner;

public class Task6 {

    public static void reverse(){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        char[]reverse = line.toCharArray();
        for(int i=0;i<reverse.length/2;i++)
        {
            char x = reverse[i];
            reverse[i] = reverse[reverse.length-i-1];
            reverse[reverse.length-i-1]= x;
        }
        System.out.print(new String(reverse));
    }
}