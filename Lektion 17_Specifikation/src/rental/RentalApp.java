package rental;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class RentalApp {

    public static void main(String[] args) {
        // udlejning skal starte den første i næste måned
        Rental test1 = new Rental(12, 500, 6, LocalDate.of(2018, 4, 1));
        System.out.println("End date: " + test1.getEndDate());
        System.out.println("Price pr day: " + test1.getPricePrDay());
        System.out.println("Total price: " + test1.getTotalPrice());
        System.out.println();
        // skal starte 10 måneder
        Rental test2 = new Rental(12, 1200, 8, LocalDate.now().plusMonths(10));
        System.out.println("End date: " + test2.getEndDate());
        System.out.println("Price pr day: " + test2.getPricePrDay());
        System.out.println("Total price: " + test2.getTotalPrice());

        System.out.println();
        // Udskriv antallet af år, måneder og dage mellem startdatoen for den første
        // udlejning og startdatoen på den anden udlejning.
        LocalDate dat1 = LocalDate.of(2018, 4, 1);
        LocalDate dat2 = LocalDate.now().plusMonths(10);
        Period per = dat1.until(dat2);
        System.out.println(per);
        System.out.println("9 måneder og 18 dage");

        System.out.println();
        // Udskriv også antallet af dage mellem startdatoerne for de to udlejninger.
        long days = ChronoUnit.DAYS.between(dat1, dat2);
        System.out.println("Antal dage mellem de to startdatoer: " + days);
    }

}
