package java02;

import java.util.Scanner;

public class Divide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
System.out.println("정수를 입력하시오");
int a = sc.nextInt();
System.out.println("정수를 입력하시오");
int b = sc.nextInt();

int c = (a>=b)?a/b:b/a;
int d = (a>=b)?a%b:b%a;

System.out.println(a+"를"+b+"로 나눈 몫은"+c+"이고"+"나머지는"+d+"입니다");

	}

}
