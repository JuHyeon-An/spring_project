package mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Factory {
	// DB별로 factory는 ㄸㅏ로 가지고 있어야함 (보통 DB명+Factory, XEFactory)
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader r = Resources.getResourceAsReader("config.xml");
			factory = new SqlSessionFactoryBuilder().build(r);
			System.out.println("factory good.....");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}


	public static void main(String[] args) {
		Factory.getFactory();
	}
	
}
