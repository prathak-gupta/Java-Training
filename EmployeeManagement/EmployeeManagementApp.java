package day6;

import java.util.Scanner;

import day3_4.BankAccount;

public class EmployeeManagementApp{
	private static Employee[] emp;
	private static int maxEmployees=5;
	private static int empCount =0;

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		emp= new Employee[maxEmployees];
		
		while(true)
		{
			System.out.println("Employee Management Application");
			System.out.println("Press 1: To create new Employee Details");
			System.out.println("Press 2: Display all Employees");
			System.out.println("Press 3: Payroll Info");
			System.out.println("Press 4: Request Leaves");
			System.out.println("Press 5: Exit");
			System.out.print("Choose your option: ");			
			int choice = scanner.nextInt();
			switch(choice)
			{
			
			case 1:
				createEmployee(scanner);
			break;
			
			case 2:
				displayEmployees(scanner);
			break;
			
			case 3:
				displayPayroll(scanner);
			break;
			
			
			case 4:
				requestLeaves(scanner);
			break;
			
			case 5:
				System.out.println("Thank you :)");
				scanner.close();
				return;
			default:
				System.out.println("Choose valid Inputs!");
			}
			System.out.println();
		}
	}
	
	public static Employee findEmployee(int adh)
	{
		for(Employee e: emp)
		{
			if(e.getAdhaar() == adh) {
				return e;
			}
		}
		return null;
	}

	private static void requestLeaves(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("Enter Employee Adhaar no.: ");
		int adh = scanner.nextInt();
		
		Employee emp = findEmployee(adh);
		if(emp != null)
		{
			System.out.println("Enter the no. of leave you want: ");
			int l = scanner.nextInt();
			emp.requestLeave(l);
		}else
		{
			System.out.println("Sorry, Employee not found!");
		}
		}

	private static void displayPayroll(Scanner scanner) {
		// TODO Auto-generated method stub
		for(int i=0; i < empCount; i++)
		{
			PayrollManager.generatePayroll(emp[i]);
		}
		
	}
	
	

	private static void displayEmployees(Scanner scanner) {
		// TODO Auto-generated method stub
		for(int i=0; i < empCount; i++)
		{
			emp[i].displayInfo();
		}
		
	}

	private static void createEmployee(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("Enter Eemployee name: ");
		String empnm = scanner.next();
		System.out.println("Enter Employee Department: ");
		String dept = scanner.next();
		System.out.println("Enter Employee Adhaar no.: ");
		int adh = scanner.nextInt();
		System.out.println("Enter Employee Base Salary");
		double sal = scanner.nextDouble();
		System.out.println("Enter Employee Leave Banlance: ");
		int lb = scanner.nextInt();
		System.out.println("Enter Emplyee type:\n1. Full Time\n2. Part Time\n3. Intern\n4. Manager\nEneter your choice: ");
		int ch = scanner.nextInt();
		double empbonus;
		int whr;
		switch(ch)
		{
		case 1:
			System.out.println("Enter bonus amount for full time employee: ");
			empbonus = scanner.nextDouble();
			System.out.println("Trace - Switch block bonus: "+ empbonus);
			emp[empCount] = new FullTimeEmployee(empnm, dept, adh, sal, lb, empbonus);
			empCount++;
			break;
		
		case 2:
			System.out.println("Enter work hours for part time employee: ");
			whr = scanner.nextInt();
			emp[empCount] = new PartTimeEmployee(empnm, dept, adh, sal, lb, whr);
			empCount++;
			break;
			
		case 3:
			emp[empCount] = new InternEmployee(empnm, dept, adh, sal, 2);
			empCount++;
			break;
			
		case 4:
			emp[empCount] = new ManagerEmployee(empnm, dept, adh, sal, lb);
			empCount++;
			break;
		default:
			System.out.println("Invalid Input, Try again!");
	}

	}

}
