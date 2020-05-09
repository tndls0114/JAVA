package java4;

import java.util.Scanner;

public class Gre {

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int b=sc.nextInt();
		double sum=0;
		for(int i=1;i<=b;i++) {
			double a;
			
			if(i%2==0) {
				a=-4.0/(2*i-1);
			}else {
				a=4.0/(2*i-1);
			}
			sum=sum+a;
			
			}
		System.out.println(sum);
		
			
		}
		
	}

