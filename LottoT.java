// 셔플
public class LottoT {
	public static void main(String[] args) {
		
		boolean swit[] = new boolean[45];
		int lotto[] = new int [30];
		
		int w, r;
		
		swit[0] = true; // 1번은 나오지 않는다.
		
		w = 0;
		while(w < 30) {
			r = (int)(Math.random()*45);
			if(swit[r] == false) {
				swit[r] = true;
				lotto[w] = r+1;
				w++;
			}
		}
		for(int i =0; i < lotto.length; i++) {
			System.out.print(lotto[i]+ "\t");
			if((i+1) % 6 == 0) { // 개행
				System.out.println();
			}
		}
	}
}
/*
  source code 작성
  
  compile -> 기계어로 번역		debug != error
  link -> exe파일			정상적으로 돌아가는지 확인하는 작업
  execute
  
 */
