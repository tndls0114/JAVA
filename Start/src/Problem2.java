import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
 
public class Problem2 extends JFrame{
    public Problem2() {
        setSize(600, 150);
        setLayout(new BorderLayout());
        
        // ���ʿ� �Է�â ��ġ
        JTextField input = new JTextField("��ü, ����, ���α׷���"); //�ʱ갪
        add(input, BorderLayout.NORTH);
        
        // ���Ϳ� ��¿� JTextArea��ġ
        JTextArea output = new JTextArea();
        add(output, BorderLayout.CENTER);
 
        // ���ʿ� ��ư ��ġ
        JButton button = new JButton("��ư");
        add(button, BorderLayout.SOUTH);
        
        // ��ư �̺�Ʈ ����
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
