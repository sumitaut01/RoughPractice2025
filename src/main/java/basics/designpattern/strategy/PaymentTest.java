package basics.designpattern.strategy;

public class PaymentTest {

    public static void main(String[] args) {

    PaymentContext paymentContext=new PaymentContext();
       PaymentStrategy paymentStrategy= new BankTransfer();
    paymentContext.setPaymentStrategy(paymentStrategy);
        paymentStrategy.pay(12);//Paying 12.0 with Bank Transfer


         paymentStrategy= new CreditCardPayment();
         paymentStrategy.pay(12);//Paying 12.0 with CreditCard
    }
}
