package java02;

import java.util.Scanner;

public class Divide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
System.out.println("������ �Է��Ͻÿ�");
int a = sc.nextInt();
System.out.println("������ �Է��Ͻÿ�");
int b = sc.nextInt();

int c = (a>=b)?a/b:b/a;
int d = (a>=b)?a%b:b%a;

System.out.println(a+"��"+b+"�� ���� ����"+c+"�̰�"+"��������"+d+"�Դϴ�");

	}

}
