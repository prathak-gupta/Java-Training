package day3_4;

public class SavingBankAccount extends BankAccount{
	private double roi;

	public SavingBankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingBankAccount(int accountNumber, String accountHolderName, double initialBalance, double roi) {
		super(accountNumber, accountHolderName, initialBalance);
		// TODO Auto-generated constructor stub
		this.roi = roi;
	}

	public SavingBankAccount(double roi) {
		super();
		this.roi = roi;
	}

	public double getRoi() {
		return roi;
	}

	public void setRoi(double roi) {
		this.roi = roi;
	}
	
	public double balanceAfterRoi()
	{
		double balance = super.getBalance();
		balance += (balance * roi);
		return balance;
	}
	
	@Override
	public void deposit(double amount) {
		super.deposit(amount);
		System.out.println("Applied Conviniece Charges: "+ -1.25+"\nDon't worry they will be returned");
	}
	
	@Override
	public void displayDetails()
	{
		super.displayDetails();
		System.out.println("ROI: "+roi);
	}
	
	@Override
    public void deposit(double...amounts)
    {
		double balance = super.getBalance();
    	for(double amount: amounts) {
            if (amount >= 0) {
                balance += amount;
                System.out.println("Child Class Deposited: " + amount);
            } else {
                System.out.println("Child Class: Invalid deposit amount.");
            }    		
    	}
    	balance += (balance*roi);
    	super.deposit(balance);
    	System.out.println("Updated Balance: "+balance);
    }

	
    public void transfer(double amount, SavingBankAccount targAcc)
    {
    	double balance = super.getBalance();
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
    		super.setBalance(balance);
    		targAcc.deposit(amount);
    		System.out.println("Child Class: Amount "+amount+", Successfully transfered to Account no. "+ targAcc.getAccNumber()+".");
    		
    	}
    }

	
	public static void main(String args[])
	{
		BankAccount s1 = new SavingBankAccount(1232, "Prathak", 5000, 0.07);
		BankAccount b2  = new SavingBankAccount(3123, "Paritosh",5500, 0.07);
		SavingBankAccount b3 = new SavingBankAccount(2342,"Rahul", 6000,0.07);
//		s1.displayDetails();
		((SavingBankAccount) s1).setRoi(0.07);
//		System.out.println("Balance after ROI: "+ ((SavingBankAccount) s1).balanceAfterRoi());
//		s1.deposit(1000,23,423,4234,45,0,-234);
//		s1.transfer(500, b2);
//		((BankAccount) s1).deposit(123,456,787,-132,-342);
		b2.displayDetails();
		b2.transfer(1500, b3);
		b2.displayDetails();
	}
}
