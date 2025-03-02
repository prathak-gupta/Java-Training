package com.ems.EMS.model;

public class Payroll {
	private int empId;
	double baseSalary;
	private double bonuses;
	private double deductions;
	
	public Payroll() {};
	
	public Payroll(int empId, double baseSalary, double bonuses, double deductions) {
		super();
		this.empId = empId;
		this.baseSalary = baseSalary;
		this.bonuses = bonuses;
		this.deductions = deductions;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public double getBonuses() {
		return bonuses;
	}
	public void setBonuses(double bonuses) {
		this.bonuses = bonuses;
	}
	public double getDeductions() {
		return deductions;
	}
	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}
	@Override
	public String toString() {
		return "Payroll [empId=" + empId + ", baseSalary=" + baseSalary + ", bonuses=" + bonuses + ", deductions="
				+ deductions + "]";
	}
	
	public double calculateSalary()
	{
		return baseSalary+bonuses-deductions;
	}
}
