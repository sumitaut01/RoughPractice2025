package oopsbank;

public class CurrentAccount extends Account{
    public CurrentAccount(int accountNumber,double bal) {
        super(accountNumber,bal);
    }

    @Override
    public void depositMoney(double money) {
        if(money<=0){
            System.out.println("Enter valid amount. "+ money +" is not a valid amount");
        }
        adjustBalance(money);
    }


    @Override
    public void withdrawMoney(double money) {
        if(money<=0){
            System.out.println("Enter valid withdrawal amount. "+ money +" is not a valid amount");
            return;
        }
        adjustBalance(-money);
    }
}
