package bt210521.Ex01;

import java.util.Scanner;

public class MainClassCho {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AccountDaoCho dao = new AccountDaoCho();
		
		dao.pln("=가계부 프로그램=");
		while(true) {
			dao.pln("====메뉴====");
			dao.pln("1. 사용추가");
			dao.pln("2. 내용삭제");
			dao.pln("3. 내용검색");
			dao.pln("4. 내용수정");
			dao.pln("5. 전체출력");
			dao.pln("6. 내용저장");
			dao.pln("===========");
			dao.p("메뉴선택  > ");
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1:
					dao.insert();
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.search();
					break;
				case 4:
					dao.update();
					break;
				case 5:
					dao.allPrint();
					break;
				case 6:
					dao.dataSave();;
					break;	
				default:
					dao.pln("메뉴만 선택가능");
				
			}
		}
		
		
		
		
		
	}
}
