package java01;

import java.util.Scanner;

public class rectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("반지름을 입력하세요");
		double a = sc.nextDouble();
		
	    double b = 4*a*a*a/3;
	    
	    System.out.println(b);
	    sc.close();
	    
	    }

}
