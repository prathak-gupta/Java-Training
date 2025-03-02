package com.ems.EMS.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages="com.ems.EMS.service")
@PropertySource("classpath:application.properties")
public class EmsAppCoonfig {

//	@Bean
//	public Address address()
//	{
//		Address add = new Address("123 main Street, Noida", "Greater Noida", "Uttar Pradesh","32143");
//		return add;
//	}
//	
//	@Bean
//	public Department department()
//	{
//		Department dept = new Department(4421,"Application Developer");
//		return dept;
//	}
//	
//	@Bean
//	public List<String> skills()
//	{
//		return Arrays.asList("Java","HTML","JS","Paython");
//	}
//	
//	@Bean
//	public List<String> projectHandled()
//	{
//		return Arrays.asList("EMS","HMS","Book Management","Bank Management");
//	}
//	
//	@Bean
//	public Employee employee()
//	{
//		return new Employee(0,"Prathak","prtk.gpt@genpact.com","983629239",1000000,"Developer",address(),department(), skills());
//		return emp;
//	}
//	
//	@Bean
//	public Map<Integer, Employee> empRecord()
//	{
//		Map<Integer, Employee> records = new HashMap<>();
//		records.put(1,employee());
//		return records;
//	}
//	
//	@Bean
//	public HR hr()
//	{
//		return new HR(empRecord());
//	}
//	
//	@Bean
//	public Payroll payroll()
//	{
//		return new Payroll(0, 100000,20000,10000);
//	}
//	
//	@Bean
//	public Performance performance()
//	{
//		return  new Performance(0,4.5,"Amazing Work!", projectHandled(),true);
//		
//	}
	
	//Address Bean
	@Value("${address.street}")
	private String street;
	@Value("${address.city}")
	private String city;
	@Value("${address.state}")
	private String state;
	@Value("${address.zipcode}")
	private String zipcode;
	@Bean
	public Address address() {
      Address address = new Address();
      address.setStreet(street);
      address.setCity(city);
      address.setState(state);
      address.setZipcode(zipcode);
      return address;
	}
	//Department Bean
	@Value("${department.deptId}")
	private int id;
	@Value("${department.name}")
	private String name;
	@Bean
	public Department dept() {
		Department dept = new Department();
        dept.setDeptId(id);
        dept.setDeptName(name);
        return dept;
	}
	// list of skills for employee
	@Value("${employee.skills}")
	private String skillsString;
	@Bean
	public List<String> skills() {
		return Arrays.asList(skillsString.split(","));
	}
	// employee bean
	@Value("${employee.empID}")
	private int empid;
	@Value("${employee.empName}")
	private String empname;
	@Value("${employee.email}")
	private String email;
	@Value("${employee.phone}")
	private String phone;
	@Value("${employee.salary}")
	private double salary;
	@Value("${employee.designation}")
	private String designation;
//	@Value("${employee.skills}")
//	private String skillsString;
	@Bean
	public Employee employee() {
	  Employee employee = new Employee();
	  employee.setEmpID(empid);
	  employee.setEmpName(empname);
	  employee.setEmail(email);
	  employee.setPhone(phone);
	  employee.setSalary(salary);
	  employee.setDesignation(designation);
	  employee.setAddress(address());
	  employee.setDepartment(dept());
	  employee.setSkills(skills());
	  return employee;
	}
	// Performance Bean
    @Value("${performance.empId}")
    private int performanceEmployeeId;
    @Value("${performance.rating}")
    private double rating;
    @Value("${performance.feedback}")
    private String feedback;
    @Value("${performance.projectsHandled}")
    private String projectsHandledString;
    @Value("${performance.eligibleForPromotion}")
    private boolean eligibleForPromotion;
    @Bean
    public List<String> projectsHandled() {
        return Arrays.asList(projectsHandledString.split(","));
    }
    @Bean
    public Performance performance() {
        Performance performance = new Performance();
        performance.setEmpId(performanceEmployeeId);
        performance.setRating(rating);
        performance.setFeedback(feedback);
        performance.setProjectHandled(projectsHandled());
        performance.setEligibleForPromotion(eligibleForPromotion);
        return performance;
    }
 // hr bean
	@Bean
	public Map<Integer, Employee> empRecords() {
	    Map<Integer, Employee> rec = new HashMap<>();
	    rec.put(empid, employee());
	    return rec;
	}
	@Bean
	public HR hr() {
	    HR hr = new HR();
	    hr.setEmployeeRecords(empRecords());
	    return hr;
	}

    // Payroll Bean
    @Value("${payroll.baseSalary}")
    private double baseSalary;
    @Value("${payroll.bonuses}")
    private double bonuses;
    @Value("${payroll.deductions}")
    private double deductions;
    @Bean
    public Payroll payroll() {
        Payroll payroll = new Payroll();
        payroll.setBaseSalary(baseSalary);
        payroll.setBonuses(bonuses);
        payroll.setDeductions(deductions);
        return payroll;
    }

}
