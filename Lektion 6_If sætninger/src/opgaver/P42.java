package opgaver;

import java.util.Scanner;

public class P42 {

    public static void main(String[] args) {
        /*
         * Wtire a program that reads a floating-point number and prints "zero" if the
         * number is zero. Otherwise, print, "positive" or "negative". Add "small" if
         * the absolute value of the number is less than 1, or "large" if it exceeds
         * 1.000.000
         */

        Scanner scan = new Scanner(System.in);
        System.out.println("Skrive her et tal: ");
        double number = scan.nextDouble();

        if (number == 0.0) {
            System.out.println("The number is zero");
        } else if (number < 0.0) {
            System.out.println("The number is less than zero");
        } else if (number > 0.0) {
            System.out.println("The number is greater than zero");
        }

        scan.close();
    }

}
