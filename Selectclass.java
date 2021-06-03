package singletonAccount;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

import bt210521.Ex01.AccountDtoCho;

public class Selectclass {
	Scanner sc = new Scanner(System.in);
	
	Singletonclass si;
	UtilPclass up;
	UtilTimaclass ut;
	UtilDaySearch ud;
	
	private boolean flag;
	
	public Selectclass() {
		si = Singletonclass.getInstence();
		up = new UtilPclass();
		ut = new UtilTimaclass();
		ud = new UtilDaySearch();
		
		flag = false;
	}
	public void process() {
		
		while(true) {
			up.pln("1. 날짜별 검색");
			up.pln("2. 기간별 검색");
			up.pln("3. 수입/지출별 검색");
			up.pln("4. memo별 검색");
			up.pln("menu 선택 > "); int choice = sc.nextInt();
			
			if(choice == 1) {
				searchDate();
				break;
			}else if(choice == 2) {
				searchDayByDay();
				break;	
			}else if(choice == 3) {
				searchClassify();
				break;
			}else if(choice == 4) {
				searchMemo();
				break;
			}else {
				up.pln("menu안에서 선택 가능!!");
				continue;
			}
		}
	}
	
	// 날짜별 검색
	void searchDate() {
		String search = ut.day();
		Iterator<String> itkey = si.map.keySet().iterator();
		while(itkey.hasNext()) {
			String key = itkey.next();
			AccountDtoCho val = si.map.get(key);
			if(search.equals(val.getDateTime())) {
				up.plna(val);
				flag = true;
			}
		}
		if(flag == false) {
			up.pln("데이터가 없습니다.");
			return;
		}
	}
	
	// 기간별 검색
	void searchDayByDay() {
		up.pln("검색 시작 날짜 "); String startDay = ut.day(); int startNum = intDay(startDay);
		up.pln("검색 마지막 날짜 "); String lastDay = ut.day(); int lastNum = intDay(lastDay);
		
		TreeMap<String, AccountDtoCho> tMap = new TreeMap<String, AccountDtoCho>(si.map);
		Iterator<String> itkey = tMap.descendingKeySet().iterator();
		while(itkey.hasNext()) {
			String key = itkey.next();
			AccountDtoCho val = (AccountDtoCho) tMap.get(key);
			int dayNum = intDay(val.getDateTime());
			if(dayNum >= startNum && lastNum >=dayNum) {
				up.plna(val);
				flag = true;
			}
			if(flag == false) {
				up.pln("데이터가 없습니다.");
				return;
			}
		}
	}

	// 지출/수입별 검색
	void searchClassify() {
		int index = 0;
		while(true) {
			up.p("수입/지출 입력 > ");
			String search = sc.next();
			Iterator<String> itkey = si.map.keySet().iterator();
			while(itkey.hasNext()) {
				String key = itkey.next();
				AccountDtoCho val = si.map.get(key);
				if(search.equals(val.getClassify())) {
					up.plna(val);
					flag = true;
					index++;
					break;
				}
			}
			if(index == 0) {
				up.pln("데이터가 없습니다");
				return;
			}
			if(flag == false) {
				up.pln("수입/지출 입력만 입력가능");
				break;
			}
		}
	}
	
	// 메모
	void searchMemo() {
		up.p("memo입력 > ");
		String search = sc.next();
		
		Iterator<String> itkey = si.map.keySet().iterator();
		while(itkey.hasNext()) {
			String key = itkey.next();
			AccountDtoCho val = si.map.get(key);
				if((val.getMemo().contains(search))) {
					up.plna(val);
				flag = true;
				}
			}
		
		if(flag == false) {
			up.pln("데이터가 없습니다.");
			return;
		}
	}
	
	public void allPrint() {
		TreeMap<String, AccountDtoCho> tMap = new TreeMap<String, AccountDtoCho>(si.map);
		Iterator<String> itkey = tMap.keySet().iterator();
		while(itkey.hasNext()) {
			String key = itkey.next();
			AccountDtoCho val = tMap.get(key);
			System.out.println(val);
		}
	}
	
	int intDay(String day) {
		String days[] = day.split("/");
		String dayStr = days[0]+days[1]+days[2];
		int intDay = Integer.parseInt(dayStr);
		
		return intDay;
	}
	
	
	

}
