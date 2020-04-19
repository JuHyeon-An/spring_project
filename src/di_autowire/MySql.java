package di_autowire;

public class MySql implements DB {

	@Override
	public void getIrum() {
		System.out.println("나는 MySql...");
		
	}

}
