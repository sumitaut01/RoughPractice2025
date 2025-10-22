package oopsbank;

/**
 * Defines the core contract for any financial entity that can handle 
 * deposits and withdrawals, promoting polymorphism and decoupling.
 */
public interface Transactionable {

    /**
     * Adds funds to the financial entity's balance.
     * * @param money The amount to deposit.
     */
    void depositMoney(double money);

    /**
     * Removes funds from the financial entity's balance, subject to any
     * specific rules (like minimum balance).
     * * @param money The amount to withdraw.
     */
    void withdrawMoney(double money);

    // Optional: You could add other generic transaction methods here, such as:
    // boolean transfer(Transactionable target, double money);
    // boolean checkFunds(double money);
}