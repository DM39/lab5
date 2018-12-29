package Task3;

public class FixedSalaryWorker extends Worker {

    private double fixedSalary;

    public FixedSalaryWorker(String name, String surname, double salary, long id) {
        super(name, surname, salary,id);
        fixedSalary = salary;
    }

    @Override
    double countMonthSalary(double salary) {
        return salary;
    }
}
