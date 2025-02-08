package day6;

public class ManagerEmployee extends Employee implements TaxableInterface, BonusInterface, WorkHoursInterface{
	
	
	
	public ManagerEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManagerEmployee(String empName, String empDept, int adhaar, double baseSalary, int leaveBalance) {
		super(empName, empDept, adhaar, baseSalary, leaveBalance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return empName;
	}

	@Override
	public int getWorkHours() {
		// TODO Auto-generated method stub
		return WorkHoursInterface.STANDARD_WORK_HOURS;
	}

	@Override
	public double calculateTax(double salary) {
		// TODO Auto-generated method stub
//		System.out.println("TAX: "+(baseSalary * TaxableInterface.taxRate));
		return (salary * TaxableInterface.taxRate);
		
	}

	@Override
	double calculateSalary() {
		// TODO Auto-generated method stub
		netSalary = baseSalary;
		netSalary += calcSalaryAfterBonus();
		netSalary -=  calculateTax(netSalary);
//		System.out.println("Trace - final Salary: "+netSalary);
		return netSalary;
	}

	@Override
	public String getEmpType() {
		// TODO Auto-generated method stub
		return "Manager Full Time";
	}

	@Override
	String provideBenefits() {
		// TODO Auto-generated method stub
		return ("Health Insurance, Provident Fund");
	}

	@Override
	public double calcSalaryAfterBonus() {
		// TODO Auto-generated method stub
		return (baseSalary * (BonusInterface.BONUS_PERCENTAGE));
		}

}
