package aop_step2_1;

public class MemberDao implements Dao {

	@Override
	public void select() {
		System.out.println("member의 select");
	}

	@Override
	public void insert() {
		System.out.println("member의 insert");
	}

	@Override
	public void delete() {
		System.out.println("member의 delete");
	}

	@Override
	public void modify() {
		System.out.println("member의 modify");
	}

	@Override
	public void view() {
		System.out.println("member의 view");
	}

}
