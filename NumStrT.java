import java.util.Scanner;

public class NumStrT {
	public static void main(String[] args) {
	
		Scanner scn = new Scanner(System.in);
		String numStr;
		
		System.out.println("숫자입력 = ");
		numStr = scn.next();
		
	//	for(int i=0; i<numStr.length(); i++) {
	//		char c = numStr.charAt(i);
	//		System.out.println("c = "+c);
	//	}
		
		boolean b = true;
		for(int i=0; i<numStr.length(); i++) {
			char c = numStr.charAt(i);
	
	//	System.out.println("c = "+c);
	//	System.out.println("c(asc) = "+ (int)c);
			int asc = (int)c;	
			if(asc < 48 || 57 < asc) { //asc가 48보다 작거나 asc가 57보다 크면
				b = false;
				break;
			}
		}
		if(b== true) {
		System.out.println("모두 숫자로 되어있습니다.");
		}else {
			System.out.println("숫자가 아닌 문자가 있습니다.");
		}
	}
}

