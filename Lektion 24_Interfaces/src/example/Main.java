package example;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random(123);
        BankAccount[] b = new BankAccount[10];
        for (int i = 0; i < 10; i++) {
            b[i] = new BankAccount(random.nextInt(8) * 1000);
        }

        System.out.println(Arrays.toString(b));
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
        //Collection.sort

    }

}
