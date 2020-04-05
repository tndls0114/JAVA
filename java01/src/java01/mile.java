package java01;

import java.util.Scanner;

public class mile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		double a = sc.nextDouble();
		double b = a*1.609;
		
		System.out.println(a+"마일은"+b+"킬로미터입니다");
		sc.close();
	}

}
