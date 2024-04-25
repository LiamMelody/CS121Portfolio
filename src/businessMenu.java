import java.util.HashMap;
public class businessMenu extends Menu{

    private void addPartners(HashMap<String, String> partnerHashMap) {
        while (true) {
            System.out.println("What is this partner's Name?");
            String partnerName = scanner.nextLine();
            System.out.println("What is there role in this business?");
            String partnerRole = scanner.nextLine();
            partnerHashMap.put(partnerRole, partnerName);

            System.out.println("Would you like to add another partner? yes or no");
            String choice = scanner.nextLine();

            if (choice.equals("yes")) {
            } else {
                break;
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

    protected Customer createNewCustomer() {
        System.out.println("What is the business Name");
        String firstName = scanner.nextLine();
        System.out.println("What is the business type (i.e. LLC)");
        String lastName = scanner.nextLine();
        System.out.println("Please enter your new PIN");
        int pin = Integer.parseInt(scanner.nextLine());
        Customer customer = new Customer(firstName, lastName, pin);

        System.out.println("You must add at least one partner...");
        addPartners(customer.partnerHashMap);

        bank.addCustomer(customer);
        return customer;
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
                System.out.println("This account has the following partners: ");
                System.out.println(customer.partnerHashMap);
                displayAccountMenu(account, customer);
            }
        }
    }


}
