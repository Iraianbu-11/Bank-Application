package Customer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Set;

import Bank.Bank;

import java.util.Iterator;

public class FileHandler {
    private static final String filename = "bank_db.txt";
    static FileHandler handler;

    public static FileHandler getInstance(){
        if(handler == null){
            handler = new FileHandler();
        }
    return handler;
    }

    public void initialize() throws Exception{
        File file = new File(filename);
        BufferedReader br = new BufferedReader(
            new FileReader(file)
        );

        String customerInfo;
        while((customerInfo = br.readLine())!=null){
            if(!customerInfo.trim().isEmpty()) {
                Customer customer = addCustomer(customerInfo);
                Bank.customerDetails.put(customer.cutomerId, customer);
                Bank.customers.add(addCustomer(customerInfo));

            }
            //System.out.println(customerInfo);
        }
    
    Bank.refAccountNo = Bank.customers.get(Bank.customers.size()-1).accountNo;
    Bank.refCustomerId = Bank.customers.get(Bank.customers.size()-1).cutomerId;
    Bank.position = Bank.customers.size()-1;
    br.close();
    }

    public Customer addCustomer(String customer){
        String[] info = customer.split(" ");
        return new Customer(Integer.parseInt(info[0])
        , Integer.parseInt(info[1])
        , info[2]
        , Integer.parseInt(info[3])
        , info[4]);
    }

    public void addCustomertoFile(Customer customer) throws Exception{
        File file = new File(filename);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file,true);
            writer.write(customer.toString() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(writer!=null){
                try {
                    writer.close();
                } catch (Exception e) {
                   e.printStackTrace();
                }
            }
        }
    }

    public void updateDetails(){
        File file = new File(filename);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            Set<Integer> keySet = Bank.customerDetails.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                int id = (int)iterator.next();
                Customer customer = Bank.customerDetails.get(id);
                writer.write(customer.toString() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(writer!=null){
                try {
                    writer.close();
                } catch (Exception e) {
                   e.printStackTrace();
                }
            }
        }
    }
}
