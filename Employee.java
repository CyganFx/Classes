/**
 * Employee class template
 */
public class Employee {
    private String name;
    private double rate;
    private int hours;
    private static int totalSumOfHours;
    private static int employeeCounter;

    public Employee() {
        employeeCounter++;
        totalSumOfHours += hours;
    }

    public Employee(String name, int rate) {
        this.name = name;
        this.rate = rate;
        employeeCounter++;
    }

    public Employee(String name, int rate, int hours) {
        this.name = name;
        this.rate = rate;
        this.hours = hours;
        employeeCounter++;
        totalSumOfHours += hours;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getRate() { return rate; }

    public void setRate(double rate) { this.rate = rate; }

    public int getHours() { return hours; }

    public void setHours(int hours) {
        totalSumOfHours += hours - this.hours;
        this.hours = hours;
    }

    public static int getTotalSumOfHours() { return totalSumOfHours; }

    public static int getEmployeeCounter() { return employeeCounter; }

    public double salary() {
        return (double) Math.round((rate * hours + bonuses()) * 100) / 100;
    }

    public double bonuses() {
        return (rate * hours) * 0.1;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", hours=" + hours +
                '}';
    }
}
