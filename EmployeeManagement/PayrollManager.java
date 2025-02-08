package day6;

public class PayrollManager {
	public static void generatePayroll(Employee emp) {
		double salary = emp.getBaseSalary();

		double tax = (emp instanceof TaxableInterface) ? ((TaxableInterface) emp).calculateTax(salary+(salary * BonusInterface.BONUS_PERCENTAGE)): 0;
		System.out.println("Payroll for : "+ emp.getEmpName());
		System.out.println("Monthly Salary: "+ salary);
		System.out.println("Tax Deduction: "+ tax);
		System.out.println("Net Salary: "+ emp.getNetSalary());
	}
}