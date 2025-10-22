package oopsbank;

import java.io.Serializable;

public class SavingsAccount extends Account implements Serializable {

    private double minBal;

    public SavingsAccount(int accountNumber, double bal, double minBal) {
        super(accountNumber, bal);
        this.minBal = minBal;
    }

    public double getMinBal() {
        return minBal;
    }

    // Must be public to match the abstract method in Account
    @Override
    public void depositMoney(double money) {
        if (money <= 0) {
            System.out.println("Enter valid amount. " + money + " is not a valid amount");
            return; // Crucial: Stop processing an invalid deposit
        }
        adjustBalance(money);
    }

    // Must be public to match the abstract method in Account
    @Override
    public void withdrawMoney(double money) {
        if (money <= 0) {
            System.out.println("Enter valid withdrawal amount. " + money + " is not a valid amount");
            return;
        }

        // ✅ CORRECT LOGIC: Check if the remaining balance is less than the minimum required
        if (getBalance() - money < minBal) {
            System.out.println("Withdrawal failed. Account must maintain a minimum balance of $" + minBal);
            return; // Stop the transaction if the check fails
        }

        // Only adjust balance if the withdrawal is valid
        adjustBalance(-money);
    }
}