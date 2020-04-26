package java3;

public class ContinueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="no news is good news";
		int n=0;
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!='n') {
				continue;
			}
			n++;
		
			
		}
		System.out.println("n의 개수는"+n);
	}

}
