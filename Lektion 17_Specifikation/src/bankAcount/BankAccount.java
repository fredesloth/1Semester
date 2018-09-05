package bankAcount;

/**
 * Modellere en bankkonto
 */

public class BankAccount {
    private double balance;
    private static int kontoID = 0;
    private int denneKontoID;

    /**
     * Opretter en bankkonto med et startbeløb Pre: Skal være et tal
     *
     * @param initialBalance
     */
    public BankAccount(double initialBalance) {
        balance = initialBalance;
        kontoID++;
        denneKontoID = kontoID;
    }

    /**
     * Indsætter et beløb på bankkonto Pre: amount > 0
     *
     * @param amount
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Trækker et beløb fra bankkonto Pre: amount > 0
     *
     * @param amount
     */

    public void withdraw(double amount) {
        balance -= amount;
    }

    /**
     * Får balancen som der er på bankkonto
     *
     * @return beløb på konto
     */
    public double getBalance() {
        return balance;
    }

    public int getKontoID() {
        return denneKontoID;
    }

}
