package opgave1;

public class Synsmand extends Mekaniker {
    private int antalSyn;

    public Synsmand(String name, String adress, int hourlyPay, int graduationYear, int antalSyn) {
        super(name, adress, hourlyPay, graduationYear);
        this.antalSyn = antalSyn;
    }

    public int getAntalSyn() {
        return this.antalSyn;
    }

    public void setAntalSyn(int antalSyn) {
        this.antalSyn = antalSyn;
    }

    public double getBonusSyn() {
        return antalSyn + 250;
    }

    @Override
    public double getWeeklyPay() {
        return super.getWeeklyPay() + getBonusSyn();
    }

    @Override
    public String toString() {
        return "Navn: " + super.getName() + "\n" + "Adresse: " + super.getAdress() + "\n" + "Svendeprøve år: "
                + super.getGraduationYear() + "\n" + "Timeløn: " + super.getHourlyPay() + "\n" + "Antal syn: "
                + getAntalSyn() + "\n" + "Ugeløn: " + getWeeklyPay();
    }

}
