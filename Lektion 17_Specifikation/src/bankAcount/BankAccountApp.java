package bankAcount;

public class BankAccountApp {

    public static void main(String[] args) {
        BankAccount test = new BankAccount(1000);
        BankAccount test2 = new BankAccount(300);
        System.out.println(test.getKontoID());
        test.deposit(250);
        System.out.println(test.getBalance());
        System.out.println();
        System.out.println(test2.getKontoID());

    }

}
