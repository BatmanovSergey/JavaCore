package homework3;

public class Freelancer extends Employee {
    private double hourlyRate;

    public Freelancer(String name, int age, int hourlyRate) {
        super(name, age);
        this.hourlyRate = hourlyRate;
    }


    @Override
    public double averageMonthlySalary() {
        return 20.8 * 8 * hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }


}
