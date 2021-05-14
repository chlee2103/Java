package overroad;



public class Overroad {
	public static void main(String[] args) {
		/*
		 	Over load : 함수(method)명은 같고
		 			  	매개변수(parameter)의 자료형이나 인자의 갯수가 다른것을 의미
		 			  	
		 	print();
		 	print(int x, int y);
		 	print(int x, int y, int alpha);
		 	print(char c, int y);
		 */
		
		method();
		
		method('a');
		
		method(1);
		
		method('b', 2);
		method(2, 'b');
		
		int s = sum(1,2,3,4,5);
		System.out.println(s);
		s = sum(10,20,30,40,50);
		System.out.println(s);
		
		double a = avg(3, 20, 25, 30);
		System.out.println(a);
	}
	
	static void method() {
		System.out.println("MainClass method()");
	}
	
//	static int method() {	// 리턴값이 다른건 오버로드 불가
//		System.out.println("MainClass method()");
//		return 1;
//	}
	
	static void method(char c) {
		System.out.println("MainClass method(char c)");
	}
	
	static void method(int i) {
		System.out.println("MainClass method(int i)");
	}
	
	static void method(char c, int i) {
		System.out.println("MainClass method(char c, int i)");
	}
	static void method(int i, char c) { // 매게변수의 순서만 달라도 오버로드 가능
		System.out.println("MainClass method(int i, char c)");
	}
//	static void method(int j, char c) { // 가인수 명이 다른건 오버로드 불가
//		System.out.println("MainClass method(int i, char c)");
//	}
	
	// 가변인수
	static int sum(int...num) { // <- 인자의 개수 변형 가능
		int s = 0;
		for(int i =0; i<num.length; i++) {
			s += num[i];
		}
		return s;
	}
	
	static double avg(int count, int ...num) {  // 가변인수는 맨 끝으로 설정해야 된다
		int s = 0;
		for(int i =0; i<num.length; i++) {
			s += num[i];
		}
		double a = s / count;
		
		return a;
	}
}
