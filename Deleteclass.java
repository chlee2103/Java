package singletonAccount;

import java.util.Iterator;
import java.util.Scanner;

import bt210521.Ex01.AccountDtoCho;

public class Deleteclass {
	

	
	
	public void process() {
		Singletonclass si = Singletonclass.getInstence();
		UtilPclass up = new UtilPclass();
		UtilTimaclass ut = new UtilTimaclass();
		Scanner sc = new Scanner(System.in);
		
		
		boolean flag = false;
		up.pln("삭제할 날짜를 입력"); 
		String day = ut.day();;
		
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
		up.p("삭제할 데이터 번호 입력 > ");
		String choice = sc.next();
		index = 1;
		Iterator<String> itkey1 = si.map.keySet().iterator();
		while(itkey1.hasNext()) {
			String key = itkey1.next();
			AccountDtoCho val = si.map.get(key);
			if(day.equals(val.getDateTime())) {
				key = index+key;
				index++;
				if (key.length() == 20 && key.substring(0, 1).equals(choice)) {
					key = key.substring(1);
					si.map.remove(key);
					up.pln("데이터가 삭제되었습니다.");
					break;
				}else {
					up.pln("선택하신 데이터 번호가 존재하지 않습니다.");
					break;
				}
			}
		}
		if(flag == false ) {
			up.pln("해당 데이터가 없습니다");
			return;
		}
	}
}
