package function;
/*
	거스름돈을 몇개의 동전으로 지불 할 수 있는지 계산
	변수 money의 금액을 동전으로 바꾸었을 때 각각 몇개의 동전이 필요한지 계산 후 출력
	단, 가능한 적은 수의 동전을 거슬러 주어야 한다.
*/
public class Array03S {
	public static void main(String[] args) {
		// 큰 금액의 동전을 우선적으로 거슬러 줘야 한다.
		int[] coinUnit = {500, 100, 50, 10};
		int money = 2680;
		System.out.println("money\t: "+ money + "원");
		for (int i = 0; i < coinUnit.length; i++) {
			if(money/coinUnit[i] > 0) {
				System.out.println(coinUnit[i]+"원\t: "+ money / coinUnit[i] + "개");
				money %= coinUnit[i];
			}
		}
	}
}
