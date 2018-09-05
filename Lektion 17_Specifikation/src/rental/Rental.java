package rental;

import java.time.LocalDate;

/**
 * Modelere en ny udlejning
 *
 */
public class Rental {
    private int number;
    private int days;
    private LocalDate startDate;
    private double price;

    /**
     * Initialisere en en ny udlejning
     *
     * @param number
     *            - nummeret på den enhed som skal udlejes
     * @param price
     *            - dagsprisen på den enhed som skal udlejes
     * @param days
     *            - er antal dage som enheden skal udlejes
     * @param startDate
     *            - den dato hvorpå den udlejes
     *
     */

    public Rental(int number, double price, int days, LocalDate startDate) {
        this.number = number;
        this.days = days;
        this.price = price;
        this.startDate = startDate;
    }

    public double getPricePrDay() {
        return price;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        LocalDate endDate = startDate.plusDays(days);
        return endDate;
    }

    public double getTotalPrice() {
        double totalPrice = days * price;
        return totalPrice;
    }
}
