package java3;

import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n; // 사용자로부터 입력받을 값 선언

		Scanner sc = new Scanner(System.in); // 스캐너 호출

		// 무한반복코드
		while (true) {
			int i = 1;
			System.out.println("원하는 단을 입력하세요 : "); // 메시지출력
			n = sc.nextInt(); // 사용자로부터 값 입력받기
			if(n==0) {
				break;
			}
			while (i <= 9) {
				System.out.println(n + "*" + i + "=" + n * i); // 값 출력
				i++; // i에 1 더함
			}

		}

	}

}
