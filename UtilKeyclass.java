package singletonAccount;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilKeyclass {
	
	public String date() {  // 날짜,시간
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd-HH-mm-ss");
		Date time = new Date();
		String time1 = format1.format(time);
		return time1;
	}
}
