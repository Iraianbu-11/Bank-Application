import java.util.Scanner;

import Bank.AccountHandler;
import Customer.CustomerHandler;
import Customer.FileHandler;
import Transaction.TransactionHandler;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static CustomerHandler customerHandler = new CustomerHandler();
    public static  AccountHandler accountHandler = new AccountHandler();
    public static FileHandler fileHandler = new FileHandler();
    public static void main(String[] args) throws Exception {
        fileHandler.initialize();
        printMenu();
   
    }

    public static void printMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
       
        while (exit) {
            System.out.println("\t\t\tWelcome to SBI Bank " + "\nChoose the Available Options" +
                    "\n 1 - Add Customer" +
                    "\n 2 - Deposit" +
                    "\n 3 - Withdraw" +
                    "\n 4 - Fund Transfer" +
                    "\n 5 - Transaction Details" +
                    "\n 6 - Exit");
            int options = scanner.nextInt();
            switch (options) {
                // Add Customer
                case 1 -> customerHandler.addCustomer();

                // Deposit
                case 2 -> deposit();

                // Withdraw
                case 3 -> withdraw();

                // Fund Transfer
                case 4 -> transfer();
                // Exit
                case 5 -> displayTransactions() ;

                // Print Transaction Details
                case 6 ->  exit = false;

                
                default -> System.out.println("Invalid Option");
            }
        }
        scanner.close();
    }
    private static void displayTransactions() throws Exception{
        System.out.println("Enter the Customer ID: ");
        int id = scanner.nextInt();
        System.out.println("Enter the Password: ");
        String pass = scanner.next();
        if (customerHandler.authenticateUser(id, pass)) {
        System.out.println("\t\t\tTransaction History");
        TransactionHandler transactionHandler = new TransactionHandler();
        transactionHandler.printDetails(id);
        }
    }

    private static void transfer() throws Exception{
        System.out.println("Enter the Customer ID: ");
        int id = scanner.nextInt();
        System.out.println("Enter the Password: ");
        String pass = scanner.next();
        if (customerHandler.authenticateUser(id, pass)) {
            System.out.println("Enter the Receiver Customer ID: ");
            int receiver = scanner.nextInt();
            System.out.println("Enter the Amount: ");
            int amount = scanner.nextInt();
            accountHandler.transfer(id, receiver, amount);
            System.out.println("Operation Sucessfull");
            fileHandler.updateDetails();
        }
    }
    

    private static void withdraw() throws Exception{
        System.out.println("Enter the Customer ID: ");
        int id = scanner.nextInt();
        System.out.println("Enter the Password: ");
        String pass = scanner.next();
        if (customerHandler.authenticateUser(id, pass)) {
            System.out.println("Enter the Amount: ");
            int amount = scanner.nextInt();
            accountHandler.withdraw(id, amount);
            System.out.println("Operation Sucessfull");
            fileHandler.updateDetails();
        }
    }
    

    public static void deposit() throws Exception {
        System.out.println("Enter the Customer ID: ");
        int id = scanner.nextInt();
        System.out.println("Enter the Password: ");
        String pass = scanner.next();
        if (customerHandler.authenticateUser(id, pass)) {
            System.out.println("Enter the Amount: ");
            int amount = scanner.nextInt();
            accountHandler.deposit(id, amount);
            System.out.println("Operation Sucessfull");
            fileHandler.updateDetails();
        }
    }
}
