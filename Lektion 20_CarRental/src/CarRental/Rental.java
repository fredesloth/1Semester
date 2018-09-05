package CarRental;

import java.util.ArrayList;

public class Rental {

    private int number;
    private int days;
    private String date;
    private ArrayList<Car> carRental;

    public Rental(int number, int days, String date) {
        this.number = number;
        this.days = days;
        this.date = date;
    }

    public double getPrice(Car c) {
        return this.days * c.getDayPrice();
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return this.days;
    }

}
