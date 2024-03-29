package Transaction;

public class Transaction {
    public int trasactionId;
    public String type;
    public int amount;
    public int balance;

    public Transaction(
        int trasactionId,
        String type,
        int amount,
        int balance
    ){
        this.trasactionId = trasactionId;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String toString(){
        return trasactionId + " " +
        type + " " +
        amount + " " +
        balance;
    }


}
