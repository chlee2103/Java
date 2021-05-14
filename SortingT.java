package main;

import java.util.Scanner;

public class SortingT {
	// 전역변수 - 어디서든 접근가능!!, 매개변수로 지정 필요 X!!!!
	int number[]; // sorting을 해야될 변수
	boolean updown; 
	
	// 루프형 변수는 전역으로 잡을 필요 없다! 지역에서 잡아라! ex) int i, int j
	void input() {
		Scanner sc = new Scanner(System.in);

		updown = false;

		// TODO:1. 입력
		// 1) 몇개를 정렬?
		System.out.print("정렬할 숫자의 갯수 >> ");
		int count = sc.nextInt();

		// 2) 입력받은 갯수에 맞게 숫자들을 입력 ->
		int number[] = new int[count];
		for (int i = 0; i < number.length; i++) {
			System.out.print((i + 1) + "번째 수 = ");
			number[i] = sc.nextInt();
		}

		// 3) 오름/내림
		System.out.print("오름(1)/내림(2) = ");
		int ud = sc.nextInt();
		if (ud == 1) {
			updown = true;
		}
	}
	
	void sorting() {
		for (int i = 0; i < number.length - 1; i++) {
			for (int j = i + 1; j < number.length; j++) {
				if(updown == true) {
					if(number[i] > number[j]) {
						swap(i, j);
					}
				}else {
					if(number[i] < number[j]) {
						swap(i, j);
					}
				}	
			}
		}
	}

	 void swap(int i, int j) {
		int temp = number[i];
		number[i] = number[j];
		number[j] = temp;
	}

	
	void print() {
		String msg = "";
		if(updown) msg = "오름차순 정렬입니다";
		else		msg = "내림차순 정렬입니다";			
		System.out.println(msg);
		
		for (int i = 0; i < number.length; i++) {
			System.out.println("number[" + i + "] = " + number[i]);
		}
	}
}
