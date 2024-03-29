package Customer;
public class Customer {
    int cutomerId;
    int accountNo;
    String name;
    public int balance;
    String password;

    public Customer(
     int cutomerId ,
     int accountNo ,
     String name,
     int balance,
     String password
     ){
            this.cutomerId = cutomerId;
            this.accountNo = accountNo;
            this.name = name;
            this.balance = balance;
            this.password = password;
     }

     @Override
     public String toString(){
              return cutomerId + " " +
              accountNo + " " +
              name + " " +
              balance + " " +
              password;
     }
     
}