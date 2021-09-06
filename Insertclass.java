package singletonAccount;

import java.util.Scanner;

import bt210521.Ex01.AccountDtoCho;

public class Insertclass {
	
	
	public Insertclass() {
		
	}
	
	public void process() {
		Singletonclass si = Singletonclass.getInstence();
		UtilPclass up = new UtilPclass();
		UtilKeyclass uk = new UtilKeyclass();
		UtilTimaclass ut = new UtilTimaclass();
		
		Scanner sc = new Scanner(System.in);
		
		up.pln("날짜를 입력해주세요");
		String time = ut.day();
		up.p("수입 / 지출 > "); 	String classify = sc.next();
		up.p("용도 > "); 		String use = sc.next();
		up.p("금액 > "); 		int money = sc.nextInt();
		while(true) {
			up.pln("메모를 입력하시겠습니까? (y/n)"); String choice = sc.next();
			if(choice.equals("y")) {
				up.p("메모 > ");			String memo = sc.next();
				memo = "메모:"+memo;
				si.map.put(uk.date(), new AccountDtoCho(time, classify, use, money, memo));
				break;
			}else if(choice.equals("n")) {
				String memo = "";
				si.map.put(uk.date(), new AccountDtoCho(time, classify, use, money, memo));
				break;
			}else {
				System.out.println("(y/n) 선택가능 .. ");
				continue;
			}
		}
	}
	
	
}
