package java01;

import java.util.Scanner;

public class FC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ȭ���µ��� �Է��ϼ���");
		
		double F = sc.nextDouble();
		double C = 5*(F-32)/9;
		
		
		System.out.println("ȭ���µ���"+F+"�����µ���"+C);
		
		sc.close();
		
	}

}
