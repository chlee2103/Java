package main;

import java.util.Scanner;

public class Baseball {
	Scanner scn = new Scanner(System.in);
	// 멤버변수 -> 2군데 이상 접근시 만들어 준다
	int r_num[], u_num[];
	boolean clear;
	
	
	// 맴버메소드
	
	// 초기화
	void input() {
		System.out.print("비교할 숫자 갯수 > ");
		int num = scn.nextInt();
		r_num = new int[num];
		u_num = new int[num];
	}
	
	// 랜덤값 설정
	void randomNum() {
		boolean swit[] = new boolean[10];
		clear = false;
		for(int i=0; i<swit.length; i++) {
			swit[i] = false;
		}
		
		int w, r;
		w = 0;
		while(w < 3) {
			r = (int)(Math.random()*9);// 0~8
			if(swit[r] == false) {
				swit[r] = true;
				r_num[w] = r + 1;  // 1~9
				w++;
			}
		}
		for(int i=0; i<r_num.length; i++) {
			System.out.print(r_num[i]+ " ");
		}
		System.out.println();
	}
	// 유저입력
	void userNum() {
		while (true) {
			for (int i = 0; i < u_num.length; i++) {
				System.out.print((i + 1) + "번째 수 >> ");
				u_num[i] = scn.nextInt();
				
			}
			if (u_num[0] != u_num[1] && u_num[1] != u_num[2] && u_num[0] != u_num[2]) {
				break;
			}
			System.out.println("같은 숫자를 입력하셨습니다. 다시 입력해 주세요.");
		}
	}

	// loop
	void loop() {
		int strike = 0;
		int ball = 0;
	    int	w = 0;
		while (w < 10) {
			userNum();
			compare(strike,ball);

			if (strike > 2) {
				clear = true;
				break;
			}
			w++;
		}
	}
	
	// 비교판정
	void compare(int strike, int ball) {
		// 스트라이크, 볼


		// ball
		for (int i = 0; i < r_num.length; i++) { // 0 1 2
			for (int j = 0; j < u_num.length; j++) {// 0 1 2
				if (u_num[i] == r_num[j] && i != j) {
					ball++;
				}
			}
		}

		// strike
		for (int i = 0; i < r_num.length; i++) {
			if (u_num[i] == r_num[i]) {
				strike++;
			}
		}
	}
	// 메세지 출력
	void message(int strike, int ball) {
		System.out.println(strike + "스트라이크"+ ball +"볼입니다.");
	}
	// 결과
	void result() {
		if(clear) {
			System.out.println("Game Clear!!!");
		}else {
			System.out.println("Game Over~");
		}
	}
}
