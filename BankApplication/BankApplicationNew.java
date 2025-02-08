package day3_4;
import java.util.InputMismatchException;
import java.util.Scanner;


public class BankApplicationNew {
	
	private static BankAccount [] bankAccounts;
	private static int totalAccounts =0;
	private static int maxAccounts =5;
	
	public BankApplicationNew() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		bankAccounts = new BankAccount[maxAccounts];
		
		while(true)
		{
			System.out.println("Bank Application New");
			System.out.println("Press 1: To create new Bank Account");
			System.out.println("Press 2: Display all accounts");
			System.out.println("Press 3: Deposite Money");
			System.out.println("Press 4: Buy Stock");
			System.out.println("Press 5: Sell Stock");
			System.out.println("Press 6: Withdraw Money");
			System.out.println("Press 7: Transfer Money");
			System.out.println("Press 8: Exit");
			System.out.print("Choose your option: ");
			int choice=0;
			try {
			choice = scanner.nextInt();
			}catch(InputMismatchException e)
			{
				System.out.println("InputMisMatchException: Input can be in numeric form: "+e.getMessage());
				main(null);
			}
			switch(choice)
			{
			
			case 1:
				createAccount(scanner);
			break;
			
			case 2:
				displayAccounts(scanner);
			break;
			
			case 3:
				dipositMoney(scanner);
			break;
			
			
			case 4:
				buyStocks(scanner);
				break;
			
			case 5:
				sellStocks(scanner);
			break;
				
			case 6:
				withdrawMoney(scanner);
			break;
			
			case 7:
				transferMoney(scanner);
			break;

			case 8:
				System.out.println("Thank you :)");
				scanner.close();
				return;
			default:
				System.out.println("Choose valid Inputs!");
			}
			System.out.println();
		}
	}

	private static void sellStocks(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("Enter account number: ");
		int accn = scanner.nextInt();
		BankAccount ba = findBankAccount(accn);
		if(ba != null)
		{
			if(((DematAccount) ba).isDematAccount())
			{
				System.out.print("Enter quantity of Stocks: ");
				int qty = scanner.nextInt();
				System.out.print("Enter the price you want to sell: ");
				double amount = scanner.nextDouble();
				((DematAccount) ba).sellStock(qty, amount);				
			}else
			{
				System.out.println("This is not a Demat Account!");
				return;
			}
		}
		System.out.println("Demat Account not found!");		
	}

	private static void buyStocks(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("Enter account number: ");
		int accn = scanner.nextInt();
		BankAccount ba = findBankAccount(accn);
		if(ba != null)
		{
			if(((DematAccount) ba).isDematAccount())
			{				
				System.out.print("Enter quantity of Stocks: ");
				int qty = scanner.nextInt();
				((DematAccount) ba).buyStock(qty);
			}
			else
			{
				System.out.println("This is not a Demat Account!");
				return;
			}
		}
		System.out.println("Demat Account not found!");
	}

	private static void transferMoney(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("Enter source account number: ");
		int src_accn = scanner.nextInt();
		System.out.print("Enter destination account number: ");
		int dst_accn = scanner.nextInt();
		System.out.print("Enter deposit amount: ");
		double amt = scanner.nextDouble();
		BankAccount src_acc = findBankAccount(src_accn);
		BankAccount dst_acc = findBankAccount(dst_accn);
		if(src_acc != null)
		{
			System.out.println("Source Account Found!");
		}
		if(dst_acc != null)
		{
			System.out.println("Destination Account Found!");
		}
		if(src_acc != null && dst_acc != null) {
			src_acc.transfer(amt, dst_acc);
		}else
		{
			System.out.println("Transfer: Bank Account not Found!");
		}
			
	}

	private static void withdrawMoney(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("Enter account number: ");
		int accn = scanner.nextInt();
		System.out.print("Enter Withdraw amount: ");
		double amt = scanner.nextDouble();
		BankAccount bnkacc = findBankAccount(accn);
		
		if(bnkacc != null) {
			bnkacc.withdraw(amt);
		}else
		{
			System.out.println("Withdraw: Bank Account not Found!");
		}
				
	}

	private static void dipositMoney(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("Enter account number: ");
		int accn = scanner.nextInt();
		System.out.print("Enter deposit amount: ");
		double amt = scanner.nextDouble();
		
		BankAccount bnkacc = findBankAccount(accn);
		
		if(bnkacc != null) {
			bnkacc.deposit(amt);
		}else
		{
			System.out.println("Deposit: Bank Account not Found!");
		}
		System.out.println("Do you want to deposit again? (yes/no)");
		String res = scanner.next();
		if(res.equalsIgnoreCase("yes"))
		{
			dipositMoney(scanner);
		}else
		{
			System.out.println("Thank you for Dipositing money..");
		}
		
	}

	private static BankAccount findBankAccount(int accn) {
		// TODO Auto-generated method stub
		for(int i=0; i<totalAccounts; i++)
		{
			if(bankAccounts[i].getAccNumber() == accn)
				return bankAccounts[i];
		}
		return null;
	}

	private static void displayAccounts(Scanner scanner) {
		// TODO Auto-generated method stub
		if(totalAccounts == 0)
		{
			System.out.println("No Account to display!");
			return;
		}
		for(int i=0; i<totalAccounts; i++)
		{
			System.out.println("Bank Account Details \n----------------------------------");
			bankAccounts[i].displayDetails();
			System.out.println("----- x -------x -------- x ------- ");
			System.out.println();
		}
		
	}

	private static void createAccount(Scanner scanner) {
		// TODO Auto-generated method stub
		if(totalAccounts >= maxAccounts)
		{
			System.out.println("Account Limit Reached, Can't create more accounts!");
			return;
		}
		
		System.out.print("Enter Account holder name: ");
		String accHolder = scanner.next();
		System.out.print("Enter Account number: ");
		int accNo =  scanner.nextInt();
		System.out.print("Enter initial amount: ");
		double initBalance = scanner.nextDouble();
		System.out.print("Which Account type you want to create:\n1.Savings\n2.Current\n3.Demat\n4.Premium Savings Account?\nYour Choice:");
		int ch= scanner.nextInt();
		
		switch(ch)
		{
		case 1:
			System.out.print("Enter Rate of Interest: ");
			double roi = scanner.nextDouble();
			bankAccounts[totalAccounts] = new SavingBankAccount(accNo, accHolder, initBalance, roi);
			totalAccounts++;
			break;
		case 2:
			bankAccounts[totalAccounts] = new BankAccount(accNo, accHolder, initBalance);
			totalAccounts++;
			break;
		case 3:
			bankAccounts[totalAccounts] = new DematAccount(accNo, accHolder,initBalance);
			totalAccounts++;
			break;
		case 4:
			bankAccounts[totalAccounts] = new PremiumSavingBankAccount(accNo, accHolder,initBalance, 0.07,0.11);
			totalAccounts++;
			break;
		default:
			System.out.println("Try Again, enter a valid input!");
		}
		
	}

}
