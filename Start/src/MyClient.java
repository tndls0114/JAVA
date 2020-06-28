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
	int Auto = 0; // (3)�ڵ��÷��� Ȱ��ȭ ����
	int NameSet = 0; // (3)�ڵ��÷��� �� �� �̸��� ã�� ���� ����
	String Me = ""; // (3)�ڵ��÷��� �� �� �̸��� ã�� ���� ����2
	JTextField User; // (2)�÷��̾� �ʵ� �߰�
	int solve = 0;// (3)�ڵ��÷��� �� turn�� roll result �κп��� ������ �� �ذ��ϱ� ���� ����
	String Dice;// (3)�ڵ��÷��̽� roll result �κп��� ���� �����ϱ� ���� ����

	JTextArea[] CarsinoField = new JTextArea[6]; // (1) ī���뺰�� �ʵ带 ����� �ɸ� �ݾ� ǥ��

	public MyClient(String serverIP, int port) {
		createGUI();
		connectToServer(serverIP, port);
//        
	}

	void createGUI() {

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel Player = new JLabel("�÷��̾�"); // (2)�÷��̾� �ʵ� �߰�
		User = new JTextField();

		JLabel label3 = new JLabel("�������������޽����α�:");
		text3 = new JTextArea("", 5, 40);
		text3.append("");

		JLabel[] Carsino = new JLabel[6]; // (1) ī���뺰�� �ʵ带 ����� �ɸ� �ݾ� ǥ��
		for (int i = 0; i < Carsino.length; i++) {
			Carsino[i] = new JLabel((i + 1) + "��° ī����");
			CarsinoField[i] = new JTextArea("", 1, 10);

		}

		JScrollPane scroll = new JScrollPane(text3);

		JPanel subPanel = new JPanel();
		subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.X_AXIS));
		subPanel.add(new JLabel("���: "));
		JTextField tfName = new JTextField();
		subPanel.add(tfName);

		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout(FlowLayout.LEFT));

		JButton btnStart = new JButton("�ٷν���");
		JButton Autoplay = new JButton("�ڵ��÷��� �ѱ�");
		JButton btnRoll = new JButton("�ֻ���������");
		JButton[] number = new JButton[6];

		buttons.add(btnStart);
		buttons.add(btnRoll);

		buttons.add(Autoplay);

		panel.add(Player); // (2)�÷��̾� �ʵ� �߰�
		panel.add(User);

		for (int i = 0; i < number.length; i++) { // (3)��ư�߰��� �ݺ��� �迭�� �����ϰ� ǥ��
			number[i] = new JButton("" + (i + 1));
			buttons.add(number[i]);
		}

		for (int i = 0; i < CarsinoField.length; i++) { // (3)�г��߰��� �ݺ��� �迭�� �����ϰ� ǥ��
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
			number[i].addActionListener(new ActionListener() { // (3)��ư�� �ݺ��� �迭�� �����ϰ� ǥ��

				@Override
				public void actionPerformed(ActionEvent e) {
					sendMessage(Dicenum);

				}
			});
		}

		Autoplay.addActionListener(new ActionListener() { // (3)�ڵ��÷��� ��ư

			@Override
			public void actionPerformed(ActionEvent e) {

				if (Auto == 0) {
					Auto = 1;

					Autoplay.setText("�ڵ��÷��� ����");

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
					Autoplay.setText("�ڵ��÷��� �ѱ�");
					solve = 0;

				}
			}
		}

		);

		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage("start_game");
				btnStart.setText("���ۿϷ�");

			}
		});

		tfName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String cmd = tfName.getText();

				tfName.setText("");
				sendMessage(cmd);
				System.out.println("������ ���� �޽���: " + cmd);

				if (NameSet == 0) { // (3)�ڵ��÷��̸� ���� �� �̸��� ������ �� �ִ� ���� �� �ʱ�ȭ
					Me = cmd;
					NameSet = 1; // 1�� �ʱ�ȭ�����ν� Me�� ���� ���� ������ ����

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
			System.out.println("���� ���� " + socket);

			in = new Scanner(new InputStreamReader(socket.getInputStream(), "utf-8"));
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
		} catch (Exception ex) {
			System.err.println("������ ������ �� �����ϴ�. IP�� port�� Ȯ�����ּ���");
			System.exit(1);
		}

		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						String line = in.nextLine();
						System.out.println("�������� ���� �޽���: " + line);

						text3.append(line + "\n");
						parsing(line);
						text3.setCaretPosition(text3.getDocument().getLength());
					} catch (Exception ex) {
						ex.printStackTrace();
						System.out.println("Receive ������ �����");
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
			String Money = tokens[3];// (1) ī���뺰�� �ʵ带 ����� �ɸ� �� �ݾ� ǥ��
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
				if (Auto == 1) { // (3)���� �ڵ��÷��̰� �������̶�� ������ roll
					sendMessage("roll");
					solve = 0;
				}

			}

			break;

		case "roll_result":

			String[] a = tokens[2].split("@");
			String[] b = a[1].split(",");

			if (a[0].equals(Me)) {// (3)���� �÷��̾� �̸��� �� �̸��� ����
				Dice = b[0]; // �ֻ��� ��� �� ù��° ��
				solve = 2;

				if (Auto == 1) { // �ڵ��÷��̰� �������̶��

					sendMessage(Dice); // Dice�� ������
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
