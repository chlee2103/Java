package singletonAccount;

import java.util.Scanner;

public class UtilTimaclass {
	
	String day() { // 날짜
		Scanner sc = new Scanner(System.in);
		UtilPclass up = new UtilPclass();
		up.p("년도 > ");
		int year = sc.nextInt();
		// 월
		int month;
		while (true) {
			up.p("월 > "); month = sc.nextInt();
			if (month >= 1 && month <= 12) {
				break;
			} else {
				up.pln("월은 1~12까지 입니다.");
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
			up.p("일 > "); day= sc.nextInt();
			if( day > lastDay) {
				up.pln("해달월은 1~"+lastDay+"일까지 입니다. 다시 입력해주세요.");
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
}
