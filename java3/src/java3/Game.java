package java3;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 59;
		int guess;
		int tries = 0;
		Scanner sc = new Scanner(System.in);
		
		do {
			guess = sc.nextInt();
				 if(guess>answer) {
					 System.out.println("정답보다 큽니다");
				 }
				  if(guess<answer) {
					  System.out.println("정답보다 작습니다");
					 
				 }
				 tries++;
		}while(guess!=answer);
		System.out.println("정답입니다.시도 횟수는"+tries);
	
	}

}
