package homework3;

public class Worker extends Employee {
    private double salary;
    public Worker(String name, int salary, int age) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public double averageMonthlySalary() {
        return salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
