package calculatorFunc;

import java.util.Scanner;

public class CalculatorT {
	public static void main(String[] args) {
		int num1, num2;
		String oper;
		
		// 첫번째 수 입력
		num1 = number_input("첫번째");
		// 연산자를 입력
		oper = operatorInput();
		// 두번째 수 입력 / + 0 무시
		num2 = number_input("두번째");
		// 연산
		int result = processing(num1, num2, oper);
		// 결과 출력
		resultPrint(num1, num2, result, oper);
	}
	// 입력 함수들
	static int number_input(String no) {
		
		Scanner scn = new Scanner(System.in);
		String str = "";
		while(true) {
			System.out.print(no + "수 > ");
			str = scn.nextLine();
			// 공백확인
			if(str.equals("")== true) {
				System.out.println("숫자만 입력가능(공백x)");
				continue;
			}
//			boolean flag = true;
//			for (int i = 0; i < str.length(); i++) {
//				char c = str.charAt(i);
//				if(c < '0' || c > '9') { // 문자열 확인
//					flag = false;
//					break;
//				}
//			}
			boolean flag = isNumber(str);
			if(flag == true) {
				break;
			}
			System.out.println("숫자만 입력가능(문자x)");
		}
		return Integer.parseInt(str);
	}
	
	static String operatorInput() {
		// 연산자
		Scanner scn = new Scanner(System.in);
		String oper;
		while (true) {
			System.out.print("연산기호 입력 (+, -, *, /) >>");
			oper = scn.nextLine();
			if (oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/")) {
				break;
			} else { // 연산기호가 다른문자가 입력이 되었는지? -> 다시 입력
				continue;
			}
		}
		return oper;
	}
	// 유틸리티 함수 -> 다른곳에서도 사용가능!
	static boolean isNumber(String str) {
		boolean flag = true;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c < '0' || c > '9') { // 문자열 확인
				flag = false;
				break;
			}
		}
		return flag;
	}
	// 연산처리 함수
	static int processing(int n1, int n2, String oper) {
		int result = 0;
		switch(oper) {
		case "+" :
			result = n1+n2;
			break;
		case "-" :
			result = n1-n2;
			break;
		case "*" :
			result = n1*n2;
			break;
		case "/" :
			if(n2 == 0) {
				System.out.println("'0'은 연산불가!");
			}else {
				result = n1/n2;
				break;
			}
		}
		return result;
	}
	// 결과 출력
	static void resultPrint(int n1, int n2, int result, String oper) {
		System.out.println(n1 +" "+oper+" "+n2+" = "+ result);
	}
	
}
