package scannereksempel;

import java.util.Scanner;

public class ScanNavn {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String navn = "";
        int alder;

        System.out.println("Indtast navn: ");
        navn = scan.next();
        System.out.println("Indtast alder: ");
        alder = scan.nextInt();
        if (alder < 18 || alder > 60) {
            System.out.println("Velkommen på DMU");
        } else {
            System.out.println("Su har ikke alderen til at være på DMU");
        }
        scan.close();
    }

}
