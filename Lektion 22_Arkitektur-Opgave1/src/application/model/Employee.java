package application.model;

public class Employee {
    private String name;
    private int wage; // hourly wage
    // Employment year
    private int employmentYear;

    // link to company class (--> 0..1)
    private Company company;

    // EMPLOYMENTYEAR HVIS PERSONEN ER ANSAT ET STED
    public Employee(String name, int wage, int employmentYear) {
        this.name = name;
        this.wage = wage;
        this.employmentYear = employmentYear;
    }

    // HVIS PERSONEN IKKE ER ANSAT ET STED
    public Employee(String name, int wage) {
        this.name = name;
        this.wage = wage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    // GET-METODE
    public int getEmploymentYear() {
        return employmentYear;
    }

    // SET-METODE
    public void setEmploymentYear(int employmentYear) {
        this.employmentYear = employmentYear;
    }

    @Override
    public String toString() {
        return name + " (kr " + wage + ")";
    }

    // -----------------------------------------------------------------------------

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void clearCompany() {
        company = null;
    }

    // -----------------------------------------------------------------------------

    /**
     * Returns the weekly salary of this employee.
     */
    public int weeklySalary() {
        int salary = wage * company.getHours();
        return salary;
    }

}
