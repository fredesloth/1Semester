package lektion13;

import java.util.ArrayList;

public class Opgave1 {

    public static void main(String[] args) {

        ArrayList<String> navn = new ArrayList<>();

        navn.add("Hans");
        navn.add("Viggo");
        navn.add("Jens");
        navn.add("Børge");
        navn.add("Bent");

        // Udskriver antal elementer i listen
        System.out.println(navn.size());

        // Tilføjer tekststrengen ”Jane” på indeks plads 2 i listen
        navn.add(2, "Jane");

        // Udskriver indholdet af listen
        System.out.println(navn);

        // Sletter elementet på indeks plads 1 i listen
        navn.remove(1);
        System.out.println(navn);

        // Tilføjer teksten ”Pia” forrest i listen
        navn.add(0, "Pia");
        System.out.println(navn);

        // Tilføjer teksten ”Ib” bagerst i listen
        navn.add("Ib");
        System.out.println(navn);

        // På indeks plads 2 skal elementet ændres til at være ”Hansi”
        navn.set(2, "Hansi");
        System.out.println(navn);

        // Udskriver antal elementer i listen
        System.out.println(navn.size());

        // Udskriver indholdet af listen
        System.out.println(navn);

        // Gennemløber listen med en for – løkke og udskiver længden på hver af
        // tekststrengene i listen
        for (int i = 0; i < navn.size(); i++) {
            System.out.println(navn.get(i) + " " + navn.get(i).length());
        }

        // dette er bare et mellemrum for at danne overskuelighed mellem opgaverne

        System.out.println("");
        // Gennemløber listen med en for-each – løkke og udskiver længden på hver af
        // tekststrengene i listen

        for (String i : navn) {
            System.out.println(i + " " + i.length());
        }

    }

}
