package opgave1dobbelarray;

public class DobbelArrayApp {

    public static void main(String[] args) {
        final int ROW = 8;
        final int COL = 8;
        int[][] values = new int[ROW][COL];

        // TODO udskriv values på tabel form
        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length; col++) {
                System.out.print(values[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("");
        // TODO lav ændringer i values så der står 5 på alle pladser & udskriv values på
        // tabel form
        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length; col++) {
                values[row][col] = 5;
                System.out.print(values[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("");

        // TODO lav ændringer i values så den har skiftende 0'er og 1'er som på et &
        // udskriv values på tabel form
        // skakbræt & udskriv values på tabel form
        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length; col++) {
                if ((col + row) % 2 == 0) {
                    values[row][col] = 0;
                } else {
                    values[row][col] = 1;
                }
                System.out.print(values[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println();

        // TODO lav ændringer så alle elementer i nederste og øverste række samt første
        // og sidste søjle er 5 og resten skal være 2 & udskriv values på tabel form
        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length; col++) {
                if (row == 0 || row == 7 || col == 0 || col == 7) {
                    values[row][col] = 5;
                } else {
                    values[row][col] = 2;
                }

                System.out.print(values[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // TODO beregn summen af alle tallene i values og udskriv denne.
        int sum = 0;
        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length; col++) {
                sum = sum + values[row][col];
            }

        }
        System.out.println(sum);
    }
}
