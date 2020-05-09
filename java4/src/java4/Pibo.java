package java4;
import java.util.Scanner;
public class Pibo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int b=sc.nextInt();
		int a=0;
		int c=1;
		int d=0;
		
		if(b==1) {
			System.out.println(a);
		}else {
			if(b==2) {
				System.out.println(c);
			}else {
		
		for(int i=1;i<=b;i++) {
			d=a+c;
			a=c;
			c=d;
			
		}
		System.out.println(d);
	}

}
}
}