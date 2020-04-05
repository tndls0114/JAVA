package java01;

import java.util.Scanner;

public class Salary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int salary;
		int deposit;
		
		Scanner input= new Scanner(System.in);
		
		System.out.println("월급을 입력하시오: ");
		salary=input.nextInt();
		
		deposit = 10*12*salary;
		System.out.printf("10년동안의 저축액:%d\n",deposit);
		
	}

}
