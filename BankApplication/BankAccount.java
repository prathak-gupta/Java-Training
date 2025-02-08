package day3_4;

import java.util.Scanner;

public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    protected double balance;
    
    public BankAccount()
    {}
    
    public BankAccount(int accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }
    
    public int getAccNumber()
    {return accountNumber;}
    
    public String accHolderName()
    {
    	return accountHolderName;
    }
    
    public void setAccNumber(int no)
    {
    	accountNumber = no;
    }
    
    public void setAccHolderName(String name)
    {
    	accountHolderName = name;
    }
    
    public void setBalance(double newBal) {
    	if(balance < 0)
    	{
    		System.out.println("Deposite amount can't be less than 0.");
    	}
    	else
    		balance =newBal;
    }

    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount >= 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    
    public void deposit(double...amounts)
    {
    	for(double amount: amounts) {
            if (amount >= 0) {
                balance += amount;
                System.out.println("Parent Class Deposited: " + amount);
            } else {
                System.out.println("Parent Class: Invalid deposit amount.");
            }    		
    	}
    }
    
    public void transfer(double amount, BankAccount targAcc)
    {
    	if(amount < 0)
    	{
    		System.out.println("Transfer amount can't be less than 0.");
    	}
    	else if(amount > balance)
    	{
    		System.out.println("Transfer amount can't be mor than current balance.");
    	}else
    	{
    		balance -= amount;
    		targAcc.deposit(amount);
    		System.out.println("Parent Class: Amount "+amount+", Successfully transfered to Account no. "+ targAcc.getAccNumber()+".");
    	}
    }

    public void withdraw(double amount) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter your pin: ");
    	String pin;
    	pin= sc.nextLine();
    	if(pin.equals("456"))
    	{
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);

        } else if (amount > 0 && balance < amount) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    	}else
    	{
    		System.out.println("You entered a wrong pin, this incident will be reported!\nExiting...");
    	}
//    	sc.close();
    }


   public void displayDetails(){
       System.out.println("Account Number: " +accountNumber);
       System.out.println("Account Holder Name: " +accountHolderName);
       System.out.println("Current Balance : " +balance); 
   }


   
}
