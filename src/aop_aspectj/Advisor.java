package aop_aspectj;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Advisor {

	SimpleDateFormat logTime = 
			new SimpleDateFormat("yyyy-MM-dd(E요일) hh:mm:ss:SS");

	@Before("execution(* aop_anno.Dao.*(..))")
	public Object beforeMethod(JoinPoint point) {
		System.out.println(logTime.format(new Date()));
		return null;
	}
	
	@Around("execution(* update(..))")
	public Object aroundMethod(ProceedingJoinPoint point) {
		try {
			System.out.println(logTime.format(new Date()));
			point.proceed();
			System.out.println(logTime.format(new Date()));
		}catch(Throwable ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
}
