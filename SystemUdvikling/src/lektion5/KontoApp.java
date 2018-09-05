package lektion5;

public class KontoApp {

    public static void main(String[] args) {

        Konto test = new Konto("Privat", 1);
        test.setSaldo(1500);
        test.printKonto();
        test.setIndsætBeløb(250);
        test.printKonto();
        test.setIndsætBeløb(230);
        test.printKonto();
    }

}
