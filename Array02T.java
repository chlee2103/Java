package function;

public class Array02T {
	public static void main(String[] args) {
		int[][] arr = { // **arr == arr[][]
				{ 5, 5, 0, 5, 5, 5 }, 
				{ 10, 10, 10, 10, 10 }, 
				{ 20, 20, 20, 20, 20 }, 
				{ 30, 30, 30, 30, 30 } };
		int total = 0;
		float avg = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				total = total + arr[i][j];

			}
		}
		avg = (float) total / (arr.length * arr[0].length);
		System.out.println("total : " + total);
		System.out.println("average : " + avg);
	}
}
