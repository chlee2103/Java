package AdressProject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


/*
 	name;
	number;
	group;
	edress;
	memo;
 */



public class AdressDao {
	Scanner sc = new Scanner(System.in);
	private HashMap<String, AdressDto> map;
	private boolean flag;
	
	
	AdressDao(){
		map = new HashMap<String, AdressDto>();
		flag = false;
	}
	
	// 필수입력 : 이름, 번호
	public void basicInsert() {
		p("이름 > " ); String name = sc.next();
		p("번호 > " ); String number = sc.next();
		map.put(key(), new AdressDto("이름:"+name, " 번호:"+number, "", "", ""));
	}
	// 추가입력 : 주소, 그룹 메모
	public void pulsInsert() {
		while(true) {
			p("추가입력 (1.그룹, 2.주소, 3.메모) 중 선택 > ");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				pulsGroup();	break;
			}else if(choice == 2) {
				pulsAdress();	break;
			}else if(choice == 3) {
				pulsMemo();		break;
			}else {
				continue;
			}
		}
		pln("데이터가 추가되었습니다.");
	}
	void pulsGroup() {
		p("이름검색 > "); String name = sc.next();
		nameSearch(name);
		flag();
		
		int index = 1;
		p("데이터 번호 입력 > "); String data = sc.next();
		p("그룹 > "); String group = sc.next();
		
		
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next(); // key값 얻기
			AdressDto val = map.get(key);// value값 얻기
			key = index+key;
			index++;
			if (key.length()== 20 && key.substring(0,1).equals(data)) {
				key = key.substring(1);
				val.setGroup(" 그룹:"+group);
			}
		}
	}
	void pulsAdress() {
		p("이름검색 > "); String name = sc.next();
		nameSearch(name);
		
		flag();
		
		p("데이터 번호 입력 > "); String data = sc.next();
		p("주소 > "); String adress = sc.next();
		
		int index = 1;
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next(); // key값 얻기
			AdressDto val = map.get(key);// value값 얻기
			key = index+key;
			index++;
			if (key.length()== 20 && key.substring(0,1).equals(data)) {
				key = key.substring(1);
				val.setAdress(" 주소:"+adress);
			}
		}
	}
	void pulsMemo() {
		p("이름검색 > "); String name = sc.next();
		nameSearch(name);
		
		flag();
		
		int index = 1;
		p("데이터 번호 입력 > "); String data = sc.next();
		p("메모 > "); String memo = sc.next();
		
		
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next(); // key값 얻기
			AdressDto val = map.get(key);// value값 얻기
			key = index+key;
			index++;
			if (key.length()== 20 && key.substring(0,1).equals(data)) {
				key = key.substring(1);
				val.setMemo(" 메모:"+memo);
			}
		}
	}
	// 수정 : 번호, 주소, 그룹, 메모 (아직..)
	void update() {
		while(true) {
			p("수정 (1.번호, 2.그룹, 3.주소, 4.메모) 중 선택 > ");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				upNumber();	break;
			}else if(choice == 2) {
				pulsGroup(); break;
			}else if(choice == 3) {
				pulsAdress(); break;
			}else if(choice == 4) {
				pulsMemo();	break;
			}else {
				continue;
			}
		}
		pln("데이터가 수정되었습니다.");
	}
	void upNumber() {
		p("이름검색 > "); String name = sc.next();
		nameSearch(name);
		
		flag();
		
		p("데이터 번호 입력 > "); String data = sc.next();
		p("번호 > "); String number = sc.next();
		
		int index = 1;
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next(); // key값 얻기
			AdressDto val = map.get(key);// value값 얻기
			key = index+key;
			index++;
			if (key.length()== 20 && key.substring(0,1).equals(data)) {
				key = key.substring(1);
				val.setNumber(" 번호:"+number);
			}
		}
	}
	
	// 삭제 : 이름검색으로 삭제
	void delete() {
		p("삭제할 사용자 > "); String name = sc.next();
		nameSearch(name);
		
		flag();
		
		p("데이터 번호 입력 > "); String data = sc.next();
		int index = 1;
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next(); // key값 얻기
			key = index+key;
			index++;
			if (key.length()== 20 && key.substring(0,1).equals(data)) {
				key = key.substring(1);
				map.remove(key);
			}
		}
		pln("데이터가 삭제되었습니다.");
	}
	// 검색 : 그룹, 이름, 번호
	void search() {
		while(true) {
			p("검색 (1.이름, 2.번호, 3.그룹, 4.주소, 5.메모) 중 선택 > ");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				searchName(); break;
			}else if(choice == 2) {
				searchNumber(); break;
			}else if(choice == 3) {
				searchGroup(); break;
			}else if(choice == 4) {
				searchAdress(); break;
			}else if(choice == 5) {
				searchMemo(); break;
			}else {
				continue;
			}
		}
	}
	
	void searchName() {
		p("이름검색 > "); String name = sc.next();
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next(); // key값 얻기
			AdressDto val = map.get(key);// value값 얻기
			if (val.getName().contains(name)) {
				plna(val);
				flag = true;
			}
		}
		flag();
	}
	void searchNumber() {
		p("번호검색 > "); String number = sc.next();
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next(); // key값 얻기
			AdressDto val = map.get(key);// value값 얻기
			if (val.getNumber().contains(number)) {
				plna(val);
				flag = true;
			}
		}
		flag();
	}
	void searchGroup() {
		p("그룹검색 > "); String group = sc.next();
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next(); // key값 얻기
			AdressDto val = map.get(key);// value값 얻기
			if (val.getGroup().contains(group)) {
				plna(val);
				flag = true;
			}
		}
		flag();
	}
	void searchAdress() {
		p("주소검색 > "); String adress = sc.next();
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next(); // key값 얻기
			AdressDto val = map.get(key);// value값 얻기
			if (val.getAdress().contains(adress)) {
				plna(val);
				flag = true;
			}
		}
		flag();
	}
	void searchMemo() {
		p("주소검색 > "); String memo = sc.next();
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next(); // key값 얻기
			AdressDto val = map.get(key);// value값 얻기
			if (val.getMemo().contains(memo)) {
				plna(val);
				flag = true;
			}
		}
		flag();
	}
	
	// 전체출력 
	void allPrint() {
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			AdressDto val = map.get(key);
			plna(val);
			flag = true;
		}
		flag();
	}
	
	void nameSearch(String name) {
		int index = 1;
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next(); // key값 얻기
			AdressDto val = map.get(key);// value값 얻기
			if (val.getName().contains(name)) {
				pln(index + " 데이터 > " + val);
				flag = true;
				index++;
			}
		}
	}
	
	
	String key() {  // 중복방지를 위해 날짜,시간으로 설정
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd-HH-mm-ss");
		Date time = new Date();
		String key = format.format(time);
		return key;
	}
	void flag() {
		if(flag == false) {
			pln("데이터가 없습니다.");
			return;
		}
	}
	void p(String str) {
		System.out.print(str);
	}
	void pln(String str) {
		System.out.println(str);
	}
	void plna(AdressDto str) {
		System.out.println(str);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
