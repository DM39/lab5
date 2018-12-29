import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class Task5{

    public static void sort() {
        sortFile("1 English");
        sortFile("2 Русский");
        sortFile("3 Українська");
    }

    public static void sortFile(String file){
        System.out.println(String.format("\nSorting %s", file));
        List<Line> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String sub;
            while ((sub = bufferedReader.readLine()) != null) {
                lines.add(new Line(sub));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.sort(Line::compareTo);
        for (int i=0; i<lines.size(); i++) {
            System.out.println(lines.get(i).getLine());
        }
    }
}

class Line implements Comparable<Line>{
    private String text;
    Line(String text) {
        this.text = text;
    }
    String getLine(){return text;}
    public int compareTo(Line line){
        return text.toLowerCase().compareTo(line.getLine().toLowerCase());
    }
}
