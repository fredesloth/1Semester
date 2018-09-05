package example;

public class BankAccount extends Object implements Measurable, 
            Comparable<BankAccount> {
    private double balance;
    
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) {
        balance -= amount;
    }
    
    public double getBalance() {
        return balance;
    }
    
    @Override
    public String toString() {
        return balance + "";
    }
    
    public double getMeasure() {
        return balance;
    }

    @Override
    public int compareTo(BankAccount o) {
        return (int)(this.getBalance() - o.getBalance());
    }

}
