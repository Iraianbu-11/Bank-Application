package Customer;
import java.util.Scanner;

import Bank.Bank;
import Transaction.Transaction;
import Transaction.TransactionHandler;

public class CustomerHandler {
    public void addCustomer() throws Exception{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Customer Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter the Password: ");
        String pass = scanner.nextLine();

        System.out.println("Re-enter the Password: ");
        String repass = scanner.nextLine();

        if(!pass.equals(repass)){
            System.out.println("Add Customer Failed : Mismatch Password");
        }
        else if(!isValidPassword(pass)){
            System.out.println("Invalid Password");
        }
        else{
            pass = encryptedPassword(pass);
            System.out.println("Customer Added Successfully!!!");
        }
        //scanner.close();
        Bank.refAccountNo++;
        Bank.refCustomerId++;
        Bank.position++;

        Customer customer = new Customer(Bank.refCustomerId
            , Bank.refAccountNo
            , name
            , Bank.INITIAL_BALANCE
            , pass);

        Bank.customers.add(customer);
        FileHandler.getInstance().addCustomertoFile(customer);
        logTransaction(Bank.refCustomerId);
    }

    public void logTransaction(int id) throws Exception{
        Transaction transaction = new Transaction(
            1
            , "Opening", 
            Bank.INITIAL_BALANCE,
            Bank.INITIAL_BALANCE
            );
        TransactionHandler transactionHandler = new TransactionHandler();
        transactionHandler.writeTransaction(id, transaction);
    }

    public boolean isValidPassword(String password){
        for(int i=0;i<password.length();i++){
            char ch = password.charAt(i);
            if((ch>=97 && ch<=122) || (ch>=65 && ch<=90 ) || ( ch>=48 && ch<=57)){
                return true;
            }
        }
    return false;
    }

    public String encryptedPassword(String password){
        char[] pass = password.toCharArray();
        for(int i=0;i<pass.length ; i++){
            switch (pass[i]) {
                case 'z' -> pass[i] = 'a'; 
                case 'Z' -> pass[i] = 'A';
                case '9' -> pass[i] = '0';
                default  -> pass[i] = (char)(pass[i] + 1);
            }
        }        
        return new String(pass);
    }

    public boolean authenticateUser(int id , String password){
        String encryptedPass = encryptedPassword(password);
        //System.out.println(encryptedPass);
        Customer customer = Bank.customerDetails.get(id);

        if(customer == null){
            System.out.println("Customer Not Found");
            return false;
        }

        if(encryptedPass.equals(customer.password)){
            System.out.println("User Login Successfull");
            return true;
        }
        else{
            //System.out.println("Invalid Password");
            return false;
        }
        

    }
}
