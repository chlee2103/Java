package function;

public class MethodTest {
	public static void main(String[] args) {
		int num1, num2;
		int result, tag[];	// 몫, 나머지
		
		
		num1 = 5;
		num2 = 3;
		tag = new int [1];
		
		
		result = m(num1 , num2 , tag);
		System.out.println("몫 : " + result + ", 나머지 : " + tag[0]);
		
		// 조건 : 몫, 나머지를 구할 수 있는 함수를 작성(하나만 작성)
		
	}
	static int m(int num1, int num2 , int tag[] ) {
		int r = num1/num2;
		tag[0] = num1%num2; 
		return r ;
	}
}
