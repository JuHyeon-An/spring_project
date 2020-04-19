package aop_step2_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AopMain {

	AopMain(){
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/aop_step2_1/aop.xml");
		Advisor ad = (Advisor)ac.getBean("advisor");
		
		ad.after();
		ad.before();
		ad.around();
	}
	
	public static void main(String[] args) {
		new AopMain();
	}

}
