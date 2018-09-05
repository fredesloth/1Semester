package CarRental;

import java.util.ArrayList;

public class TestCarRental {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // Opret 5 biler
        Car Opel = new Car("AB22444", 120, 2014);
        Car AlfaRomeo = new Car("CE33999", 540, 2016);
        Car Fiat = new Car("XE11222", 150, 2010);
        Car Citroen = new Car("ZA22888", 250, 2017);
        Car VW = new Car("PZ99777", 200, 2015);

        // Opret 2 Udlejninger
        Rental Lars = new Rental(17, 3, "11-04-2017");
        Rental Per = new Rental(12, 5, "27-05-2017");

        ArrayList<Car> CarRentalList = new ArrayList<>();
        CarRentalList.add(Citroen);
        CarRentalList.add(Opel);
        CarRentalList.add(AlfaRomeo);
        CarRentalList.add(Fiat);
        CarRentalList.add(VW);

        System.out.println(CarRentalList);

        System.out.println();
        System.out.println(Lars.getPrice(Opel));
        System.out.println();
        System.out.println(Per.getPrice(Citroen));
        System.out.println();
        Lars.setDays(10);
        System.out.println(Lars.getPrice(Opel));
    }

}
