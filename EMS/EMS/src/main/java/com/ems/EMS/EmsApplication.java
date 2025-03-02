package com.ems.EMS;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ems.EMS.model.Employee;
import com.ems.EMS.model.EmsAppCoonfig;
import com.ems.EMS.model.HR;
import com.ems.EMS.model.Payroll;
import com.ems.EMS.model.Performance;
import com.ems.EMS.service.EmployeeService;
import com.ems.EMS.service.HrService;
import com.ems.EMS.service.PayrollService;
import com.ems.EMS.service.PerformanceService;
import com.ems.EMS.model.Address;

@SpringBootApplication
public class EmsApplication {

	public static void main(String[] args) {
//		SpringApplication.run(EmsApplication.class, args);
		
//		// For XML base bean configuration..
////		ApplicationContext context = new ClassPathXmlApplicationContext("emsConfiguration.xml");
//		
//		//For Class based configuration bean..
//		ApplicationContext context = new AnnotationConfigApplicationContext(EmsAppCoonfig.class);
//		
//		EmployeeService emp = context.getBean(EmployeeService.class);
//		PayrollService pr = context.getBean(PayrollService.class);
////		Performance prfmc = context.getBean("performance", Performance.class);
////		HR hr = context.getBean("hr", HR.class);
//		
//		emp.display();
//		System.out.println("Calculated Salary: "+pr.calAnnualbonus());
////		System.out.println(prfmc);
////		hr.displayEmployees();
//		
		
		ApplicationContext context = new AnnotationConfigApplicationContext(EmsAppCoonfig.class);
		System.out.println("Employee service");
		EmployeeService empService = context.getBean(EmployeeService.class);
		empService.printEmpDetails();
		System.out.println(empService.calcAnnualSalary());
		System.out.println(empService.getEmpSkills());
		System.out.println("--------------------------------------------");
		
		System.out.println("HR service");
		HrService hrService = context.getBean(HrService.class);
		System.out.println(hrService.getEmpById(1));
		System.out.println("--------------------------------------------");
		
		System.out.println("Payroll service");
		PayrollService payrollService = context.getBean(PayrollService.class);
		System.out.println(payrollService.calAnnualbonus());
		System.out.println(payrollService.calAnnualdeduction());
		System.out.println(payrollService.toString());
		System.out.println("--------------------------------------------");
		
		System.out.println("Performance service");
		PerformanceService performanceService = context.getBean(PerformanceService.class);
		System.out.println(performanceService.IsEligibleForProject());
		System.out.println(performanceService.displayProjectList());
		System.out.println("--------------------------------------------");

	}



}
