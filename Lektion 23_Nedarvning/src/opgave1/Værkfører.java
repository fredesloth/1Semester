package opgave1;

public class Værkfører extends Mekaniker {
    private int foremanYear;
    private double foremanBonus;

    public Værkfører(String name, String adress, int graduationYear, int hourlyPay, int foremanYear,
            double foremanBonus) {
        super(name, adress, hourlyPay, graduationYear);
        this.foremanBonus = foremanBonus;
        this.foremanYear = foremanYear;
    }

    public double getForemanPay() {
        return super.getHourlyPay() + foremanBonus;
    }

    public void setForemanPay(double foremanBonus) {
        this.foremanBonus = foremanBonus;
    }

    public double getForemanYear() {
        return foremanYear;
    }

    public void setForemanYear(int foremanYear) {
        this.foremanYear = foremanYear;
    }

    @Override
    public double getWeeklyPay() {

        return super.getWeeklyPay() + foremanBonus;
    }

    @Override
    public String toString() {
        return "Navn: " + super.getName() + "\n" + "Adresse: " + super.getAdress() + "\n" + "Svendeprøve år: "
                + super.getGraduationYear() + "\n" + "Timeløn: " + super.getHourlyPay() + "\n" + "Værkfører år:"
                + foremanYear + "\n" + "Værkfører bonus: " + foremanBonus + "\n" + "Ugeløn: " + getWeeklyPay();
    }
}
