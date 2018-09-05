package opgaver;

import java.util.Scanner;

public class P41 {

    public static void main(String[] args) {
        /*
         * Write a program that reads an interger and prints whether it is negative,
         * zero or positive
         */

        Scanner scan = new Scanner(System.in);
        System.out.println("Insert number ");
        int number = scan.nextInt();

        if (number < 0.0) {
            System.out.println("The number is less than zero");
        } else if (number == 0.0) {
            System.out.println("The number is zero");
        } else if (number > 0) {
            System.out.println("The number is greater than zero");
        }
        scan.close();
    }

}
