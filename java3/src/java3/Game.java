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
					 System.out.println("���亸�� Ů�ϴ�");
				 }
				  if(guess<answer) {
					  System.out.println("���亸�� �۽��ϴ�");
					 
				 }
				 tries++;
		}while(guess!=answer);
		System.out.println("�����Դϴ�.�õ� Ƚ����"+tries);
	
	}

}
