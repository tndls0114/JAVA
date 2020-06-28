

public class Dat {
	public static void printDate() {
		System.out.println(year+"."+month+"."+day);
	}
	
	public static int getDay() {
		return day;
		
	}

	 private static int year;
	private static String month;
	private static int day;
	
	public static void main(String[] args) {
		year = 2020;
		month="6";
		day=28;
		printDate();
		getDay();

	}

}
