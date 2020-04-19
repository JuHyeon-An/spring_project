package aop_aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AopMain {

	AopMain(){
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/aop_anno/aop.xml");
		Dao dao = (Dao)ac.getBean("member");
		dao.select();
		dao.insert();
		dao.delete();
		dao.view();
	}
	
	public static void main(String[] args) {
		new AopMain();
	}

}
