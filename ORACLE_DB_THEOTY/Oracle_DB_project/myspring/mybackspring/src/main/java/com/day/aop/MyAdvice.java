package com.day.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAdvice {
	private Logger log = Logger.getLogger(MyAdvice.class);
	
	@Before("execution(* log*(..)) ||  execution(* findById(**))") //login()메서드호출 직전에 beforeLog()메서드가 호출됨
	public void beforeLog() {
		log.error("Before");
	}
	
	@Around("execution(* log*(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{//포인트컷 메서드 호출 전후에 aroundLog()의 내용이 수행됨
		String pMethodName = pjp.getSignature().getName();
		log.error("Around 포인트컷메서드("+ pMethodName+") 호출 전");
		Object obj = pjp.proceed(); //포인트컷 메서드 호출
		log.error("Arround 포인트컷메서드("+ pMethodName+") 호출 후 ");
		return obj;
		
	}
}
