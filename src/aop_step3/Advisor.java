package aop_step3;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.aopalliance.intercept.MethodInvocation;
import org.aopalliance.intercept.MethodInterceptor;

public class Advisor implements MethodInterceptor{
	Dao dao;
	SimpleDateFormat logTime = 
			new SimpleDateFormat("yyyy-MM-dd(E요일) hh:mm:ss:SS");

	public void before() { // advice (시간적 개념)
		System.out.println(logTime.format(new Date()));
		dao.select();
		// joinPoint(공간적 개념) / pointCut : weaving될 지점
	}
	
	public void after() {
		dao.delete();
		System.out.println(logTime.format(new Date()));
	}
	
	public void around() {
		System.out.println(logTime.format(new Date()));
		dao.insert();
		System.out.println(logTime.format(new Date()));
	}

	public Dao getDao() {
		return dao;
	}
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// select가 호출되면 invoke가 메소드를 인터셉트해서 로그타임을 먼저 출력한다 (before advice 형태)
		
		// 횡단적 관심사로 분리된 처리 내용
		System.out.println("invoke가 실행됨 : " + logTime.format(new Date()));
		Object o = invocation.proceed();// proxy에 의해서 호출된 메소드를 실행시켜주는 명령어
		return o;
	}
}
