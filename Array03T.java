package function;

public class Array03T {
	public static void main(String[] args) {
		// 큰 금액의 동전을 우선적으로 거슬러 줘야 한다.
		int[] coinUnit = {1000,500, 100, 50, 10};
		int money = 2680;
		System.out.println("money\t: "+ money + "원");
		for (int i = 0; i < coinUnit.length; i++) {
			int count = money / coinUnit[i];	
			// 			2680  / 500
			System.out.println(coinUnit[i]+"원\t: "+ count+"개");
			money = money % coinUnit[i];	// 180
		}
		

	}
}
