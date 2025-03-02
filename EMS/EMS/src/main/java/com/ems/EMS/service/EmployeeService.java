package com.ems.EMS.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ems.EMS.model.Employee;
 
@Service
public class EmployeeService {
	@Autowired
	private Employee employee;
	public void printEmpDetails() {
		System.out.println(employee);
	}
	public double calcAnnualSalary() {
		return employee.getSalary();
	}
	public List<String> getEmpSkills() {
		return employee.getSkills();
	}
	public boolean isEligiblePromotion() {
		return employee.getDesignation().equalsIgnoreCase("Principal Consultant");
	}
	
	public void display() {
		System.out.println(employee);
	}
}