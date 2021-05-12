package function;

public class Arrat04T {
	public static void main(String[] args) {
		// a ~ z
		char[] abcCode = { '`', '~', '!', '@', '#', '$', '%', '^', '&', 
						   '*', '(', ')', '-', '_', '+', '=', '|', '[',
						   ']', '{', '}', ';', ':', ',', '.', '/' };
		// 0 ~ 9
		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
		String src = "abc123";
		String result = "";
		// 문자열 src의 문자를 charAt()으로 하나씩 읽어서 변환 후 result에 저장
		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i);
			int asc = (int)ch;
			
			// 알파벳인 경우
			if(asc >= 97 && asc <= 122) { // 97~122 - 97 => 0~25
				asc = asc - 97;
				result = result + abcCode[asc];
			}
			// 숫자인 경우
			if(asc >= 48 && asc <= 57) {
				asc = asc - 48;
				result = result + numCode[asc];
			}
		}
		System.out.println("원본\t: " + src);
		System.out.println("암호화\t: " + result);
		
		// 복호화
		String originalCode = "";
		for (int i = 0; i < result.length(); i++) {
			char ch = result.charAt(i);
			int asc = (int)ch;
			
			// 암호	   원본
			// 알파벳	-> 숫자
			int index = 0;
			if(asc >= 97 && asc <= 122) {
				for (int j = 0; j < numCode.length; j++) {
					if(ch == numCode[j]) {  // ch == 'w' == 1
						index = j;			// 저장
						break;				// 찾으면 탈출해라
					}
				}
				index = index + 48; // 숫자에 해당하는 ASCII코드 값으로 설정
				originalCode =  originalCode + (char)index; // 아스키 코드값을 문자로 변경 후 추가
			// 기호	-> 알파벳	
			}else {
				for (int j = 0; j < abcCode.length; j++) {
					if(ch == abcCode[j]) {
						index = j;
						break;
					}
				}
				index = index + 97;
				originalCode =  originalCode + (char)index;
			}
		}
		System.out.println("복호화\t: "+originalCode);
	}
}
