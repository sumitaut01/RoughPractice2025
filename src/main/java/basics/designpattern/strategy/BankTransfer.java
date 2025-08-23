package basics.designpattern.strategy;



public class BankTransfer implements PaymentStrategy {
    @Override
    public void pay(double amount) {

        System.out.println("Paying "+amount +" with Bank Transfer");

    }
}
