package CarRental;

public class Car {

    private String license;
    private double pricePerDay;
    private int purchaseYear;

    public Car(String license, double pricePerDay, int purchaseYear) {
        this.license = license;
        this.pricePerDay = pricePerDay;
        this.purchaseYear = purchaseYear;
    }

    public void setDayPrice(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public double getDayPrice() {
        return this.pricePerDay;
    }

    public String getLicense() {
        return this.license;
    }

    public int purchaseYear() {
        return this.purchaseYear;
    }

    // Til at få min ArrayList til at udskrive det ordenligt
    @Override
    public String toString() {
        return license + " " + pricePerDay + " " + purchaseYear;
    }

}
