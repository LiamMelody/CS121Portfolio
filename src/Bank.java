import java.util.ArrayList;
public class Bank {
    private ArrayList<Customer> customerArrayList = new ArrayList<>();
    public void addCustomer(Customer customer) {
        customerArrayList.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customerArrayList.remove(customer);
    }

    public Customer findCustomer(int pin) {
        Customer foundCustomer = null;
        for (Customer customer : customerArrayList) {
            if (customer.getPin() == pin) {
                foundCustomer = customer;
            }
        }
        return foundCustomer;
    }

}
