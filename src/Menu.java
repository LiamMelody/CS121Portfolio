import java.util.Scanner;
public class Menu {
    Scanner scanner = new Scanner(System.in);
    Bank bank = new Bank();
    public void runMenu() {
        while (true) {
            System.out.println("*********** MENU ********** \nPlease Make A Selection: ");
            System.out.println("1) Access My Accounts \n2) Open a New Account \n" +
                    "3) Close All of My Accounts \n4) Exit");
            int input = Integer.parseInt(scanner.nextLine());
            if (input == 1) {
                accessAccount();
            }
            else if (input == 2) {
                newAccount();
            }
            else if (input == 3) {
                closeAllAccounts();
            }
            else if (input == 4) {
                System.out.println("Thank you for coming to our bank");
                scanner.close();
                break;
            }
            else {
                System.out.println("Invalid Input");
            }
        }
    }
    protected void displayAccountMenu(Account account, Customer customer) {
        while (true) {
            System.out.println("Please Make a Selection: ");
            System.out.println("1) Make a deposit \n2) make a withdrawal " +
                    "\n3) see account balance \n4) Close account \n5) Exit");

            int input = Integer.parseInt(scanner.nextLine());
            if (input == 1) {
                depositMoney(account);
            }
            else if (input == 2) {
                withdrawMoney(account);
            }
            else if (input == 3) {
                seeBalance(account);
            }
            else if (input == 4) {
                closeSpecificAccount(account,customer);
            } else if (input == 5) {
                break;
            } else {
                System.out.println("Invalid Input");
                continue;
            }
        }
    }


    private void accessAccount() {
        System.out.println("Please Enter your Account Pin: ");
        Customer customer = bank.findCustomer(Integer.parseInt(scanner.nextLine()));

        if (customer == null) {
            System.out.println("Invalid PIN");
        }
        else {
            System.out.print(customer + "\n");
            System.out.println(customer.getAccountArrayList());
            System.out.println("Which account would you like to access (please enter account number)");
            String accNum = scanner.nextLine();

            Account account = customer.returnAccount(accNum);
            if (account == null) {
                System.out.println("This is not an account number you have");
            }
            else {
                displayAccountMenu(account, customer);
            }
        }
    }


    private void newAccount() {
        while (true) {
            System.out.println("Are you a new customer? yes/no");
            String newCustomer = scanner.nextLine();
            if (newCustomer.equals("no")) {

                System.out.println("What is your pin?");
                int pin = Integer.parseInt(scanner.nextLine());

                Customer customer = bank.findCustomer(pin);
                if (customer == null) {
                    System.out.println("Invalid PIN");
                }
                else {
                    Account account = customer.addAccount(createNewAccount());
                    System.out.printf("New Account Opened %s\n", account.getAccountNumber());
                }
                break;
            }
            else if (newCustomer.equals("yes")) {
                Customer customer = createNewCustomer();
                double deposit = createNewAccount();

                Account account = customer.addAccount(deposit);

                System.out.printf("New Account Opened %s\n", account.getAccountNumber());
                break;
            }
            else {
                System.out.println("Invalid Input Please Type Either yes or no");
            }
        }
    }


    private Customer createNewCustomer() {
        System.out.println("What is your First Name?");
        String firstName = scanner.nextLine();
        System.out.println("What is your Last Name?");
        String lastName = scanner.nextLine();
        System.out.println("Please enter your new PIN");
        int pin = Integer.parseInt(scanner.nextLine());
        Customer customer = new Customer(firstName, lastName, pin);
        bank.addCustomer(customer);
        return customer;
    }

    protected double createNewAccount() {
        System.out.println("What would you like to deposit as the starting balance?");
        return Double.parseDouble(scanner.nextLine());

    }

    private void depositMoney(Account account) {
        System.out.println("How much would you like to deposit?");
        account.deposit(Double.parseDouble(scanner.nextLine()));
    }
    private void withdrawMoney(Account account) {
        System.out.println("How much would you like to withdraw?");
        account.withdraw(Double.parseDouble(scanner.nextLine()));
    }
    private void seeBalance(Account account) {
        double balance = account.getBalance();
        System.out.printf("Current Balance: $%f.2 \n", balance);
    }

    // I sense there is a better way to do this, however I am tired
    private void closeSpecificAccount(Account account, Customer customer) {
        String accountNum = account.getAccountNumber();
        customer.removeAccount(account);
        System.out.printf("Account Number %s Has Been Removed\n", accountNum);
    }


    private void closeAllAccounts() {
        System.out.println("What is your pin?");
        int pin = Integer.parseInt(scanner.nextLine());

        if (bank.findCustomer(pin) == null) {
            System.out.println("Invalid PIN");
        }
        else {
            bank.removeCustomer(bank.findCustomer(pin));
            System.out.println("Customer has been removed from registry");
        }
    }
}
