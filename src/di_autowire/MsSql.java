package di_autowire;

public class MsSql implements DB {

	@Override
	public void getIrum() {
		System.out.println("나는 MsSql...");
	}

}
