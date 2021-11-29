package com.aurionpro.beneficiary.aspects;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeneValidationAspect {
	
	
	@Pointcut("execution(* com.aurionpro.beneficiary.controller.BeneficiaryController.*(..))")
	private void vaidatorToInvoke(){}
	
	
	
		@Around("vaidatorToInvoke() && args(.., @RequestBody body)")
		public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint,final HttpServletRequest body) throws Throwable
		{
			System.out.println("##Aspect Called##");
			proceedingJoinPoint.getTarget().getClass().getCanonicalName();
			proceedingJoinPoint.getSignature().getName();
			return proceedingJoinPoint.proceed();
			
		}
		
	
}

