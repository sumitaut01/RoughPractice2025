package oopsbank.rough;

public abstract class Account {

    int accountNumber;
    double accountBalance;

    public Account(int accountNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public double getAccountBalance() {
        return accountBalance;
    }

    protected void adjustBalance(double amount){
        accountBalance=accountBalance+amount;
    }


    //absctract method

    public abstract void withdraw(double money);

}


 class SavigngsAccount extends  Account{

    int MIN_BAL=500;


     public SavigngsAccount(int accountNumber, double accountBalance) {
         super(accountNumber, accountBalance);
     }

     @Override
     public void withdraw(double money) {
         if(getAccountBalance()-money< MIN_BAL) {
             throw new RuntimeException("Balance of 500 is required. Aborting thetransaction");
         }
         else if (money <= 0)
         {
             throw new RuntimeException("Withdrawal amount should be more than 0");
         }

         else
         {
             accountBalance=getAccountBalance()-money;
         }
     }
 }


class CheckinsAccount extends  Account{

    public CheckinsAccount(int accountNumber, double accountBalance) {
        super(accountNumber, accountBalance);
    }

    @Override
    public void withdraw(double money) {
            if (money <= 0)
            {
                throw new RuntimeException("Withdrawal amount should be more than 0");
            }

            else
            {
                accountBalance=getAccountBalance()-money;
            }
        }
}


