package main;

import java.util.Scanner;

public class Calculator {
	
	// 멤버변수 -> 2개이상 메소드에서 접근해야할 때 생성
	int num1, num2;
	String oper;
	int result;
	
	// 멤버 메소드
	void input() {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("첫번째 수\t: ");
		num1 = scn.nextInt();
		System.out.print("연산자\t: ");
		oper = scn.next();
		System.out.print("두번째 수\t: ");
		num2 = scn.nextInt();
		
	}
	void process() {
		switch (oper) {
		case "+" :
			result = num1 + num2;
			break;
		case "-" :
			result = num1 - num2;
			break;
		case "*" :
			result = num1 * num2;
			break;
		case "/" :
			result = num1 / num2;
			break;
		}
		
	}
	void print() {
		System.out.println(num1+" "+oper+" "+num2+" = "+result);
	}
}
