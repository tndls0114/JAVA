package java4;

import java.util.Scanner;

public class Pi2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("¹Ýº¹È½¼ö :");
		int b=sc.nextInt();
		double sum=3;
		
		for(int i=1;i<=b-1;i++) {
			double a;
			if(i%2==1) {
				a=4.0/((2*i)*(2*i+1)*(2*i+2));
			}else {
				a=-4.0/((2*i)*(2*i+1)*(2*i+2));
			}
			sum=sum+a;
		}
System.out.println(sum);
	}

}
