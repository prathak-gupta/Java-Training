package com.onlinebookshop.shop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect		// Spring aspect
@Component	//Register aspect as a bean
public class LoggingAspect {

	@Before("execution(* com.onlinebookshop.shop.service.*.*(..)) ")
	public void beforeServiceMethod() {
		System.out.println("---------- Loggin from Aspect: BEFORE Method called in service layer. ----------");
	}
	
	@After("execution(* com.onlinebookshop.shop.service.*.*(..)) ")
	public void afterServiceMethod() {
		System.out.println("---------- Loggin from Aspect: AFTER Method called in service layer. ----------");
	}
	
	@Around("execution(* com.onlinebookshop.shop.service.*.*(..)) ")
	public Object aroundServiceMethod(ProceedingJoinPoint joinPoint) {
		Object result =null;
		long startTime = System.currentTimeMillis();
		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("----------- Logging AROUND method execution time: "+ joinPoint.getSignature().getClass()+"."+ joinPoint.getSignature().getName()+": "+(endTime-startTime));
		return result;
	}
	
	@AfterReturning("execution(* com.onlinebookshop.shop.service.*.*(..)) ")
	public void afterReturningMethod()
	{
		System.out.println("------------------ Logging AFTER_RETURNING method");
	}

	
	@AfterThrowing("execution(* com.onlinebookshop.shop.service.*.*(..)) ")
	public void afterThrowingMethod()
	{
		System.out.println("------------------ Logging AFTER_THROWING method");
	}
	
}
