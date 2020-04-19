package aop_step2_1;

public class BoardDao implements Dao {

	@Override
	public void select() {
		System.out.println("board의 select");
	}

	@Override
	public void insert() {
		System.out.println("board의 insert");
	}

	@Override
	public void delete() {
		System.out.println("board의 delete");
	}

	@Override
	public void modify() {
		System.out.println("board의 modify");
	}

	@Override
	public void view() {
		System.out.println("board의 view");
	}

}
