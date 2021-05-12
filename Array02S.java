package function;

public class Array02S {
	public static void main(String[] args) {
		int[][] arr = {
				{5,5,5,5,5},
				{10,10,10,10,10},
				{20,20,20,20,20},
				{30,30,30,30,30}
		};
		int total = 0;
		float avg = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
				avg = (float)total/(arr.length*arr[i].length);
			}
		}
		System.out.println("total : " + total);
		System.out.println("average : " + avg);
	}
}
/* 
	실행결과
total = 325
avg = 16.25
*/