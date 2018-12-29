package Task3;

import java.lang.Math;
import java.io.IOException;
import java.io.FileWriter;

public abstract class Worker implements Comparable<Worker>{
    private double MonthSalary;
    private String name;
    private String surname;
    private long id;
    private double eps = 0.00001;

    public Worker(String name, String surname, double salary, long id){
        this.name = name;
        this.surname = surname;
        this.id = id;
        MonthSalary = countMonthSalary(salary);

    }

    abstract double countMonthSalary(double salary);

    public String getNameAndSurname(){
        return "surname: " + surname + "\n" + "name: " + name;
    }

    public  long getId(){
        return id;
    }

    public double getMonthSalary(){
        return MonthSalary;
    }

    public void writeObjectToFile(FileWriter fileWriter)throws IOException{
        fileWriter.write("Worker" + "\n");
        fileWriter.write("Surname: " + surname + "\n");
        fileWriter.write("Name: " + name + "\n");
        fileWriter.write("id: " + Long.toString(id) + "\n");
        fileWriter.write("Month average salary: " + Double.toString(MonthSalary) + "\n");
    }

    @Override
    public int compareTo(Worker other){

        if (Math.abs(this.MonthSalary - other.MonthSalary) > eps) return this.MonthSalary > other.MonthSalary ?  1 : -1;
        else return this.name.compareTo(other.name);
    }
}
