package day3_4;

public class PremiumSavingBankAccount extends SavingBankAccount{
	private double premiumBonus;
	
	public PremiumSavingBankAccount() {
		// TODO Auto-generated constructor stub
		premiumBonus = 0.1;
	}

	public double getPremiumBonus() {
		return premiumBonus;
	}

	public void setPremiumBonus(double premiumBonus) {
		this.premiumBonus = premiumBonus;
	}

	public PremiumSavingBankAccount(double premiumBonus) {
		this.premiumBonus = premiumBonus;
	}
	
	public PremiumSavingBankAccount(int accountNumber, String accountHolderName, double initialBalance, double roi, double premiumBonus) {
		super(accountNumber, accountHolderName, initialBalance, roi);
		this.premiumBonus = premiumBonus;
		}
	
	@Override
	public void deposit(double amount)
	{
		double bal =super.getBalance();
		bal += (bal*premiumBonus);
		super.deposit(bal);
		System.out.println("Your balance is deposited with premium bonus "+bal);
	}
	
	@Override
	public void displayDetails()
	{
		super.displayDetails();
		System.out.println("Premium Bonus: "+premiumBonus);
	}
}
