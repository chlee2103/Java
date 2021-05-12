package calculatorFunc;

import java.util.Scanner;

public class CalculatorS {
	public static void main(String[] args) {
		
		int num1 = 0, num2 = 0;
		String oper = null;
		
		// 첫번째 수 입력
		num1 = input(num1);
		// 연산자를 입력
		oper = oper(oper);
		// 두번째 수 입력 / + 0 무시
		num2 = input(num2);
		// 연산
		output(num1, num2, oper);
		// 결과 출력
		
	}
	// 첫번째 수 입력
	static int input(int num) {
		Scanner scn = new Scanner(System.in);
		String str = "";
		while(true) {
			System.out.print("숫자 입력 > ");
			str = scn.nextLine();
			// 공백확인
			if(str.equals("")== true) {
				System.out.println("숫자만 입력가능(공백x)");
				continue;
			}
			boolean flag = true;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if(c < '0' || c > '9') { // 문자열 확인
					flag = false;
					break;
				}
			}
			if(flag == true) {
				break;
			}
			System.out.println("숫자만 입력가능(문자x)");
		}
		num = Integer.parseInt(str);
		return num;
	}
	
	// 연산자를 입력
	static String oper(String oper) {
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.print("연산기호 입력 (+, -, *, /) >>");
			oper = scn.nextLine();
			if(oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/")) {
				break;				
			} else { 		// 연산기호가 다른문자가 입력이 되었는지? -> 다시 입력
				continue;
			}
		}
		return oper;
	}
	// 연산

	static void output(int num1, int num2, String oper) {
		// 결과출력
		switch(oper) {
		case "+" :
			System.out.println(num1+oper+num2+"="+(num1+num2));
			break;
		case "-" :
			System.out.println(num1+oper+num2+"="+(num1-num2));
			break;
		case "*" :
			System.out.println(num1+oper+num2+"="+(num1*num2));
			break;
		case "/" :
			System.out.println(num1+oper+num2+"="+(num1/num2));
			break;
		}
	
	}

}
