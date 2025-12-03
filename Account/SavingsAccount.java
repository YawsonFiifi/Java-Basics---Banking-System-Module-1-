package Account;

import Customer.Customer;


public class SavingsAccount extends Account{
    private double interestRate;
    private double minimumBalance;

    public SavingsAccount(Customer customer, double initialDeposite){
        if(initialDeposite < 500){
            throw new Error("Initial Deposite is too low");
        }

        this.interestRate = 3.5;
        this.minimumBalance = 500;

        super(customer, initialDeposite);
    }

    
    public void displayAccountDetails(){
        System.out.println();
    }
    
    public String getAccountType(){
        return "Savings";
    }
    
    public double withdraw(){
        return getBalance();
    } 

    public double calculateInterest(){
        return interestRate * getBalance();
    }
}
