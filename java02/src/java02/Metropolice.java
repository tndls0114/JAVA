package java02;

import java.util.Scanner;

public class Metropolice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
boolean isCapital;
int citizens;
int riches;

Scanner sc = new Scanner(System.in);
System.out.println("수도입니까?(수도:1,수도아님:0)");
isCapital = (sc.nextInt()==1)?true:false;
		System.out.println("인구(단위:백만)");
		citizens = sc.nextInt();
		System.out.println("부자의 수(단위:백만)");
		riches = sc.nextInt();
		
		boolean isMetro = (isCapital&&citizens >= 1)||(riches>=0.5);
		System.out.println("메트로폴리스 여부" +  isMetro);
				


		
	}

}
