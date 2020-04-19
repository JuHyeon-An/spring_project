package di_autowire;

/*
 * 빈 객체 중 이름이 동일한 빈 객체를 자동 주입
 */

public class ByNameDao {
	DB db;

	public DB getDb() {
		return db;
	}

	
	// 빈의 id가  db인 객체가 주입됨.
	// = 빈의 id가 db면 자동으로 들어감!
	public void setDb(DB db) {
		this.db = db;
		System.out.print("잘 주입됐다는 것을 알기 위해 출력 : ");
		db.getIrum();
	}
}
