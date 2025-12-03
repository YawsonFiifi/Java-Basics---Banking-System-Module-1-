import Screens.Menu;
import Screens.Prompt;

import Customer.Customer;
import Customer.RegularCustomer;
import Customer.PremiumCustomer;

import java.util.Scanner;

import Account.Account;
import Account.CheckingAccount;
import Account.SavingsAccount;


public class Main{
    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);

        while(true){
            int menuResponse = new Menu(scanner, "BANK ACCOUNT MANAGEMENT - MAIN MENU", new String[]{
                "Create Account", 
                "View Accounts", 
                "Process Transaction",
                "View Transaction Details",
                "Exit"
            }).openScreen();

            switch(menuResponse){
                case 1: {
                    String name = new Prompt(scanner, "ACCOUNT CREATION", "Enter customer name").openScreen();
                    int age = Integer.parseInt(new Prompt(scanner, null, "Enter customer age").openScreen());
                    String contact = new Prompt(scanner, null, "Enter customer contact").openScreen();
                    String address = new Prompt(scanner, null, "Enter customer address").openScreen();

                    int customerType = new Menu(scanner, "Customer Type", new String[]{
                        "Regular Customer",
                        "Premium Customer"
                    }).openScreen();

                    Customer customer;

                    switch(customerType){
                        case 1:{
                            customer = new RegularCustomer(name, age, contact, address);
                            break;
                        }
                        case 2:{
                            customer = new PremiumCustomer(name, age, contact, address);
                            break;
                        }
                        default:{
                            System.out.println("Invalid input\n");
                            continue;
                        }
                    }

                    int accountType = new Menu(scanner, "Account Type", new String[]{
                        "Savings Account",
                        "Checking Account"
                    }).openScreen();

                    double initialDeposite = Double.parseDouble(new Prompt(scanner, null, "Enter initial deposite amount").openScreen());

                    Account account;

                    switch(accountType){
                        case 1:{
                            account = new SavingsAccount(customer, initialDeposite);
                            break;
                        }
                        case 2:{
                            account = new CheckingAccount(customer, initialDeposite);
                            break;
                        }
                        default:{
                            System.out.println("Invalid input\n");
                            continue;
                        }
                    }

                    System.out.printf("""
                        Account Created Successfully

                        Account Number: %d
                        Customer: %s
                        Account Type: %s
                        initial Balance: $%s
                        Status: %s

                        Press Enter to continue...
                        """,
                        Integer.parseInt(account.getAccountNumber()),
                        customer.getName(),
                        account.getAccountType(),
                        account.getBalance(),
                        account.getStatus()
                    );

                    scanner.nextLine();

                    break;
                }
                case 2: {
                    

                    break;
                }
            }
        }
    }
}