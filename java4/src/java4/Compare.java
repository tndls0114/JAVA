package java4;
import java.util.Scanner;
public class Compare {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("정수를 입력하시오");
		int a=sc.nextInt();
		System.out.print("정수를 입력하시오");
		int b=sc.nextInt();
		System.out.print("정수를 입력하시오");
		int c=sc.nextInt();
		
		if(a>b) {
			if(b>c) {
				System.out.println(c+" "+b+" "+a);
			}else {
				if(a>c) {
					System.out.println(b+" "+c+" "+a);
				}else {
					System.out.println(b+" "+a+" "+c);
				}
			}
				
			}else {
				if(a>c) {
				System.out.println(c+" "+a+" "+b);
			}else {
				if(b>c) {
					System.out.println(a+" "+c+" "+b);
				}else {
					System.out.println(a+" "+b+" "+c);
				}
			}
				
					
				}
			}
				
	}


