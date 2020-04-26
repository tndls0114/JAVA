package java3;

import java.util.*;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long fact=1;
		int n;
		
		System.out.println("정수를 입력하시오");
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			fact=fact*i;
		}
		System.out.println(n+"!는"+fact+"입니다");
		
	}

}
