package function;

public class MainClass {
	public static void main(String[] args) {
		/*
		 	function: 함수, 독립체
		 	method 	: == 함수. class 소속함수.
		 	
		 	어셈블리어
		 	Unix  	--발전---> Linux
		 	c언어	-> 절차지향, 속도빠르다, 가독성X == 노가다 pointer (new)
		 			   C++ <-- c언어 class
		 			   int *array = new int[5];
		 			   array[0] = 11;
		 			   *array = 11;
		 			   
		 	java	-> 객체지향
		 			   int array[] = new int[5];
		 			   array[0] = 11;
		 	
		 	형식 : 
		 		return값은 자료형 함수명( 인수,인자,parameter,매개변수 ){
		 			
		 			// 처리
		 			 
		 			 return 돌려주는 값(=return value); 
		 		}
		 		
		 		parameter	-> 대입할 변수명
		 		argument	-> 대입할 실제값
		 */
		funcName();
		funcName1( 7 );	// 3 == argument
		int returnValue = funcName3(123.456f);
		System.out.println("returnValue : " + returnValue);
		
		int num = 3; // 값만 넘어간다
		int arr[] = { 1, 2, 3 }; // 자기자신(주소)이 넘어간다. (1,2,3이 pointer)
		
		funcName4(num, arr);
		System.out.println("num : "+ num);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr["+i+"] : " + arr[i]);
		}
		
		double d = funcName5();
		System.out.println("d : "+ d);
		
		double r = Math.random();
		
		String numStr = "123.456";
		boolean flag = isDouble(numStr);
		if(flag) {
			System.out.println("이 문자열은 소수입니다.");
		}else {
			System.out.println("이 문자열은 정수입니다.");
		}
		
		int num1, num2;
		int result, tag[];	// 몫, 나머지
		
		num1 = 3;
		num2 = 2;
		tag = new int[1];
		
		// 조건 : 몫, 나머지를 구할 수 있는 함수를 작성(하나만 작성)
		result = func(num1, num2, tag);
		System.out.println("몫 : " + result + ", 나머지 : " + tag[0]);
		
	}
	
	static int func(int n1, int n2, int[]t) {
		int r;
		r = n1 / n2;
		t[0] = n1 % n2;
		
		return r;
	}
	
		static void funcName() {
			System.out.println("funcName()호출");
		}
		
		static void funcName1(int i) { // i == 가(상)인수 () == parameter
			System.out.println("funcName1(int i)호출 = " + i);
		}
		
		static void funcName2(int i, char c, int[] arr) { 
			System.out.println("funcName2(int i) 호출 = " + i +", "+ c);
		}
		
		static int funcName3(float f) {
			System.out.println("funcName3(float f) 호출 = "+ f);
			return (int)f;
		}
		
		static String stringClean(String str ) { // 영문, 숫자
			return str;
		}
		//					  들어오는값  나오는값
		// 					  value할당 address할당(reference==참조)
		static void funcName4(int num, int arr[]) {
			num = num * 10;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = arr[i] * 10;
			}
		}
		
		static double funcName5() {
			System.out.println("funcName5(float f) 호출 = ");
			
			// 초기화 처리
			
			return 123.456;
		}
		
		// 문자열 -> 모두 숫자로 되어 있는지?
		// 		-> 정수? 소수?
		static boolean isDouble(String snum) { // .4444, 4444., 44.44.4(생각해보기)
			boolean flag = false;
			for (int i = 0; i < snum.length(); i++) {
				char c = snum.charAt(i);
				if(c == '.') {
					flag = true;
					break;
				}
			}
			return flag;
		}
		
		// 알파벳	  -> 입력
		// return -> ascii
		static int charToAscii(char c) {
			return (int)c;
		}
		
		// 숫자	  -> 입력
		// return -> 알파벳
		static char asciiToChar(int asc) {
			return (char)asc;
		}
}

