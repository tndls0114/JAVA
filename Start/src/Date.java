import java.util.Scanner;

class Data {
	String year;
	String month;
	String day;

	void print1() {
		System.out.println(year + "." + month + "." + day);
	}

	void print2() {
		int a = new Integer(month);
		switch (a) {

		case 1:
			month = "January";

			break;
		case 2:
			month = "February";

			break;

		case 3:
			month = "March";

			break;

		case 4:
			month = "April";

			break;
		case 5:
			month = "May";

			break;
		case 6:
			month = "June";

			break;
		case 7:
			month = "July";

			break;
		case 8:
			month = "August";

			break;
		case 9:
			month = "September";

			break;
		case 10:
			month = "October";

			break;
		case 11:
			month = "November";

			break;
		case 12:
			month = "December";
			break;

		}
		System.out.println(month + " " + day + ", " + year);

	}

}

public class Date {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("연도, 월, 일을 입력하시오");
		Data e=new Data();
		e.year=sc.next();
		e.month=sc.next();
		e.day=sc.next();
		
		e.print1();
		e.print2();
		
		
	}

}
