package java3;

import java.util.Scanner;

public class Pi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		double sum=0;
		int b=sc.nextInt();
		for(int i=1;i<=b;i++) {
			double a;
			if(i%2==0){
				a=4/(-2*i+1); 
				System.out.println("분모는"+ (-2*i+1));
				System.out.println("i는" + i+"a는"+a);
				
			}else {
				a=4/(2*i-1);
				System.out.println("분모는"+ (2*i-1));
				System.out.println("i는" + i+"a는"+a);
			}
			
			sum=sum+a;
			
			
		}
		System.out.println(sum);
		
		
		float z;
		z=4.0/3.0;
		
		
		System.out.println(z);
	}

}
