package java3;

import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n; // ����ڷκ��� �Է¹��� �� ����

		Scanner sc = new Scanner(System.in); // ��ĳ�� ȣ��

		// ���ѹݺ��ڵ�
		while (true) {
			int i = 1;
			System.out.println("���ϴ� ���� �Է��ϼ��� : "); // �޽������
			n = sc.nextInt(); // ����ڷκ��� �� �Է¹ޱ�
			if(n==0) {
				break;
			}
			while (i <= 9) {
				System.out.println(n + "*" + i + "=" + n * i); // �� ���
				i++; // i�� 1 ����
			}

		}

	}

}
