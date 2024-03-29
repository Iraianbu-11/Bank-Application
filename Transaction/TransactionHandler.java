package Transaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class TransactionHandler {
    
    public void writeTransaction(int customerId , Transaction transaction)throws Exception{
        String fileName = customerId+".txt";

        File file = new File(fileName);
        Boolean isnewFile = false;
        if(!file.exists()){
            file.createNewFile();
            isnewFile = true;
        }
        FileWriter fileWriter = new FileWriter(file,true);
        if(!isnewFile){
            fileWriter.write("\n");
        }
       
        fileWriter.write(transaction.toString());
        fileWriter.close();
    }

    public int lastTransactionId(int customerId ) throws Exception{
        String fileName = customerId+".txt";

        File file = new File(fileName);

        if(!file.exists()){
            return 0;
        }

        Scanner scanner = new Scanner(file);
        String res = "";
        while(scanner.hasNext()){
            res = scanner.nextLine();
        }
        scanner.close();
        Transaction transaction = returnDetails(res);
        return transaction.trasactionId;
        
    }

    public Transaction returnDetails(String trans){
        System.out.println(trans);
        String[] details = trans.split(" ");
       // System.out.println(Arrays.toString(details));
        return new Transaction(
            Integer.parseInt(details[0]),
            details[1], 
            Integer.parseInt(details[2]),
            Integer.parseInt(details[3]));
    }

    public void printDetails(int id) throws Exception{
        String fileName = id+".txt";
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(
            new FileReader(file)
        );

        String details = "";
        while((details = br.readLine())!=null){
            System.out.println(details);
        }
    }

}
