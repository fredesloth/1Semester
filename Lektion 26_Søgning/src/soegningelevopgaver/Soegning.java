package soegningelevopgaver;

public class Soegning {

    public boolean findUlige(int[] tabel) {
        boolean found = false;
        int i = 0;
        while (!found && i < tabel.length) {
            int k = tabel[i];
            if (k % 2 != 0) {
                found = true;
            } else {
                i++;
            }
        }

        return found;
    }

    public boolean findHeltal(int[] tabel) {
        boolean found = false;
        int i = 0;
        while (!found && i < tabel.length) {
            int k = tabel[i];
            if (k >= 10 && k <= 15) {
                found = true;
            } else {
                i++;
            }
        }
        return found;
    }

    // her skriver du metoder til opgaverne 2,3,5,6 og 7

    public boolean arrayHeltal(int[] tabel) {
        boolean found = false;
        // int i = 0;
        // while (!found && i < tabel.length) {
        for (int i = 0; i < tabel.length && !found; i++) {
            int k = tabel[i];
            if (k % 2 != 0) {
                found = true;
            }
        }
        return found;
    }
}
