package singletonAccount;

import java.util.Iterator;

import bt210521.Ex01.AccountDtoCho;

public class UtilDaySearch {

	public boolean DaySearch(String day) {
		
		Singletonclass si = Singletonclass.getInstence();
		UtilPclass up = new UtilPclass();
		UtilTimaclass ut = new UtilTimaclass();
		
		
		boolean flag = false;
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
		return flag;
	}
}
