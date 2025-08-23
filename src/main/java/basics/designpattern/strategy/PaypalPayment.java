package basics.designpattern.strategy;




public class PaypalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying "+amount +" with Paypal Payment ");
    }
}
