import java.util.Scanner;

public class UpDown {
	public static void main(String[] args) {
		// 1 ~100까지 숫자 찾기 게임! 기회는 단 10회!
		Scanner scn = new Scanner(System.in);
		int temp = 0;
		int count = 0;
		boolean clear = false;
		
		int comNum = (int)(Math.random()*100)+1;
		
		while(count<10) {
			System.out.print("user : ");
			int userNum = scn.nextInt();

			if(comNum > userNum ) {
				temp = 1;
			}else if (comNum < userNum) {
				temp = 2;
			} else {
				break;
			}
			
			switch(temp) {
			case 1 :
				System.out.println("UP!");
				break;
			case 2 :
				System.out.println("DOWN!");
				break;
			}
			count++;
		}
		if(clear == true) {
			System.out.println("Congratulations! Game Clear!!!");
		} else {
			System.out.println("GameOver~~~");
		}
	}
}
