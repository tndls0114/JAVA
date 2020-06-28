import java.util.Scanner;

public class Id {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("아이디를 입력하시오");
		String a="a";
		String b=sc.next();
		
		if(a.equals(b)) {
			System.out.println("아이디가 맞습니다");
		}else {
			System.out.println("틀린 아이디입니다.");
		}
		
		
	}

}
