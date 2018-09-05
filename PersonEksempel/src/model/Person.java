package model;

public class Person {

    // Dette er attributter
    private String name;
    private String adress;
    private double monthlySalery;
    private String yearlySalery;

    // Dette er constructoren
    public Person(String inputName, String inputAdress, double inputMonthlySalery) {
        // man kan også godt bruge this. i stedet for, så man slipper for inputName. som
        // fx this.name = name
        name = inputName;
        adress = inputAdress;
        monthlySalery = inputMonthlySalery;
    }

    public void setName(String inputName) {
        name = inputName;
    }

    public String getName() {
        return name;
    }

    // Dette er en mutator (void)
    public void setAdress(String inputAdress) {
        adress = inputAdress;
    }

    public String getAdress() {
        return adress;
    }

    public void setMonthlySalery(double inputMonthlySalery) {
        monthlySalery = inputMonthlySalery;
    }

    public double getMonthlySalery() {
        return monthlySalery;
    }

    public double getYearlySalery() {
        return monthlySalery * 12;
    }

    public void printPerson() {
        System.out.println("****************************************");
        System.out.println("Name: " + name);
        System.out.println("Adress: " + adress);
        System.out.println("Monthly salery: " + monthlySalery);
        System.out.println("Yearly salery: " + yearlySalery);

    }

}
