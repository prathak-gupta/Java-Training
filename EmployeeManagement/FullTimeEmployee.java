package day6;

public class FullTimeEmployee extends Employee implements TaxableInterface, WorkHoursInterface{
	
	private double bonus;
	
	public FullTimeEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FullTimeEmployee(String empName, String empDept, int adhaar, double baseSalary, int leaveBalance, double bonus) {
		super(empName, empDept, adhaar, baseSalary, leaveBalance);
		// TODO Auto-generated constructor stub
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
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
		return (salary * TaxableInterface.taxRate);
	}

	@Override
	double calculateSalary() {
		// TODO Auto-generated method stub
		netSalary = baseSalary;
		netSalary += bonus;
		netSalary -= calculateTax(netSalary);
		System.out.println("Trace - calculateSalary() bonus: "+bonus);
		return netSalary;
	}

	@Override
	public String getEmpType() {
		// TODO Auto-generated method stub
		return "Full Time";
	}

	@Override
	String provideBenefits() {
		// TODO Auto-generated method stub
		return("Health Insurance, Provident Fund");
	}


}
