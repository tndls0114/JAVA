package java01;

import java.util.Scanner;

public class box {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("가로길이를 입력하세요");
		double w=sc.nextDouble();
		
	    System.out.println("세로길이를 입력하세요");
	    double h=sc.nextDouble();
	    
	    double area = w*h;
	    double perimeter=2*(w+h);
	    
	    System.out.println("사각형의 넓이:"+area+"사각형의 둘레:"+perimeter);
	
	}

}
