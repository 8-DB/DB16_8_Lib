import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class result extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	
	public result() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		setVisible(true);
		create();
		
	}
	void create() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton dae = new JButton("����");
		dae.setBounds(70, 93, 139, 54);
		contentPane.add(dae);
		dae.addActionListener(this);
		
		JButton ban = new JButton("�ݳ�");
		ban.setBounds(70, 219, 139, 54);
		contentPane.add(ban);
		ban.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "�ݳ�") {
			new bannap();
		}
		if(e.getActionCommand() == "����") {
			new ��������();
		}
	}

}