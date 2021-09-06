package singletonAccount;

import java.util.Iterator;
import java.util.Scanner;

import bt210521.Ex01.AccountDtoCho;

public class Updateclass {

	/*
	  다시다시다시다시
	 */
	public void process() {
		Singletonclass si = Singletonclass.getInstence();
		UtilPclass up = new UtilPclass();
		UtilTimaclass ut = new UtilTimaclass();
		Scanner sc = new Scanner(System.in);
		
		boolean flag = false;
		up.pln("수정할 날짜를 입력"); 
		String day =ut.day();
		
		int index = 1;
		Iterator<String> itkey = si.map.keySet().iterator();
		while(itkey.hasNext()) {
			String key = itkey.next();
			AccountDtoCho val = si.map.get(key);
			if(day.equals(val.getDateTime())) {
				up.pln(index+" 데이터 : "+ val);
				index++;
				flag = true;
			}
		}
		
		if(flag == false ) {
			up.pln("해당 데이터가 없습니다");
			return;
		}
		
		String choiceNum;
		up.p("수정할 데이터 번호 입력 > ");
		String choice = sc.next();
		
		while(true) {
			up.p("(1.용도 / 2.금액) 선택 > ");
			choiceNum = sc.next();
			if((!choiceNum.equals("1")) && (!choiceNum.equals("2"))) {
				continue;
			}else {
				break;
			}
		}
		
		index = 1;
		// 수정항목 목록
		up.p(" 입력 > ");
		String str = sc.next();
		Iterator<String> itkey1 = si.map.keySet().iterator();
		while (itkey1.hasNext()) {
			String key = itkey1.next();
			AccountDtoCho val = si.map.get(key);
			
			if (day.equals(val.getDateTime())) {
				key = index + key;
				index++;
				if (key.length() == 20 && key.substring(0, 1).equals(choice)) {
					if (choiceNum.equals("1")) {
						key = key.substring(1);
						val.setUse(str);
						break;
					}else if(choiceNum.equals("2")) {
						key = key.substring(1);
						int money = Integer.parseInt(str);
						val.setMoney(money);
						break;
					}
				}
			}
		}
		up.pln("데이터가 수정되었습니다.");
	}
}
