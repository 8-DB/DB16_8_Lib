import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class bannap extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	bannap() {
		setTitle("��������");
		
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("ȸ�� ���� ���������� �Է��ϼ���");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(25, 10, 229, 23);
		contentPane.add(title);
		
		JLabel pname = new JLabel("ȸ������");
		pname.setBounds(25, 48, 57, 15);
		contentPane.add(pname);
		
		JLabel bname = new JLabel("��������");
		bname.setBounds(25, 73, 57, 15);
		contentPane.add(bname);
		
		textField = new JTextField();
		textField.setBounds(83, 45, 172, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(83, 73, 172, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton serch = new JButton("�˻�");
		serch.setBounds(25, 113, 76, 44);
		contentPane.add(serch);
		
		JButton restore = new JButton("�����ݳ�");
		restore.setBounds(113, 112, 142, 44);
		contentPane.add(restore);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(25, 182, 229, 137);
		contentPane.add(textArea);
		
		setVisible(true);
	}

}