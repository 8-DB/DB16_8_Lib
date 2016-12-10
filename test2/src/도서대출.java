import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class 도서대출 extends JFrame {
	JdbcB289075 jdbc;
	JLabel label1, la1, la2;
	JTextField 대출;
	JTextField 도서;
	JPanel idPanel, paPanel, loginPanel;
	JButton b1, b2;
	JTextArea content;
	int updateRow;
	private boolean check;

	public 도서대출() {
		super("book 대출");
		setLayout(new FlowLayout());
		label1 = new JLabel("회원정보 및 도서정보 입력해 주세요");

		// 1행
		idPanel = new JPanel();
		la1 = new JLabel("회원정보");
		대출 = new JTextField(10);
		idPanel.add(la1);
		idPanel.add(대출);

		// 2행
		paPanel = new JPanel();
		la2 = new JLabel("도서정보");
		도서 = new JTextField(10); // 화면 노출을 막아준다.
		paPanel.add(la2);
		paPanel.add(도서);

		// 3행
		loginPanel = new JPanel();
		b1 = new JButton("도서대출");
		b2 = new JButton("예약");
		loginPanel.add(b1);
		loginPanel.add(b2);

		add(label1);
		add(idPanel);
		add(paPanel);
		add(loginPanel);

		// // 마지막 Text 상자
		// content = new JTextArea(3, 20);
		// content.setLineWrap(true); // 자동 줄바꿈
		// JScrollPane s = new JScrollPane(content); // 스크롤 추가
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
				String client = 대출.getText();
				String book = 도서.getText();
//				if (jdbc.getDBCheck(Query.isClient(client))
//						&& jdbc.getDBCheck(Query.isBook(book))
//						&& jdbc.getDatabase(Query.insert대출(client, book)))
				if (jdbc.getDatabase(Query.insert대출(client, book)))
					JOptionPane.showMessageDialog(null, "성공");
				else
					JOptionPane.showMessageDialog(null, "실패");
				// INSERT INTO 대출 (`대출기간`,`회원번호`) VALUES (CURDATE()+2,(SELECT
				// `회원번호` FROM 회원 WHERE `이름`="김일리"),());
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
			file = new JMenu("정보");
			sort = new JMenu("정렬");
			info = new JMenu("도움말");

			file_open = new JMenuItem("정보 불러오기");
			file_save = new JMenuItem("정보 기억");
			proinfo = new JMenuItem("정보");

			name = new JCheckBoxMenuItem("이름");
			imformation = new JCheckBoxMenuItem("도서정보");

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