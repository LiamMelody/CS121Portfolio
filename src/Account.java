public class Account {
    private double balance;
    private String accountNumber;
    private static int numberOfAccounts = 1000;

    public Account(double initialBalance) {
        this.accountNumber = String.valueOf(numberOfAccounts);
        this.balance = initialBalance;
        ++numberOfAccounts;
    }

    public Account() {}

    public void deposit(double deposit) {
        balance += deposit;
    }

    public void withdraw(double withdraw) {
        if (balance < withdraw) {
            System.out.println("Insufficient Funds");
        }
        else {
            balance -= withdraw;
            System.out.printf("Withdrawn: $%f.2\n Balance: $%f.2\n", withdraw, balance);
        }
    }

    // ****************** GETTERS *****************

    public double getBalance() {
        return balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    // toString
    @Override
    public String toString() {
        return String.format("Account Number: %s \nBalance: $%.2f\n\n", accountNumber, balance);
    }
}
