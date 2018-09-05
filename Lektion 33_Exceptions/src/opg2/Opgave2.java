package opg2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Opgave2 {

    public static void main(String[] args) {
        // Indlæser filen mary.txt
        File file = new File("mary.txt");
        // opretter scanner sc
        Scanner sc;

        // Når man bruger en try skal der være en catch eller en final
        try {
            // initalisere en scanner
            sc = new Scanner(file);
            // j laves så når der for-loopet kører, så tæller den, den en op
            int j = 1;
            // kører et for-loop, som går længden af mary.txt (file) længde
            for (int i = 0; i < file.length(); i++) {
                // hasNextLine spørger om der er en næste linje
                while (sc.hasNextLine()) {
                    // læser den næste linje og giver den til scanner
                    String s = sc.nextLine();
                    System.out.print("/*" + j + "*/ " + s);
                    System.out.println();
                    // j giver en stigende strofe linje
                    j++;

                }
            }
            // hvis filen ikke findes så giver den, denne besked
        } catch (FileNotFoundException e) {
            System.out.println("Filen er ikke fundet");
        }

    }

}
