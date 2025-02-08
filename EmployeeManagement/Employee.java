package day6;

public abstract class Employee implements Person {
	public static String COMPANY = "Genpact";
	protected String empName, empDept;
	protected int adhaar;
	protected double baseSalary, netSalary;
	protected int leaveBalance;
	
	public Employee()
	{	}
	
	
	
	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public String getEmpDept() {
		return empDept;
	}



	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}


	@Override
	public int getAdhaar() {
		return adhaar;
	}



	public void setAdhaar(int adhaar) {
		this.adhaar = adhaar;
	}



	public double getBaseSalary() {
		return baseSalary;
	}



	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}



	public int getLeaveBalance() {
		return leaveBalance;
	}



	public void setLeaveBalance(int leaveBalance) {
		this.leaveBalance = leaveBalance;
	}



	public Employee(String empName, String empDept, int adhaar, double baseSalary, int leaveBalance) {
		super();
		this.empName = empName;
		this.empDept = empDept;
		this.adhaar = adhaar;
		this.baseSalary = baseSalary;
		this.leaveBalance = leaveBalance;
		netSalary =this.calculateSalary();
	}

	public double getNetSalary() {
		return netSalary;
	}



	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}



	abstract double calculateSalary();
	
	abstract public String getEmpType();
	
	abstract String provideBenefits();
	
	public boolean requestLeave(int days) {
		if(days <= leaveBalance)
		{
			System.out.println("Leaves granted!");
			leaveBalance -=days;
			return true;
		}else
		{
			System.out.println("Can't permit! Leave Balance Insufficient!");
			return false;
		}
	}

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------------");
		System.out.println("Company Name: " +COMPANY);		
		System.out.println("Employee Name: " +empName);
		System.out.println("Employee ID: " +adhaar);
		System.out.println("Employee Department : " +empDept);
		System.out.println("Employee Base Salary: " +baseSalary);
		System.out.println("Employee Net Salary: " +netSalary);
		System.out.println("Leave Balance: " +leaveBalance);
		System.out.println("Employee Adhaar : " +adhaar);
		System.out.println("Employement Type: " +getEmpType());
		System.out.println("Employee Benefits: "+ provideBenefits());
		System.out.println("------x---------x------x-------x-----");
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empDept=" + empDept + ", adhaar=" + adhaar + ", baseSalary="
				+ baseSalary + ", leaveBalance=" + leaveBalance + "]";
	}	
	

}
