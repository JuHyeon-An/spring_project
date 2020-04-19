package di_collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CollectionMain {

	public CollectionMain() {
		ApplicationContext ac = 
				new FileSystemXmlApplicationContext("src/di_collection/collection.xml");
		
		//list
//		CollectonTest ct = (CollectonTest)ac.getBean("coll");
		
		MyColl ct = (MyColl)ac.getBean("coll");
		/* 다형성 유지
		/ 인터페이스에 모든 메소드가 정의되어 있을 때.
		 * but MyColl에서 정의되어 있지 않은 메소드를 추가했으면 사용할 수 없다
		 */
		
		List<String> addressList = ct.getList();
		System.out.println("<List 주소 목록>");
		for(String address : addressList) {
			System.out.println(address);
		}
		
		//set
		Set<String> addressSet = ct.getSet();
		
		System.out.println("<Set 주소 목록>");
		for(String address : addressSet) {
			System.out.println(address);
		}
		
		//map
		Map<String, String> addressMap = ct.getMap();
		
		System.out.println("<Map 주소 목록>");
		Set<String> keys = addressMap.keySet();
		
		for(String key : keys) {
			System.out.println(key+"의 주소 : "+addressMap.get(key));
		}
		
		//prop
		Properties prop = ct.getProps();
		Set<Object> keys2 = prop.keySet();
		
		System.out.println("<Prop 주소 목록>");
		for(Object p : keys2) {
			System.out.println(p.toString()+"의 주소는 : "+prop.getProperty((String)p));
		}
	}
	
	public static void main(String[] args) {
		new CollectionMain();
		
	}
}
