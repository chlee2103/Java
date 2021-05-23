package bt210521.Ex01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class AccountDaoCho {
	Scanner sc = new Scanner(System.in);
	private  HashMap<String, AccountDtoCho> map = new HashMap<>();
	private DataProcessCho dp;
	private boolean flag;
	
	public AccountDaoCho(){
		flag = false;
		dp = new DataProcessCho("Account");
		dp.createFile();
		dataLoad();
	}
	
	// 추가
	public void insert() {
		pln("날짜를 입력해주세요");
		String time = day();
		p("수입 / 지출 > "); 	String classify = sc.next();
		p("용도 > "); 		String use = sc.next();
		p("금액 > "); 		int money = sc.nextInt();
		while(true) {
			pln("메모를 입력하시겠습니까? (y/n)"); String choice = sc.next();
			if(choice.equals("y")) {
				p("메모 > ");			String memo = sc.next();
				memo = "메모:"+memo;
				map.put("a"+date(), new AccountDtoCho(time, classify, use, money, memo));
				break;
			}else if(choice.equals("n")) {
				String memo = "";
				map.put("a"+date(), new AccountDtoCho(time, classify, use, money, memo));
				break;
			}else {
				System.out.println("(y/n) 선택가능 .. ");
				continue;
			}
		}
	}
	
	// 수정 -> 금액 용도
	public void update() {
		pln("수정할 날짜를 입력"); 
		String delDay =day();
		boolean flag = false;
		int index = 1;
		Iterator<String> itkey = map.keySet().iterator();
		while(itkey.hasNext()) {
			String key = itkey.next();
			AccountDtoCho val = map.get(key);
			String detes = ""+val;
			String date[] = detes.split(" ");
			if(delDay.equals(date[0])) {
				pln(index+" 데이터 : "+ val);
				index++;
				flag = true;
			}
		}
		if(flag == false ) {
			pln("해당 데이터가 없습니다");
			return;
		}
		String choiceNum;
		p("수정할 데이터 번호 입력 > ");
		String choice = sc.next();
		while(true) {
			p("(1.용도 / 2.금액) 선택 > ");
			choiceNum = sc.next();
			if((!choiceNum.equals("1")) && (!choiceNum.equals("2"))) {
				continue;
			}else {
				break;
			}
		}
		
		index = 1;
		// 수정항목 목록
		p(" 입력 > ");
		String str = sc.next();
		Iterator<String> itkey1 = map.keySet().iterator();
		while (itkey1.hasNext()) {
			String key = itkey1.next();
			AccountDtoCho val = map.get(key);
			String detes = "" + val;
			String date[] = detes.split(" "); // 용도:date[3]
			
			if (delDay.equals(date[0])) {
				key = index + key;
				index++;
				if (key.length() == 21 && key.substring(0, 1).equals(choice)) {
					if (choiceNum.equals("1") && date.length == 5 ) {
						key = key.substring(1);
						int moeny = Integer.parseInt(date[3]);
						map.put(key, new AccountDtoCho(date[0], date[1], str, moeny, date[4]));
						pln("데이터가 수정되었습니다.");
						break;
					}else if(choiceNum.equals("1") && date.length == 4 ) {
						key = key.substring(1);
						int moeny = Integer.parseInt(date[3]);
						map.put(key, new AccountDtoCho(date[0], date[1], str, moeny, ""));
						pln("데이터가 수정되었습니다.");
					} else if (choiceNum.equals("2") && date.length == 5 ) {
						key = key.substring(1);
						int moeny = Integer.parseInt(str);
						map.put(key, new AccountDtoCho(date[0], date[1], date[2], moeny, date[4]));
						pln("데이터가 수정되었습니다.");
						break;
					} else if (choiceNum.equals("2") && date.length == 4 ) {
						key = key.substring(1);
						int moeny = Integer.parseInt(str);
						map.put(key, new AccountDtoCho(date[0], date[1],date[2], moeny,  ""));
						pln("데이터가 수정되었습니다.");
						break;	
					}
				}
			}
		}
	}
		
	// 삭제
	public void delete() {
		// 용도를 물어보고 프린트를 해주고 그중에서 번호를 고르도록....
		pln("삭제할 날짜를 입력"); 
		String delDay = day();
		int index = 1;
		Iterator<String> itkey = map.keySet().iterator();
		while(itkey.hasNext()) {
			String key = itkey.next();
			AccountDtoCho val = map.get(key);
			String detes = ""+val;
			String date[] = detes.split(" ");
			if(delDay.equals(date[0])) {
				pln(index+" 데이터 : "+ val);
				index++;
				flag = true;
			}
		}
		
		if(flag == false ) {
			pln("해당 데이터가 없습니다");
			return;
		}
		
		p("삭제할 데이터 번호 입력 > ");
		String choice = sc.next();
		index = 1;
		Iterator<String> itkey1 = map.keySet().iterator();
		while(itkey1.hasNext()) {
			
			String key = itkey1.next();
			AccountDtoCho val = map.get(key);
			String detes = ""+val;
			String date[] = detes.split(" ");
			if(delDay.equals(date[0])) {
				key = index+key;
				index++;
				if (key.length() == 21 && key.substring(0, 1).equals(choice)) {
					key = key.substring(1);
					map.remove(key);
					pln("데이터가 삭제되었습니다.");
					break;
				}else {
					pln("선택하신 데이터 번호가 존재하지 않습니다.");
					break;
				}
			}
		}
	}
	
	// 검색
	public void search() {
		while(true) {
			pln("1. 날짜별 검색");
			pln("2. 기간별 검색");
			pln("3. 수입/지출별 검색");
			pln("4. memo별 검색");
			pln("menu 선택 > "); int choice = sc.nextInt();
			
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
				pln("menu안에서 선택 가능!!");
				continue;
			}
		}
	}
	
	// 날짜별 검색
	void searchDate() {
		String search = day();
		Iterator<String> itkey = map.keySet().iterator();
		while(itkey.hasNext()) {
			String key = itkey.next();
			AccountDtoCho val = map.get(key);
			String detes = ""+val;
			String date[] = detes.split(" ");
			if(search.equals(date[0])) {
				pln(detes);
				flag = true;
			}
		}
		if(flag == false) {
			pln("데이터가 없습니다.");
			return;
		}
	}
	// 기간별 검색
	void searchDayByDay() {
		pln("검색 시작 날짜 "); String startDay = day();
		pln("검색 마지막 날짜 "); String lastDay = day();
		String start[] = startDay.split("/");
		int startNum = Integer.parseInt(start[0])+Integer.parseInt(start[1])+Integer.parseInt(start[2]);
		String last[] = lastDay.split("/");
		int lastNum = Integer.parseInt(last[0])+Integer.parseInt(last[1])+Integer.parseInt(last[2]);
		
		TreeMap<String, AccountDtoCho> tMap = new TreeMap<String, AccountDtoCho>(map);
		Iterator<String> itkey = tMap.descendingKeySet().iterator();
		while(itkey.hasNext()) {
			String key = itkey.next();
			AccountDtoCho val = (AccountDtoCho) tMap.get(key);
			String detes = ""+val;
			String date[] = detes.split(" ");
			String day[] = date[0].split("/");
			int dayNum = Integer.parseInt(day[0])+Integer.parseInt(day[1])+Integer.parseInt(day[2]);
			if(dayNum >= startNum && lastNum >=dayNum) {
				pln(detes);
				flag = true;
			}
			if(flag == false) {
				pln("데이터가 없습니다.");
				return;
			}
		}
	}

	// 지출/수입별 검색
	void searchClassify() {
		while(true) {
			p("수입/지출 입력 > ");
			String search = sc.next();
			Iterator<String> itkey = map.keySet().iterator();
			while(itkey.hasNext()) {
				String key = itkey.next();
				AccountDtoCho val = map.get(key);
				String detes = ""+val;
				String date[] = detes.split(" ");
				if(search.equals(date[1])) {
					pln(detes);
					flag = true;
				}
			}
			if(flag == false) {
				pln("수입/지출 입력만 입력가능");
				continue;
			}
		}
	}
	// 메모
	void searchMemo() {
		p("memo입력 > ");
		String search = sc.next();
		Iterator<String> itkey = map.keySet().iterator();
		while(itkey.hasNext()) {
			String key = itkey.next();
			AccountDtoCho val = map.get(key);
			String detes = ""+val;
			String date[] = detes.split(" ");
			if(date.length == 5) {
				String memo = date[4].substring(3);
				if(search.equals(memo)) {
				pln(detes);
				flag = true;
				}
			}
		}
		if(flag == false) {
			pln("데이터가 없습니다.");
			return;
		}
	}
	
	// 모든 데이터 출력
	public void allPrint() {
		TreeMap<String, AccountDtoCho> tMap = new TreeMap<String, AccountDtoCho>(map);
		Iterator<String> itkey = tMap.keySet().iterator();
		while(itkey.hasNext()) {
			String key = itkey.next();
			AccountDtoCho val = tMap.get(key);
			System.out.println(val);
		}
	}
	
	// 저장
	public void dataSave() {
		TreeMap<String, AccountDtoCho> datas = new TreeMap<String, AccountDtoCho>(map);
		int len = 0;
		Iterator<String> itkey = datas.keySet().iterator();
		while(itkey.hasNext()) {
			String key = itkey.next();
			AccountDtoCho val = map.get(key);
			datas.put(key, val);
			len++;
		}
		
		if(len == 0) {
			pln("저장할 데이터가 없습니다");
			return;
		}
		dp.fileSave(datas);		
	}
	
	void dataLoad() { //조금 고장남
		try {
			String datas[] = dp.fileLoad();
			String[] data = null;
			for (int i = 0; i < datas.length; i++) {
				data = datas[i].split(",");
				String[] value = data[1].split(" ");
				int momey = Integer.parseInt(value[4]);
				String use = value[3].substring(3);
				if(value.length == 6) {
					map.put(data[0], new AccountDtoCho(value[1], value[2], use, momey, value[5]));
				}else if(value.length == 5){
					map.put(data[0], new AccountDtoCho(value[1], value[2], use, momey, ""));
				}
			}
		}catch(NullPointerException ne) {}
	}
	
	String date() {  // 날짜,시간
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd-HH-mm-ss");
		Date time = new Date();
		String time1 = format1.format(time);
		return time1;
	}
	String day() { // 날짜
		p("년도 > ");
		int year = sc.nextInt();
		// 월
		int month;
		while (true) {
			p("월 > "); month = sc.nextInt();
			if (month >= 1 && month <= 12) {
				break;
			} else {
				pln("월은 1~12까지 입니다.");
				continue;
			}
		}
		// 라스트 일
		int lastDay = 31;
		switch (month) {
		case 2: // 윤년 400으로 나누어 떨어지는 해
				// 평년 4로 나누어 떨어지지만 100으로도 나누어 떨어지는 해
			if ((year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 400 == 0)) {
				lastDay = 29;
			} else {
				lastDay = 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDay = 30;
		}
		// 일
		int day;
		while(true) {
			p("일 > "); day= sc.nextInt();
			if( day > lastDay) {
				pln("해달월은 1~"+lastDay+"일까지 입니다. 다시 입력해주세요.");
				continue;
			}else {
				break;
			}
		}
		String monthStr = ""+month;
		String dayStr = ""+day;
		if(monthStr.length() == 1) {
			monthStr = "0"+monthStr;
		}
		if(dayStr.length() == 1) {
			dayStr = "0"+dayStr;
		}
		String date = year+"/"+monthStr+"/"+dayStr;
		
		return date;
	}
	
	public void p(String str) {
		System.out.print(str);
	}
	public void pln(String str) {
		System.out.println(str);
	}
}
