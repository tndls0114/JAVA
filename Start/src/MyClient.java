import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyClient extends JFrame {
	private Scanner in;
	private PrintWriter out;
	Socket socket;
	JTextArea text3;
	String command;
	int Auto = 0; // (3)자동플레이 활성화 변수
	int NameSet = 0; // (3)자동플레이 시 내 이름을 찾기 위한 변수
	String Me = ""; // (3)자동플레이 시 내 이름을 찾기 위한 변수2
	JTextField User; // (2)플레이어 필드 추가
	int solve = 0;// (3)자동플레이 시 turn과 roll result 부분에서 막혔을 때 해결하기 위한 변수
	String Dice;// (3)자동플레이시 roll result 부분에서 값을 저장하기 위한 변수

	JTextArea[] CarsinoField = new JTextArea[6]; // (1) 카지노별로 필드를 만들고 걸린 금액 표시

	public MyClient(String serverIP, int port) {
		createGUI();
		connectToServer(serverIP, port);
//        
	}

	void createGUI() {

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel Player = new JLabel("플레이어"); // (2)플레이어 필드 추가
		User = new JTextField();

		JLabel label3 = new JLabel("서버에서받은메시지로그:");
		text3 = new JTextArea("", 5, 40);
		text3.append("");

		JLabel[] Carsino = new JLabel[6]; // (1) 카지노별로 필드를 만들고 걸린 금액 표시
		for (int i = 0; i < Carsino.length; i++) {
			Carsino[i] = new JLabel((i + 1) + "번째 카지노");
			CarsinoField[i] = new JTextArea("", 1, 10);

		}

		JScrollPane scroll = new JScrollPane(text3);

		JPanel subPanel = new JPanel();
		subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.X_AXIS));
		subPanel.add(new JLabel("명령: "));
		JTextField tfName = new JTextField();
		subPanel.add(tfName);

		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout(FlowLayout.LEFT));

		JButton btnStart = new JButton("바로시작");
		JButton Autoplay = new JButton("자동플레이 켜기");
		JButton btnRoll = new JButton("주사위던지기");
		JButton[] number = new JButton[6];

		buttons.add(btnStart);
		buttons.add(btnRoll);

		buttons.add(Autoplay);

		panel.add(Player); // (2)플레이어 필드 추가
		panel.add(User);

		for (int i = 0; i < number.length; i++) { // (3)버튼추가는 반복문 배열로 간략하게 표현
			number[i] = new JButton("" + (i + 1));
			buttons.add(number[i]);
		}

		for (int i = 0; i < CarsinoField.length; i++) { // (3)패널추가도 반복문 배열로 간략하게 표현
			panel.add(Carsino[i]);
			panel.add(CarsinoField[i]);
		}

		panel.add(label3);

		panel.add(scroll);
		panel.add(subPanel);

		panel.add(buttons);

		for (int i = 0; i < CarsinoField.length; i++) {
			CarsinoField[i].setAlignmentX(LEFT_ALIGNMENT);
		}
		label3.setAlignmentX(LEFT_ALIGNMENT);
		scroll.setAlignmentX(LEFT_ALIGNMENT);
		subPanel.setAlignmentX(LEFT_ALIGNMENT);
		buttons.setAlignmentX(LEFT_ALIGNMENT);

		add(panel);

		pack();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnRoll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage("roll");

			}
		});
		for (int i = 0; i < number.length; i++) {
			String Dicenum = Integer.toString(i + 1);
			number[i].addActionListener(new ActionListener() { // (3)버튼도 반복문 배열로 간략하게 표현

				@Override
				public void actionPerformed(ActionEvent e) {
					sendMessage(Dicenum);

				}
			});
		}

		Autoplay.addActionListener(new ActionListener() { // (3)자동플레이 버튼

			@Override
			public void actionPerformed(ActionEvent e) {

				if (Auto == 0) {
					Auto = 1;

					Autoplay.setText("자동플레이 끄기");

					switch (solve) {
					case 1:
						sendMessage("roll");
						break;
					case 2:
						sendMessage(Dice);
						break;

					}

				} else if (Auto == 1) {

					Auto = 0;
					Autoplay.setText("자동플레이 켜기");
					solve = 0;

				}
			}
		}

		);

		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage("start_game");
				btnStart.setText("시작완료");

			}
		});

		tfName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String cmd = tfName.getText();

				tfName.setText("");
				sendMessage(cmd);
				System.out.println("서버로 보낸 메시지: " + cmd);

				if (NameSet == 0) { // (3)자동플레이를 위한 내 이름을 저장할 수 있는 변수 값 초기화
					Me = cmd;
					NameSet = 1; // 1로 초기화함으로써 Me의 값을 이제 변하지 않음

				}

			}
		});

		setVisible(true);
	}

	void sendMessage(String str) {
		out.println(str);
	}

	void connectToServer(String serverIP, int port) {
		try {
			socket = new Socket(serverIP, port);
			System.out.println("소켓 정보 " + socket);

			in = new Scanner(new InputStreamReader(socket.getInputStream(), "utf-8"));
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
		} catch (Exception ex) {
			System.err.println("서버에 연결할 수 없습니다. IP와 port를 확인해주세요");
			System.exit(1);
		}

		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						String line = in.nextLine();
						System.out.println("서버에서 받은 메시지: " + line);

						text3.append(line + "\n");
						parsing(line);
						text3.setCaretPosition(text3.getDocument().getLength());
					} catch (Exception ex) {
						ex.printStackTrace();
						System.out.println("Receive 쓰레드 종료됨");
						System.exit(1);
					}
				}
			}
		}.start();
	}

	void parsing(String line) {

		String[] tokens = line.split("&");
		command = tokens[1]; //

		switch (command) {
		case "round_start":
			String Money = tokens[3];// (1) 카지노별로 필드를 만들고 걸린 총 금액 표시
			String[] Bat = Money.split("@");
			User.setText(tokens[2]);

			for (int i = 0; i < Bat.length; i++) {
				String[] all = Bat[i].split(",");
				int sum = 0;
				for (String value : all) {
					sum += Integer.valueOf(value);
				}

				CarsinoField[i].setText("" + sum);
			}

			break;
		case "turn":

			if (tokens[2].equals(Me)) {
				solve = 1;
				if (Auto == 1) { // (3)만약 자동플레이가 실행중이라면 스스로 roll
					sendMessage("roll");
					solve = 0;
				}

			}

			break;

		case "roll_result":

			String[] a = tokens[2].split("@");
			String[] b = a[1].split(",");

			if (a[0].equals(Me)) {// (3)만약 플레이어 이름과 내 이름이 같고
				Dice = b[0]; // 주사위 결과 중 첫번째 값
				solve = 2;

				if (Auto == 1) { // 자동플레이가 실행중이라면

					sendMessage(Dice); // Dice값 보내기
					solve = 0;
				}

			}

			break;

		}
	}

	public static void main(String[] args) {
		MyClient mc = new MyClient("172.30.1.44", 33333);
	}
}
