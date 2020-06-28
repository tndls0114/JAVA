package finalexam;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FinalExamQuiz extends JFrame {
	public FinalExamQuiz() {
		setSize(650, 415);
		setLayout(new BorderLayout());

		// ù��: �м��� �޽��� �Է��� ��

		JTextField input = new JTextField("server&roll_result&ȫ�浿@1,2,3,3,4,1,2,6");
		add(input, BorderLayout.NORTH);

		// �ι�° ��: �ؼ��� �޽��� ���� ����� ��
		JTextArea output = new JTextArea("�ؼ��� ���� ����� ��");
		add(output, BorderLayout.CENTER);

		JPanel dicePannel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(dicePannel, BoxLayout.Y_AXIS);
		dicePannel.setLayout(boxlayout);
		add(dicePannel, BorderLayout.EAST);

		// �¿쿡 ��ư
		JPanel buttonPanel = new JPanel();
		JButton buttonCheck = new JButton("�м�");
		JButton buttonSort = new JButton("����");
		buttonPanel.add(buttonCheck);
		buttonPanel.add(buttonSort);
		add(buttonPanel, BorderLayout.SOUTH);

		buttonCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] Dice1 = input.getText().split("@");
				String[] Dice2 = Dice1[1].split(",");
				output.setText("�ֻ��� ���� : " + Dice1[1]);
				int count=0;
				for(int i=0;i<Dice2.length;i++) {
					count++;
				}
				output.append("�ֻ��� ���� : "+count);
				
				

				}
			
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new FinalExamQuiz();
	}
}
