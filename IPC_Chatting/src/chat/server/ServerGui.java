package chat.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ServerGui extends JFrame implements ActionListener {

	private JTextArea jta = new JTextArea(40, 25);
	private JTextField jtf = new JTextField(25);
	
	public JTextArea getJta() {
		return jta;
	}

	public void setJta(JTextArea jta) {
		this.jta = jta;
	}

	// ����
	private ServerBackground server = new ServerBackground();

	public ServerGui() {
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		jta.append("������ ä�ù��� ��������ϴ�.\n");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(800, 100, 400, 600);
		setTitle("�����κ�");

		server.setGui(this); // gui�� ServerBackground ����
		server.setting();
	}

	public static void main(String[] args) {
		new ServerGui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = "����: " + jtf.getText() + "\n";
		jta.append(msg);
		server.sendMessage(msg);
		jtf.setText("");
	}

	public void appendMsg(String msg) {
		jta.append(msg);
	}

}
