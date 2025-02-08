package day6;

public class PartTimeEmployee extends Employee implements TaxableInterface {
	int workHrs;
	
	public PartTimeEmployee(int workHrs) {
		super();
		this.workHrs = workHrs;
	}

	public PartTimeEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PartTimeEmployee(String empName, String empDept, int adhaar, double baseSalary, int leaveBalance, int workHrs) {
		super(empName, empDept, adhaar, baseSalary, leaveBalance);
		// TODO Auto-generated constructor stub
		this.workHrs = workHrs;
	}

	public int getWorkHrs() {
		return workHrs;
	}

	public void setWorkHrs(int workHrs) {
		this.workHrs = workHrs;
	}

	@Override
	public double calculateTax(double salary) {
		// TODO Auto-generated method stub
		return (salary * TaxableInterface.taxRate);
		}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return empName;
	}

	@Override
	double calculateSalary() {
		// TODO Auto-generated method stub
		baseSalary *=workHrs;
		baseSalary -= calculateTax(baseSalary);
		return baseSalary;

	}

	@Override
	public String getEmpType() {
		// TODO Auto-generated method stub
		return "Part Time";
	}

	@Override
	String provideBenefits() {
		// TODO Auto-generated method stub
		return("No Benefits available.");
	}

}
