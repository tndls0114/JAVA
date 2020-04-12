package java02;

import java.util.Scanner;

public class AD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
System.out.println("X의 값을 입력하세요");
int a = sc.nextInt();
int b = (a<=0)?a*a*a-9*a+2:7*a+2;
System.out.println(b);

	}

}
