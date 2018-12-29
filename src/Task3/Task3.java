package Task3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Task3{

    public static void main(String[] args) throws IOException {


        ArrayList<HourSalaryWorker> hourSalaryWorkers = getWorkerList("HourSalaryWorker.txt","hour salary");
        ArrayList<FixedSalaryWorker> fixedSalaryWorkers = getWorkerList("FixedSalaryWorker.txt","fixed salary");

        Collections.sort(hourSalaryWorkers);
        Collections.sort(fixedSalaryWorkers);

        System.out.println("First 5 name");

        System.out.println("\n" + "FixedSalaryWorkers");
        for (int i=0; i<5; i=i+1) System.out.println(fixedSalaryWorkers.get(i).getNameAndSurname());
        System.out.println("\n" + "HourSalaryWorkers");
        for (int i=0; i<5; i=i+1) System.out.println(hourSalaryWorkers.get(i).getNameAndSurname());

        System.out.println("\n" + "Last 3 ids");

        System.out.println("\n" + "FixedSalaryWorkers");
        for (int i=fixedSalaryWorkers.size()-1; i>=fixedSalaryWorkers.size()-4; i=i-1) System.out.println("id: " + Long.toString(fixedSalaryWorkers.get(i).getId()));
        System.out.println("\n" +   "HourSalaryWorkers");
        for (int i=hourSalaryWorkers.size()-1; i>=hourSalaryWorkers.size()-4; i=i-1) System.out.println("id: " + Long.toString(hourSalaryWorkers.get(i).getId()));
    }

    public static ArrayList getWorkerList(String filename, String salaryType)throws IOException{

        File file = new File(filename);
        Scanner scanner = new Scanner(file);


        if (salaryType.equals("hour salary")) {

            ArrayList<HourSalaryWorker> workersList = new ArrayList<HourSalaryWorker>();
            while (scanner.hasNextLine()) workersList.add(getNewHourSalaryWorker(scanner));
            return workersList;

        } else {

            ArrayList<FixedSalaryWorker> workersList = new ArrayList<FixedSalaryWorker>();
            while (scanner.hasNextLine()) workersList.add(getNewFixedSalaryWorker(scanner));
            return workersList;

        }

    }

    public static  HourSalaryWorker getNewHourSalaryWorker(Scanner scanner){

        String[] NewWorker = getWorker(scanner);
        String name = NewWorker[0];
        String surname = NewWorker[1];
        long id = Long.parseLong(NewWorker[2]);
        double salary = Double.parseDouble(NewWorker[3]);

        return new HourSalaryWorker(name,surname,salary,id);
    }

    public static  FixedSalaryWorker getNewFixedSalaryWorker(Scanner scanner){

        String[] NewWorker = getWorker(scanner);
        String surname = NewWorker[0];
        String name = NewWorker[1];
        long id = Long.parseLong(NewWorker[2]);
        double salary = Double.parseDouble(NewWorker[3]);

        return new FixedSalaryWorker(name,surname,salary,id);
    }
    public static String[] getWorker(Scanner scanner){
        return scanner.nextLine().split(" ");
    }
}