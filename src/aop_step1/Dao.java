package aop_step1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dao {
	SimpleDateFormat logTime = 
			new SimpleDateFormat("yyyy-MM-dd(E요일) hh:mm:ss:SS");
	
	public void select() {
		System.out.println("select문장이 실행됨.......ㅎ");
		System.out.println(logTime.format(new Date()));
	}
	
	public void view() {
		System.out.println("view문장이 실행됨.......ㅎ");
		System.out.println(logTime.format(new Date()));
	}
	
	public void modify() {
		System.out.println("modify문장이 실행됨.......ㅎ");
		System.out.println(logTime.format(new Date()));
	}
	
	public void insert() {
		System.out.println("insert문장이 실행됨.......ㅎ");
		System.out.println(logTime.format(new Date()));
	}
	
	public void delete() {
		System.out.println("delete문장이 실행됨.......ㅎ");
		System.out.println(logTime.format(new Date()));
	}
	
}
