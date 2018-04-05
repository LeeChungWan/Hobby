package chat.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import chat.server.ServerGui;

public class ClientGui extends JFrame implements ActionListener {
	private JTextArea jta = new JTextArea(40, 25);
	private JTextField jtf = new JTextField(25);
	private static ClientBackgound client = new ClientBackgound();
	private static String nickName ;

	public ClientGui() {
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(800, 100, 400, 600);
		setTitle("ȸ�� �̸� : " + nickName);

		client.setGui(this); // gui�� clientBackground ����
		client.setNickName(nickName);
		client.connet();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("����� �̸��� �Է��ϼ��� : ");
		nickName = sc.next();
		sc.close();
		new ClientGui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = jtf.getText() + "\n";
		jta.append(nickName + ": " + msg);
		client.sendMessage(msg);
		jtf.setText("");
	}

	public void appendMsg(String msg) {
		jta.append(msg);
	}

}
