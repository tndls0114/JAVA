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

		// 첫줄: 분석할 메시지 입력할 곳

		JTextField input = new JTextField("server&roll_result&홍길동@1,2,3,3,4,1,2,6");
		add(input, BorderLayout.NORTH);

		// 두번째 줄: 해석한 메시지 내용 출력할 곳
		JTextArea output = new JTextArea("해석한 내용 출력할 곳");
		add(output, BorderLayout.CENTER);

		JPanel dicePannel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(dicePannel, BoxLayout.Y_AXIS);
		dicePannel.setLayout(boxlayout);
		add(dicePannel, BorderLayout.EAST);

		// 좌우에 버튼
		JPanel buttonPanel = new JPanel();
		JButton buttonCheck = new JButton("분석");
		JButton buttonSort = new JButton("정렬");
		buttonPanel.add(buttonCheck);
		buttonPanel.add(buttonSort);
		add(buttonPanel, BorderLayout.SOUTH);

		buttonCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] Dice1 = input.getText().split("@");
				String[] Dice2 = Dice1[1].split(",");
				output.setText("주사위 내용 : " + Dice1[1]);
				int count=0;
				for(int i=0;i<Dice2.length;i++) {
					count++;
				}
				output.append("주사위 개수 : "+count);
				
				

				}
			
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new FinalExamQuiz();
	}
}
