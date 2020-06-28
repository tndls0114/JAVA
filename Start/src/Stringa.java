import java.util.Scanner;

public class Stringa {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("문자열을 입력하시오 : ");
		String a=sc.next();
		
		String b="";
		for(int i=a.length();i>0;i--) {
			b+=a.charAt((i-1));
			
		}
		
		System.out.println(b);

	}

}
