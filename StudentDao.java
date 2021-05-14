package main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
// DAO + DTO = model
// Create Read Update Delete : 추가 읽기 검색 삭제
// Data Access Object : 데이터 접근 객체(데이터를 다를 수 있는 object) 
public class StudentDao {
	// 객체배열 생성
	Student arrSt[] = new Student[20];
	Student St = new Student();
	int count;
	
	void init() {
		count = 0;
		
	}
	void create() {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.println("학생추가 ---- >");
		System.out.print("이름:");
		String name = sc.next();
		
		System.out.print("국어:");
		int kor = sc.nextInt();
		
		System.out.print("영어:");
		int eng = sc.nextInt();
		
		System.out.print("수학:");
		int math = sc.nextInt();
		
		Student st = new Student();
		st.name = name;
		st.kor = kor;
		st.eng = eng;
		st.math = math;
		
		arrSt[count] = st;
		count++;
	}
	void allSum() {
		int sum = 0;
		for (int i = 0; i < count; i++) {
				sum += arrSt[i].kor;
				sum += arrSt[i].eng; 
				sum += arrSt[i].math;
		}
		System.out.println("합계:" + sum);
	}
	void allavg() {
		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum += arrSt[i].kor;
			sum += arrSt[i].eng; 
			sum += arrSt[i].math;
	}
		double avg = (double)sum / count;
		
		System.out.println("평균:" + avg);
	}
	
	void korMax() {
		int max = 0;
		int index = 0;
		for (int i = 0; i < count; i++) {
			if(max < arrSt[i].kor) {
				max = arrSt[i].kor;
				index = i;
			}
		}
				
		System.out.println("국어의 최고점수:" + max);
		System.out.println("국어의 1등은 " + arrSt[index].name + "입니다");
	
	}
	
	void mathMin() {
		int min = 100;
		int index = 0;
		for (int i = 0; i < count; i++) {
			if(min > arrSt[i].math) {
				min = arrSt[i].math;
				index = i;
			}
		}
				
		System.out.println("수학 최하점수:" + min);
		System.out.println("수학 꼴찌는 " + arrSt[index].name + "입니다");
		
	}
	
	void allprint() {
		for (int i = 0; i < count; i++) {
			System.out.println("이름 : "+arrSt[i].name+", 국어 : "+arrSt[i].kor+", 영어 : "+arrSt[i].eng+", 수학 : "+arrSt[i].math);
		}		 
	}
	
	void studentTop() {
		// 수석 구하기
		
		// 원본 복사용
		Student list[] = new Student[count];
		// 총점용
		int aSum[] = new int[count];
		
		for (int i = 0; i < list.length; i++) {
		//	if(arrSt[i] != null) {
				list[i] = new Student();
				
				list[i].name = arrSt[i].name;
				list[i].kor = arrSt[i].kor;
				list[i].eng = arrSt[i].eng;
				list[i].math = arrSt[i].math;
				
				aSum[i] = list[i].kor + list[i].eng + list[i].math;
		//	}
		}
		Student temp;
		for (int i = 0; i < aSum.length - 1; i++) {
			for (int j = i + 1; j < aSum.length; j++) {
				if(aSum[i] < aSum[j]) {
					temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}			
		}

		
		for (int j = 0; j < aSum.length; j++) {
			System.out.println((j+1)+"등은 : "+list[j].name+"입니다");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}





















