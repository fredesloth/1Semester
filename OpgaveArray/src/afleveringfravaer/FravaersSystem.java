package afleveringfravaer;

public class FravaersSystem {
    /**
     * Frafaldstallene udskrives på skærmen
     *
     * @param fravaer
     */
    public void udskrivFravaer(int[][] fravaer) {
        for (int row = 0; row < fravaer.length; row++) {
            for (int col = 0; col < fravaer[row].length; col++) {
                System.out.print(fravaer[row][col] + " ");
            }
            System.out.println();

        }

    }

    /**
     * Returnerer det samlede antal fravaerdage over 12 måneder for eleven med
     * elevnr.
     *
     * @param fravaer
     * @param elevNr
     * @return
     */
    public void samletFravaer(int[][] fravaer, int elevNr) {

        for (int row = 0; row < fravaer.length; row++) {
            int sum = 0;
            for (int col = 0; col < fravaer[row].length; col++) {
                sum = sum + fravaer[row][col];
            }
            System.out.println("Elev nummer: " + elevNr++ + " har haft: " + sum + " fraværsdage");
        }
    }

    /**
     * Returnerer det gennemsnitlige antal fraværsdage pr måned for eleven med
     * elevNr.
     *
     * @param fravaer
     * @param elevNr
     * @return
     */
    public void gennemsnit(int[][] fravaer, int elevNr) {
        for (int row = 0; row < fravaer.length; row++) {
            double gnms = 0;
            double sum = 0;
            for (int col = 0; col < fravaer[row].length; col++) {
                if (fravaer.length > 0) {
                    sum = sum + fravaer[row][col];
                    gnms = sum / fravaer[row].length;
                }
            }
            System.out.println("Elev nummer: " + elevNr++ + " har haft: " + gnms + " fraværsdage i gennemsnit");
        }
    }

    /**
     * Returnerer antallet af elever der ikke har haft fravær i de 12 måneder.
     *
     * @param fravaer
     * @return
     */
    public void antalUdenFravaer(int[][] fravaer) {
        int antalEleverUdenFravaer = 0;
        for (int row = 0; row < fravaer.length; row++) {
            int sum = 0;
            for (int col = 0; col < fravaer[row].length; col++) {
                sum = sum + fravaer[row][col];
            }
            if (sum == 0) {
                antalEleverUdenFravaer++;
            }

        }
        System.out.println("Antal elever uden fravær er: " + antalEleverUdenFravaer);
    }

    /**
     * Returnerer elevNr for den elev der har haft mest fravær igennem de 12
     * måneder. Hvis flere elever har haft højst fravær, returneres elevnummer for
     * en af disse.
     *
     * @param fravaer
     * @return
     */
    // elevNr = row + 1
    public int mestFravaer(int[][] fravaer) {
        int elevNr = 0;
        int maxSum = 0;

        for (int row = 0; row < fravaer.length; row++) {
            int sum = 0;
            for (int col = 0; col < fravaer[row].length; col++) {
                sum = sum + fravaer[row][col];
                if (sum > maxSum) {
                    maxSum = sum;
                    elevNr = row + 1;
                }

            }
        }
        return elevNr;
    }

    /**
     * Registrerer at elenven med elevNr ikke har haft fravær i nogen af de 12
     * måneder.
     *
     * @param fravaer
     * @param elevNr
     */
    public void nulstil(int[][] fravaer, int elevNr) {
        elevNr = elevNr - 1;
        for (int col = 0; col < fravaer[elevNr].length; col++) {
            fravaer[elevNr][col] = 0;
        }
    }
}