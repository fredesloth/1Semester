package application.model;

import java.util.ArrayList;

public class Company {
    private String name;
    private int hours; // weekly work hours

    // link to Employee class (--> 0..*)
    private ArrayList<Employee> employees = new ArrayList<>();

    public Company(String name, int hours) {
        this.name = name;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return name + " (" + hours + " hours)";
    }

    // -----------------------------------------------------------------------------

    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    // -----------------------------------------------------------------------------

    /**
     * Returns the count of employees in this company.
     */
    public int employeesCount() {
        return employees.size();
    }

    /**
     * Returns the total weekly salary of all employees in the company.
     */
    public int totalWeeklySalary() {
        int total = 0;
        for (Employee emp : employees) {
            total += emp.weeklySalary();
        }
        return total;
    }

}
