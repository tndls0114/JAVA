package java01;

import java.util.Scanner;

public class FC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("È­¾¾¿Âµµ¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
		
		double F = sc.nextDouble();
		double C = 5*(F-32)/9;
		
		
		System.out.println("È­¾¾¿Âµµ´Â"+F+"¼·¾¾¿Âµµ´Â"+C);
		
		sc.close();
		
	}

}
