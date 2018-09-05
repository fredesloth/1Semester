package opgaver;

import java.util.Scanner;

public class P45 {

    public static void main(String[] args) {
        /*
         * Wtire a program that reads three numbers and prints "increasing" if they are
         * in increasin order, "Decreasing" if they are in decreasing order, and
         * "neither" otherwise. Here "increasing" means "Strictly increasing", with each
         * value larger than its predecessor. The sequence 3 4 4 would not be considered
         * increasing
         */

        Scanner scan = new Scanner(System.in);
        System.out.println("Insert number: ");
        int number1 = scan.nextInt();
        System.out.println("Write another one: ");
        int number2 = scan.nextInt();
        System.out.println("Write another one again ");
        int number3 = scan.nextInt();

        if (number1 < number2 && number2 < number3) {
            System.out.println("Increasing");
        } else if (number1 > number2 && number2 > number3) {
            System.out.println("Decreasing");
        } else {
            System.out.println("Oterwise");
        }
        scan.close();
    }

}
