package ArrayListMethods;

import java.util.ArrayList;

public class ArrayListMethodsApp {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(19);
        list.add(35);
        list.add(14);
        list.add(7);
        list.add(0);

        ArrayListMethods methods = new ArrayListMethods();

        System.out.println(list);
        System.out.println("Summen af tallene i listen (med for): " + methods.sumListeFor(list));
        System.out.println("Summen af tallene i listen (med forEach): " + methods.sumListeForEach(list));
        System.out.println("Indeks for det første lige tal: " + methods.hasEvenAtIndex(list));

        System.out.println("Det mindste af tallene i listen er: " + methods.min(list));

        System.out.println("Gennemsnit af tallene i listen er: " + methods.gennemsnit(list));

        System.out.println("Tallet 0 optræder så mange gange i listen: " + methods.antalNuller(list));

        System.out.println("Test med tallet 0 med for each løkke: " + methods.antalNuller2(list));

        System.out.println("Her er der en liste med alle de lige tal: " + methods.enLigeListe(list));
    }

}
