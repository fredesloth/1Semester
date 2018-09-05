package Lektion8;

public class Teacher extends Person {
    private double monthlySalary;
    private double yearlySalary;
    private String subject;

    public Teacher(String name, String address, String qualification, double monthlySalary, String subject) {

        super(name, address, qualification);

        this.monthlySalary = monthlySalary;

        this.subject = subject;

    }

    public double getMontlySalery() {
        return monthlySalary;
    }

    public void setMonthlySalery(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public double yearlySalary() {
        this.yearlySalary = monthlySalary * 12 * 1.125;
        return yearlySalary;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public void udskrivPerson() {

        super.udskrivPerson();
        System.out.println("Månedsløn: " + monthlySalary);
        double yearlySalary = yearlySalary();
        System.out.println("Årsløn: " + yearlySalary);
        System.out.println("Undervisnings emne: " + subject);
    }
}
