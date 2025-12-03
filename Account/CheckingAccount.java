package Account;

import Customer.Customer;


public class CheckingAccount extends Account {
    private double overdraftLimite;
    private double monthlyFees;

    public CheckingAccount(Customer customer, double initialDeposite){
        overdraftLimite = 1000;
        monthlyFees = 10;

        super(customer, initialDeposite);
    }

    public void displayAccountDetails(){

    }

    public String getAccountType(){
        return "Checking";
    }

    public void withdraw(double amount){
        if(amount - getBalance() > overdraftLimite) return;

        setBalance(getBalance() - amount);
    }

    public void applyMonthlyFee(){
        setBalance(getBalance() - monthlyFees);
    }

    public double getOverdraftLimit(){
        return overdraftLimite;
    }
}
