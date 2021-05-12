package sortingFunc;

import java.util.Scanner;

public class SortingFuncT {
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
	/*
	 	int funcname(외부로부터 들어 가는 값){
	 	
	 		내부
	 	}
	 	외부로 나오는 값 = funcname()
	 */
	
	static int [] number_input(boolean[] updown) { // 배열을 리턴해야함
		Scanner scn = new Scanner(System.in);
		updown[0] = false;
		
		// TODO : 1.입력
		System.out.print("정렬할 숫자의 갯수 >> ");
		int list = scn.nextInt();
		int[] number = new int[list];
	    for (int i = 0; i < number.length; i++) {
	    	System.out.print((i+1)+"번째 수 = ");
			number[i] = scn.nextInt();
		}	
		System.out.print("오름(1)/내림(2) >> ");
	      int ud = scn.nextInt();
	      if(ud == 1) {
		         updown[0] = true;
		      }
		return number;
	}
	// TODO : 2.정렬
	static void sorting(int number[], boolean updown) {
		for(int i = 0; i<number.length-1; i++) {
	         for(int j=i+1; j<number.length; j++) {
	            if(updown == true) {
	               if(number[i]>number[j]) {
	            	   swap(number, i,j);
	               }
	            }else {
	               if(number[i]<number[j]) {
	            	   swap(number, i,j);
	               }
	            }
	        }
		}
	}
	//	swap
	static void swap(int number[], int i, int j) { // 매개변수 생각
		 int temp = number[i];
         number[i] = number[j];
         number[j] = temp;
	}
	// TODO : 3.결과 출력
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