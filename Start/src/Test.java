class MyString{
	String a="Hello world";
	
	void toUpperCase() {
		System.out.println(a.toUpperCase());
		
	}
	
	void concat() {
		System.out.println(a.concat(""));
	}
	
	void reverse() {
		String b="";
		for(int i=a.length();i>0;i--) {
			b+=a.charAt((i-1));
			
		}
		System.out.println(b);
	}
	
	
	
}


public class Test {

	public static void main(String[] args) {
		MyString c=new MyString();
		c.toUpperCase();
		c.concat();
		c.reverse();

	}

}
