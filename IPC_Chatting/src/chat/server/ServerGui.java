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

	// 연동
	private ServerBackground server = new ServerBackground();

	public ServerGui() {
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		jta.append("서버가 채팅방을 만들었습니다.\n");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(800, 100, 400, 600);
		setTitle("서버부분");

		server.setGui(this); // gui와 ServerBackground 연동
		server.setting();
	}

	public static void main(String[] args) {
		new ServerGui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = "서버: " + jtf.getText() + "\n";
		jta.append(msg);
		server.sendMessage(msg);
		jtf.setText("");
	}

	public void appendMsg(String msg) {
		jta.append(msg);
	}

}
