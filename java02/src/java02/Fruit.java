package person;
import java.util.Scanner;
public class Fruit {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		Scanner input = new Scanner(System.in);
		int fruit;
		System.out.println("������ �Է��Ͻÿ� : ");
		fruit = input.nextInt();
		
		switch(fruit) {
		case 1: System.out.println("���");
		break;
		case 2 : System.out.println("��");
		
		case 3 : System.out.println("�ٳ���");
		break;
		default: System.out.println("����");
		
		}
	}

}
