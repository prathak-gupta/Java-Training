package day3_4;

public class DematAccount extends BankAccount{

	private int stockHoldings;
	static int stockPrice =10, stockQty=100;
	public boolean isDematAcc;
	
	public DematAccount() {
		// TODO Auto-generated constructor stub
		super();
		isDematAcc =true;
	}

	

	/**
	 * @param stockHoldings
	 */
	public DematAccount(int stockHoldings) {
		super();
		this.stockHoldings = stockHoldings;
		isDematAcc =true;
	}

	public boolean isDematAccount()
	{return isDematAcc;}

	/**
	 * @param accountNumber
	 * @param accountHolderName
	 * @param initialBalance
	 */
	public DematAccount(int accountNumber, String accountHolderName, double initialBalance) {
		super(accountNumber, accountHolderName, initialBalance);
		// TODO Auto-generated constructor stub
		isDematAcc =true;
	}

	public void buyStock(int quantity) {
		if(quantity > stockQty)
		{
			System.out.println("Stock quantity exceeded..can't buy stocks!");
			return;
		}
		
		if(quantity*stockPrice > balance)
		{
			System.out.println("Insufficient funds..can't buy stock! Try reducing amount of stocks.");
			return;
		}
		
		stockHoldings=quantity;
		balance -= (quantity*stockPrice);
		System.out.println("Stock bought Successfully..");		
	}
	
	public void sellStock(int qty, double price)
	{
		if(qty > stockHoldings)
		{
			System.out.println("Can't Sell stocks more than holdings..");
			return;
		}
		stockHoldings -= qty;
		balance -= (qty*stockPrice);
		System.out.println("Stock sold Successfully..");
		}
	
	@Override
	public void displayDetails()
	{
		super.displayDetails();
		System.out.println("Stock Holdings: "+stockHoldings);
		System.out.println("Stock Holdings Price: "+stockHoldings*stockPrice);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DematAccount d1 = new DematAccount(123213, "Prathak", 100000);
		d1.buyStock(100);
		d1.displayDetails();
		d1.sellStock(10, 900);
	}

}
