package Account;
import Customer.Customer;


abstract public class Account {
    static int accountCounter = 0;
    
    private String accountNumber;
    private String status = "Active";
    private Customer customer;
    private double balance = 0;
    
    abstract public void displayAccountDetails();
    abstract public String getAccountType();

    Account(Customer customer, double initialDeposite){
        accountCounter++;
        
        this.accountNumber = Integer.toString(accountCounter);
        this.customer = customer;
        this.balance = initialDeposite;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        if(status != "active" || status != "inactive") return;

        this.status = status;
    }

    public double getBalance(){
        return  balance;
    }

    public void setBalance(double amount){
        balance = amount;
    }

    public void deposite(double amount) {
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
}
