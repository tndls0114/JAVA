package java02;

import java.util.Scanner;

public class Metropolice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
boolean isCapital;
int citizens;
int riches;

Scanner sc = new Scanner(System.in);
System.out.println("�����Դϱ�?(����:1,�����ƴ�:0)");
isCapital = (sc.nextInt()==1)?true:false;
		System.out.println("�α�(����:�鸸)");
		citizens = sc.nextInt();
		System.out.println("������ ��(����:�鸸)");
		riches = sc.nextInt();
		
		boolean isMetro = (isCapital&&citizens >= 1)||(riches>=0.5);
		System.out.println("��Ʈ�������� ����" +  isMetro);
				


		
	}

}
