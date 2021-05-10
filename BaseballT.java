import java.util.Scanner;

public class BaseballT {
	public static void main(String[] args) {
		/*
		Baseball
		
		random(1 ~10) -> 3개
		r1 != r2 != r3
		
		10번 기회
		input >> 1 2 3
		
		replay? yes/no
				
	*/
		
		// random 할당
		Scanner scn = new Scanner(System.in);
		
		int r_num[] = new int[3];
		int u_num[] = new int[3];
		boolean clear = false;
		int w;
		
		while(true) {
			r_num[0] = (int)(Math.random()*10)+1;
			r_num[1] = (int)(Math.random()*10)+1;
			r_num[2] = (int)(Math.random()*10)+1;
			
			if(r_num[0] != r_num[1]
					&& r_num[1] != r_num[2]
							&& r_num[0] != r_num[2]) {
				break;
			}
		}
		for(int i=0; i<r_num.length; i++) {
			System.out.println("r_num["+i+"] : " + r_num[i]);
		}

		
		////////////////////////////////  loop
		w = 0;
		
		while(w<10) {
		// user 입력
		while(true) {
			for(int i=0; i<u_num.length; i++) {
				System.out.print((i + 1)+"번째 수 >> ");
				u_num[i] = scn.nextInt();
				}
				if(u_num[0] != u_num[1]
						&& u_num[1] != u_num[2]
								&& u_num[0] != u_num[2]) {
					break;
				}
				System.out.println("같은 숫자를 입력하셨습니다. 다시 입력해 주세요.");
			}
			
			// 비교							-> 탈출
			// 스트라이크, 볼
			int strike, ball;
			strike = 0;
			ball = 0;
			
			// ball
			for(int i=0; i< r_num.length; i++) {	// 0 1 2
				for (int j=0; j<u_num.length; j++) {// 0 1 2
					if(u_num[i] == r_num[j] && i != j) {
						ball++;
					}
				}
			}
			// strike
			for(int i=0; i< r_num.length; i++) {
				if(u_num[i] == r_num[i]) {
					strike++;
				}
			}
		// 맞췄을 경우
			if(strike > 2) {
				clear = true;
				break;
			}
		// 메세지 출력
			System.out.println(strike + "스트라이크"+ ball +"볼입니다.");
			w++;
		}
		////////////////////////////////
		
		// 결과출력
		if(clear) {
			System.out.println("Game Clear!!!");
		}else {
			System.out.println("Game Over~");
		}
		
	}
}
