package aop_step1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import aop_step2.Advisor;

public class AopMain {

	AopMain(){
		ApplicationContext ac = 
		new FileSystemXmlApplicationContext("src/aop_step1/aop.xml");
		Dao dao = (Dao)ac.getBean("dao");
		
		dao.select();
		dao.insert();
		dao.delete();
		dao.modify();
		dao.view();
	}
	
	public static void main(String[] args) {
		new AopMain();
		
	}

}
