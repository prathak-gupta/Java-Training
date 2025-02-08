package day6;

public class InternEmployee extends Employee {

	public InternEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InternEmployee(String empName, String empDept, int adhaar, double baseSalary, int leaveBalance) {
		super(empName, empDept, adhaar, baseSalary, leaveBalance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return empName;
	}

	@Override
	double calculateSalary() {
		// TODO Auto-generated method stub
		return baseSalary;
	}

	@Override
	public String getEmpType() {
		// TODO Auto-generated method stub
		return "Intern";
	}

	@Override
	String provideBenefits() {
		// TODO Auto-generated method stub
		return("Paid Internship.");
	}

}
