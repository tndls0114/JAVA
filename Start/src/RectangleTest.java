import java.util.Scanner;

class Rectangle{
	int w;
	int h;
	
	void area() {
		System.out.println("�簢���� ���̴� "+ (w*h));
	}
	void parameter() {
		System.out.println("������� �ѷ��� "+ (2*(w+h)));
	}
	
	
	
	
}


public class RectangleTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("���ο� ������ ���� �Է��Ͻÿ�");
		
		Rectangle r=new Rectangle();
		r.w=sc.nextInt();
		r.h=sc.nextInt();
		r.area();
		r.parameter();
		
		

	}

}
