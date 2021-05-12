package sortingFunc;

import java.util.Scanner;

public class SortingFuncS {
	public static void main(String[] args) {
		int number[];
		boolean updown[] = new boolean[1];
		
		//1.입력
		number = number_input(updown);
		//2.정렬
		sorting(number,updown[0]);
		// 3.결과출력
		resultPrint(number,updown[0]);

	}
	static int [] number_input(boolean[] updown) {
		Scanner sc = new Scanner(System.in);
		
		// 1.입력
		// 1) 몇개를 정렬?
		System.out.print("정렬할 숫자의 갯수 >> ");
		int count = sc.nextInt();
		updown[0] = false;
		// 2) 입력받은 갯수에 맞게 숫자들을 입력 ->
		int[] number = new int[count];
		for (int i = 0; i < number.length; i++) {
			System.out.print((i + 1) + "번째 수 = ");
			number[i] = sc.nextInt();
		}

		// 3) 오름/내림
		System.out.print("오름(1)/내림(2) >> ");
		int ud = sc.nextInt();
		if (ud == 1) {
			updown[0] = true;
		}
		return number;
	}
	static void sorting(int number[], boolean updown) {
		for(int i = 0; i<number.length-1; i++) {
	         for(int j=i+1; j<number.length; j++) {
	            if(updown == true) {
	               if(number[i]>number[j]) {
	                  swap(number, i, j);
	               }
	            }else {
	               if(number[i]<number[j]) {
	            	   swap(number, i, j);
	               }
	            }
	         }
	      }
	}
	static void swap(int number[], int i, int j) {
		int temp = number[i];
        number[i] = number[j];
        number[j] = temp;
	}
	static void resultPrint(int number[], boolean updown) {
		 String msg="";
	      if(updown) msg = "오름차순 정렬입니다.";
	      else msg = "내림차순 정렬입니다.";
	      System.out.println(msg);
	      
	      for(int i=0; i<number.length; i++) {
	         System.out.println("number["+i+"]="+number[i]);
	      }
	}
}
