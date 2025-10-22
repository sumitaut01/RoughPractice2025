package oopsbank;

import java.io.Serializable;

public abstract class Account implements Transactionable,Serializable {

    private double balance;
    int accountNumber; // Made final since it shouldn't change after creation

    public Account(int accountNumber, double bal) {
        this.balance = bal;
        this.accountNumber = accountNumber;
    }
    //serialzation fails if no argument cosntructor
    // 🏆 Add this public or protected no-argument constructor
    public Account() {

    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    // Abstract methods should be public to define the public interface
    public abstract void depositMoney(double money);

    public abstract void withdrawMoney(double money);

    // Protected method for subclasses to modify balance in a controlled way
    protected void adjustBalance(double amount) {
        this.balance += amount;
    }
}


//1. S - Single Responsibility Principle (SRP)
//SRP states that a class should have only one reason to change.
//Adherence:
//
//The Account class's sole responsibility is managing the core state of a bank account (balance, account number) and defining the fundamental financial operations (depositMoney, withdrawMoney).
//The SavingsAccount class's sole responsibility is managing the specific behavior of a Savings Account, which is enforcing the minBal rule during withdrawals.



//2. O - Open/Closed Principle (OCP)
//OCP states that software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.
//
//Adherence:
//
//The Account abstract class is closed for modification (you shouldn't need to change its core logic).
//
//It is open for extension because you can create new account types (like CheckingAccount or CDAccount) by simply extending Account and overriding the abstract methods without altering the existing code in Account or SavingsAccount.