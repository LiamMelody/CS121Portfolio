import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private String firstName;
    private String lastName;
    private int pin;

    private ArrayList<Account> accountArrayList = new ArrayList<>();
    HashMap<String, String> partnerHashMap = new HashMap<>();

    public Customer(String firstName, String lastName, int pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
    }
    
    //addAccount simultaneously returns the account object and adds the object
    //to the customer's account arraylist
    public Account addAccount(double initialAmount) {
        Account account = new Account(initialAmount);
        accountArrayList.add(account);
        return account;
    }

    public void removeAccount(Account account) {
        accountArrayList.remove(account);
    }

    public Account returnAccount(String accountNumber) {
        Account foundAccount = null;
        for (Account account : accountArrayList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                foundAccount = account;
                break;
            }
        }
        return foundAccount;
    }

    public StringBuilder getAccountArrayList() {
        StringBuilder accountStringBuilder = new StringBuilder();

        for (Account account : accountArrayList) {
            accountStringBuilder.append(account.toString());
        }
        return accountStringBuilder;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s\n PIN: %d", firstName, lastName, pin);
    }

    // ******************* GETTERS ********************

    public int getPin() {
        return pin;
    }
}
