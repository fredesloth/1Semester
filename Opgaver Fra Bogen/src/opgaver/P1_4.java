package opgaver;

public class P1_4 {

    public static void main(String[] args) {

        double balance = 1000;
        double percentInterestPerYear = 0.05;

        for (int year = 1; year <= 3; year++) {
            balance = balance + balance * percentInterestPerYear;
            System.out.printf("Year balance for %d year is %.2f \n", year, balance);
        }

    }
}
