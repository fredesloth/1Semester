package eksempelcar;

public class CarApp {

    public static void main(String[] args) {
        Car myCar = new Car("VW UP", "White");
        System.out.println("******************************************");
        System.out.println(myCar.getBrand());
        myCar.setRegistrationNumber("AB 11 123");
        System.out.println(myCar.getRegistrationNumber());
        myCar.setKm(250000);
        System.out.println(myCar.getKm() + " Km");
        System.out.println("******************************************");

        Car Ford = new Car("Ford Focus", "Grøn");
        System.out.println(Ford.getBrand());
        Ford.setRegistrationNumber("AA 11 222");
        System.out.println(Ford.getRegistrationNumber());
        Ford.setKm(1200000);
        System.out.println(Ford.getKm() + " Km");
        System.out.println("******************************************");

    }

}
