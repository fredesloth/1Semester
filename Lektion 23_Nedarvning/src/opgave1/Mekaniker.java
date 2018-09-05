package opgave1;

import java.util.ArrayList;

public class Mekaniker extends Person {
    private int graduationYear;
    private double hourlyPay;
    ArrayList<Mekaniker> alleMekanikere = new ArrayList<>();

    public Mekaniker(String name, String adress, int graduationYear, double hourlyPay) {
        super(name, adress);
        this.graduationYear = graduationYear;
        this.hourlyPay = hourlyPay;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    public double getWeeklyPay() {
        return hourlyPay * 37;
    }

    @Override
    public String toString() {
        return "Navn: " + super.getName() + "\n" + "Adresse: " + super.getAdress() + "\n" + "Svendeprøve år: "
                + graduationYear + "\n" + "Timeløn: " + hourlyPay + "\n" + "Ugeløn: " + getWeeklyPay();
    }

}
