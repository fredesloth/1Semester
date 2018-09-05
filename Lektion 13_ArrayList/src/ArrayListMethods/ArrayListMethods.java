package ArrayListMethods;

import java.util.ArrayList;

public class ArrayListMethods {

    /**
     * Sums the numbers in the list using a for loop each
     */
    public int sumListeForEach(ArrayList<Integer> list) {
        int resultat = 0;
        for (int tal : list) {
            resultat = resultat + tal;
        }
        return resultat;
    }

    /**
     * Sums the numbers in the list using a for loop
     */
    public int sumListeFor(ArrayList<Integer> list) {
        int resultat = 0;
        for (int i = 0; i < list.size(); i++) {
            resultat = resultat + list.get(i);
        }
        return resultat;
    }

    /**
     * Returns the index of the first even number
     */
    public int hasEvenAtIndex(ArrayList<Integer> list) {
        int index = -1;
        int i = 0;
        while (index == -1 && i < list.size()) {
            if (list.get(i) % 2 == 0) {
                index = i;
            }
            i++;
        }
        return index;
    }

    /**
     * Returnerer det mindste tal i list
     */
    public int min(ArrayList<Integer> list) {
        // int min = list.get(0);
        int min = Integer.MAX_VALUE; // sætter "min" som int commandoen's største tal. Hvis nu at den første punkt på
                                     // listen er for tom
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        return min;
    }

    /**
     * Returnerer gemmensnittet af tallene i list
     */
    public double gennemsnit(ArrayList<Integer> list) {
        double sum = 0;
        for (int tal : list) {
            sum = (sum + tal);
        }
        double gnm = 0;
        gnm = sum / list.size();
        return gnm;
    }

    // if (list.get(i)==0) antal++
    /**
     * Returnerer antallet af gange 0 er i list
     */
    public int antalNuller(ArrayList<Integer> list) {
        int antal = 0;
        // man kan også godt lave for-each løkke, da man her ikke behøver at bruge en
        // index af tallene, man skal bare vide hvor mange nuller der er
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                antal++;
            }
        }
        return antal;
    }

    public int antalNuller2(ArrayList<Integer> list) {
        int antal = 0;
        for (int tal : list) {
            if (tal == 0) {
                antal++;
            }
        }
        return antal;
    }

    /**
     * Returnerer en ny liste indeholdende alle de lige tal fra list
     */
    public ArrayList<Integer> enLigeListe(ArrayList<Integer> list) {
        ArrayList<Integer> listLigeTal = new ArrayList<>();
        for (int tal : list) {
            if (tal % 2 == 0) {

                listLigeTal.add(tal);
            }
        }
        return listLigeTal;
    }

}
