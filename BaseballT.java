package main;

import java.util.Scanner;

public class BaseballT {
	// 멤버변수 -> 2군데 이상 접근시 만들어 준다
	int r_num[], u_num[];
	boolean clear;
	
	// 멤버메소드
	// 초기화
	void init() {
		r_num = new int[3];
		u_num = new int[3];
		clear = false;
		
		my_random(); // 1번만 사용할거라서 !
	}
	// 랜덤값 설정
	void my_random() { 
		// 객체지향은 초기화 할 필요 X - 초기값 flase
		// 절차지향은 초기화 필요!!
		boolean swit[] = new boolean[10];
		
		int w, r;
		w = 0;
		while (w < 3) {
			r = (int) (Math.random() * 10);// 0~9
			if (swit[r] == false) {
				swit[r] = true;
				r_num[w] = r + 1; // 1~10
				w++;
			}
		}
	}
	// 유저입력
	void user_input() {
		Scanner scn = new Scanner(System.in);
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
		// user 입력
		int w = 0;

		while (w < 10) {
			user_input();
			// 비교 -> 탈출
			// 스트라이크, 볼
			int strike, ball;
			strike = 0;
			ball = 0;

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
			// 맞췄을 경우
			if (strike > 2) {
				clear = true;
				break;
			}
			// 메세지 출력
			System.out.println(strike + "스트라이크" + ball + "볼입니다.");
			w++;
		}
	}
	// 결과
	void result() {
		if (clear) {
			System.out.println("Game Clear!!!");
		} else {
			System.out.println("Game Over~");
		}
	}
}
