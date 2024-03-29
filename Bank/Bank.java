package Bank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Customer.Customer;
public class Bank{
    public static List<Customer> customers = new ArrayList<Customer>();
    public static Map<Integer,Customer> customerDetails = new HashMap<>();
    public static int refCustomerId;
    public static int refAccountNo;
    public static int position;
    public static final int INITIAL_BALANCE = 10000;
}
