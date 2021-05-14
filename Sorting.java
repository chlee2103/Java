package main;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
	int[] arr;
	boolean updown = false;

	void input() {
		Scanner scn = new Scanner(System.in);
		System.out.print("정렬갯수 > ");
		int line = scn.nextInt();
		arr = new int[line];

		for (int i = 0; i < arr.length; i++) {
			System.out.print((i + 1) + "번째 숫자를 입력 > ");
			int num = scn.nextInt();
			arr[i] = num;
		}
		System.out.println(Arrays.toString(arr));

		while (true) {
			System.out.println("정렬 순서를 정하세요 : 1.오름 2.내림");
			int order = scn.nextInt();
			if (order == 1) {
				updown = true;
				break;
			} else if (order == 2) {
				updown = false;
				break;
			}
		}
	}

	void sort() {
		int temp;
		if (updown == true) {
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[i] > arr[j]) {
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		} else if (updown == false) { // 내림차순
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[i] < arr[j]) {
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
	}

	void print() {
		System.out.println(Arrays.toString(arr));
	}
}

/*	모델링
 	Sorting
 * 
 	- number[] : int
 	- updown : boolean
 * 
 	void input()
 	void sorting()
 	void swap(int, int)
 	void print
 */

 	
