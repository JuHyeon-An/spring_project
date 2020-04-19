package di_collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionTest implements MyColl {

	List<String> list;
	Map<String, String> map;
	Set<String> set;
	Properties props;
	

	@Override
	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public void setMap(Map<String, String> map) {
		this.map = map;
		
	}

	@Override
	public void setSet(Set<String> set) {
		this.set = set;
		
	}

	@Override
	public void setProps(Properties props) {
		this.props = props;
		
	}

	@Override
	public List<String> getList() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Map<String, String> getMap() {
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public Set<String> getSet() {
		return set;
	}

	@Override
	public Properties getProps() {
		return props;
	}

	

}
