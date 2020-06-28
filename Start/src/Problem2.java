import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
 
public class Problem2 extends JFrame{
    public Problem2() {
        setSize(600, 150);
        setLayout(new BorderLayout());
        
        // 북쪽에 입력창 배치
        JTextField input = new JTextField("객체, 지향, 프로그래밍"); //초깃값
        add(input, BorderLayout.NORTH);
        
        // 센터에 출력용 JTextArea배치
        JTextArea output = new JTextArea();
        add(output, BorderLayout.CENTER);
 
        // 남쪽에 버튼 배치
        JButton button = new JButton("버튼");
        add(button, BorderLayout.SOUTH);
        
        // 버튼 이벤트 설정
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String[] Comma = input.getText().split(",");
               String Coma = Comma[1];
               output.setText("" + Coma);
                
            }
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Problem2();
    }
}
