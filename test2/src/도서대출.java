import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class �������� extends JFrame {
	JdbcB289075 jdbc;
	JLabel label1, la1, la2;
	JTextField ����;
	JTextField ����;
	JPanel idPanel, paPanel, loginPanel;
	JButton b1, b2;
	JTextArea content;
	int updateRow;
	private boolean check;

	public ��������() {
		super("book ����");
		setLayout(new FlowLayout());
		label1 = new JLabel("ȸ������ �� �������� �Է��� �ּ���");

		// 1��
		idPanel = new JPanel();
		la1 = new JLabel("ȸ������");
		���� = new JTextField(10);
		idPanel.add(la1);
		idPanel.add(����);

		// 2��
		paPanel = new JPanel();
		la2 = new JLabel("��������");
		���� = new JTextField(10); // ȭ�� ������ �����ش�.
		paPanel.add(la2);
		paPanel.add(����);

		// 3��
		loginPanel = new JPanel();
		b1 = new JButton("��������");
		b2 = new JButton("����");
		loginPanel.add(b1);
		loginPanel.add(b2);

		add(label1);
		add(idPanel);
		add(paPanel);
		add(loginPanel);

		// // ������ Text ����
		// content = new JTextArea(3, 20);
		// content.setLineWrap(true); // �ڵ� �ٹٲ�
		// JScrollPane s = new JScrollPane(content); // ��ũ�� �߰�
		// add(s);
		setLocation(600, 300);
		setSize(250, 350);
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);

		jdbc = new JdbcB289075(new JschB289075(53306));

		showButton();

	}

	private void showButton() {
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String client = ����.getText();
				String book = ����.getText();
//				if (jdbc.getDBCheck(Query.isClient(client))
//						&& jdbc.getDBCheck(Query.isBook(book))
//						&& jdbc.getDatabase(Query.insert����(client, book)))
				if (jdbc.getDatabase(Query.insert����(client, book)))
					JOptionPane.showMessageDialog(null, "����");
				else
					JOptionPane.showMessageDialog(null, "����");
				// INSERT INTO ���� (`����Ⱓ`,`ȸ����ȣ`) VALUES (CURDATE()+2,(SELECT
				// `ȸ����ȣ` FROM ȸ�� WHERE `�̸�`="���ϸ�"),());
			}
		});
	}

	private static String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public class Menu extends JPanel {
		JMenuBar menubar;
		JMenu file, sort, info;
		JMenuItem file_open, file_save, proinfo;
		JCheckBoxMenuItem name, imformation;

		Menu() {
			menubar = new JMenuBar();
			file = new JMenu("����");
			sort = new JMenu("����");
			info = new JMenu("����");

			file_open = new JMenuItem("���� �ҷ�����");
			file_save = new JMenuItem("���� ���");
			proinfo = new JMenuItem("����");

			name = new JCheckBoxMenuItem("�̸�");
			imformation = new JCheckBoxMenuItem("��������");

			menubar.add(file);
			menubar.add(sort);
			menubar.add(info);
			file.add(file_open);
			file.add(file_save);
			info.add(proinfo);
			sort.add(name);
			sort.add(imformation);
		}

	}

}