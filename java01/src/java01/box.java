package java01;

import java.util.Scanner;

public class box {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("���α��̸� �Է��ϼ���");
		double w=sc.nextDouble();
		
	    System.out.println("���α��̸� �Է��ϼ���");
	    double h=sc.nextDouble();
	    
	    double area = w*h;
	    double perimeter=2*(w+h);
	    
	    System.out.println("�簢���� ����:"+area+"�簢���� �ѷ�:"+perimeter);
	
	}

}
