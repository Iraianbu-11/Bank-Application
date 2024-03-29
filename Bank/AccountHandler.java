package Bank;

import Customer.Customer;
import Transaction.Transaction;
import Transaction.TransactionHandler;

public class AccountHandler {
    public void deposit(int customerId, int amount) throws Exception {
        if (amount < 0) {
            System.out.println("Amount should be greater than 0");
            return;
        }
        Customer customer = Bank.customerDetails.get(customerId);
        customer.balance += amount;

        Bank.customerDetails.put(customerId, customer);

        TransactionHandler handler = new TransactionHandler();
        int transactionId = handler.lastTransactionId(customerId);
        Transaction transaction = new Transaction(++transactionId, "Deposit", amount, customer.balance);
        handler.writeTransaction(customerId, transaction);
    }

    public boolean withdraw(int customerId, int amount) throws Exception {

        Customer customer = Bank.customerDetails.get(customerId);
        int balance = customer.balance - amount;
        if (balance >= 1000) {
            customer.balance = balance;
            Bank.customerDetails.put(customerId, customer);
            TransactionHandler handler = new TransactionHandler();
            int transactionId = handler.lastTransactionId(customerId);
            Transaction transaction = new Transaction(++transactionId, "Withdraw", amount, customer.balance);
            handler.writeTransaction(customerId, transaction);
            return true;
        }
        return false;

    }

    public void transfer(int fromCustomerId, int toCustomerId, int amount)
            throws Exception {
        Customer receiver = Bank.customerDetails.get(toCustomerId);
        if (receiver == null) {
            System.out.println("The Receiver is not exist");
            return;
        }
        Customer sender = Bank.customerDetails.get(fromCustomerId);
        boolean isSucess = withdraw(fromCustomerId, amount);

        if (isSucess) {
            deposit(toCustomerId, amount);
            Bank.customerDetails.put(toCustomerId, sender);
            Bank.customerDetails.put(toCustomerId, receiver);
        }

    }
}
