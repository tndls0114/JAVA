package person;

import java.util.Scanner;
public class Tex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int income;
		int tax;
		System.out.println("���� ǥ�� �ݾ��� �Է��Ͻÿ�:");
		Scanner input = new Scanner(System.in);
		income = input.nextInt();
		if(income<=1000) 
			tax = (int) (0.09*income);
		else
		     if ( income<=4000)
			tax = (int) (0.18*income);
		     else
		        if (income<8000)
			tax = (int) (0.27*income);
		        else 
		        	tax = (int) (0.36*income);
		System.out.println("�ҵ漼��"+tax+"�Դϴ�");
		 

	}

}
