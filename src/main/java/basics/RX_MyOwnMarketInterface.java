package basics;

public class RX_MyOwnMarketInterface {
    public static void log(Object obj) {
        if (obj instanceof Auditable) {
            System.out.println("Audit log: " + obj.getClass().getSimpleName()); //Audit log: Order
        } else {
            System.out.println("Skipping audit for: " + obj.getClass().getSimpleName()); //Skipping audit for: Customer
        }
    }

    public static void main(String[] args) {
        log(new Order());
        log(new Customer());
    }

}

// Step 1: Define empty interface
interface Auditable { }

// Step 2: Implement it in some classes
class Order implements Auditable {
    int orderId;
    double amount;
}

class Customer { // Not auditable
    String name;
}

