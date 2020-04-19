package di_step4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DiMain {

	public DiMain(DB db) {
		db.getIrum();
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = 
				new FileSystemXmlApplicationContext("src/di_step4/assembler.xml");
		
//		DB db = ac.getBean("oracle", Oracle.class);
		Assembler as = (Assembler)ac.getBean("assemble");
		DB db = as.getDb();
		DiMain dm = new DiMain(db);
		
		// method를 통한 DI
		MemberVo vo = (MemberVo)ac.getBean("mVo");
		System.out.println(vo.getmId());
		System.out.println(vo.getmName());
		
		MemberDao dao = (MemberDao)ac.getBean("dao");
		
	}

}