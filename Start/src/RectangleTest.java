import java.util.Scanner;

class Rectangle{
	int w;
	int h;
	
	void area() {
		System.out.println("사각형의 넓이는 "+ (w*h));
	}
	void parameter() {
		System.out.println("사격형의 둘레는 "+ (2*(w+h)));
	}
	
	
	
	
}


public class RectangleTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("가로와 세로의 값을 입력하시오");
		
		Rectangle r=new Rectangle();
		r.w=sc.nextInt();
		r.h=sc.nextInt();
		r.area();
		r.parameter();
		
		

	}

}
