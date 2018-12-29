package Task3;

public class HourSalaryWorker extends Worker {

    private double hourSalary;

    public HourSalaryWorker(String name, String surname, double salary, long id) {
        super(name, surname, salary,id);
        hourSalary = salary;
    }

    @Override
    double countMonthSalary(double salary) {
        return 20.8 * 8 * salary;
    }
}
