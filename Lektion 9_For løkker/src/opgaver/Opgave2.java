package opgaver;

public class Opgave2 {
    public static void main(String[] args) {
        // Lav en for-løkke der udskriver alle de ulige tal fra 1 til 99 (inklusiv)

        int i;
        for (i = 1; i < 99; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }

        }

    }

}
