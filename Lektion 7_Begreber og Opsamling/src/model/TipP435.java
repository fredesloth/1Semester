package model;

import java.util.Scanner;

public class TipP435 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Hvor glad er du for vores service? 1 = Totalt tilfreds, 2 = Tilfreds eller 3 = Ikke tilfreds");
        int service = scan.nextInt();

        int madPris = 100;

        if (service == 1) {
            System.out.println("Du kan betale 20% i drikkepenge " + (madPris * 0.20));
        } else if (service == 2) {
            System.out.println("Du kan betale 15% i drikkepenge " + (madPris * 0.15));
        } else if (service == 3) {
            System.out.println("Du kan betale 10% i drikkepenge " + (madPris * 0.10));
        }

        scan.close();
    }

}
