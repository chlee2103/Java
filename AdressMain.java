package AdressProject;

import java.util.Scanner;

public class AdressMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdressDao dao = new AdressDao();
		
		dao.pln("주소록프로그램");
		while(true) {
			dao.pln("=메뉴=====");
			dao.pln("1. 사람입력");
			dao.pln("2. 추가입력");
			dao.pln("3. 내용수정");
			dao.pln("4. 내용삭제");
			dao.pln("5. 내용검색");
			dao.pln("6. 전체출력");
			dao.pln("=========");
			dao.p("메뉴선택  > ");
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1:
					dao.basicInsert();
					break;
				case 2:
					dao.pulsInsert();
					break;
				case 3:
					dao.update();
					break;
				case 4:
					dao.delete();
					break;
				case 5:
					dao.search();
					break;
				case 6:
					dao.allPrint();
					break;	
				default:
					dao.pln("메뉴만 선택가능");
				
			}
		}
	}
}
