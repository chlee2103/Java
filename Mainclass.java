package singletonAccount;

import java.util.Scanner;

import bt210521.Ex01.AccountDaoCho;

public class Mainclass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fileclass fc = new Fileclass("newAccount");
		Insertclass i = new Insertclass();
		Deleteclass d = new Deleteclass();
		Selectclass s = new Selectclass();
		Updateclass u = new Updateclass();
		UtilPclass up = new UtilPclass();
		
		up.pln("=가계부 프로그램=");
		while(true) {
			up.pln("====메뉴====");
			up.pln("1. 사용추가");
			up.pln("2. 내용삭제");
			up.pln("3. 내용검색");
			up.pln("4. 내용수정");
			up.pln("5. 전체출력");
			up.pln("6. 내용저장");
			up.pln("===========");
			up.p("메뉴선택  > ");
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1:
					i.process();
					break;
				case 2:
					d.process();
					break;
				case 3:
					s.process();
					break;
				case 4:
					u.process();
					break;
				case 5:
					s.allPrint();
					break;
				case 6:
					fc.fileSave();
					break;	
				default:
					up.pln("메뉴만 선택가능");
				
			}
		}
		
		
		
		
		
	}
}
