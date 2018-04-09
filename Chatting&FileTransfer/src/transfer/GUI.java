package transfer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.Button;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField input_text;
	private JTextField file_name;
	private JTextField transfer_bar;
	private JTextField text_src_addr;
	private JTextField text_dst_addr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		JLabel label_chatting = new JLabel("채팅");
		label_chatting.setBounds(12, 10, 36, 20);
		
		JTextArea chatting_area = new JTextArea();
		chatting_area.setBounds(22, 40, 472, 261);
		
		input_text = new JTextField();
		input_text.setBounds(24, 317, 356, 21);
		input_text.setColumns(10);
		
		JButton btn_text_transfer = new JButton("전송(F)");
		btn_text_transfer.setBounds(381, 316, 107, 23);
		
		JLabel label_file = new JLabel("파일전송");
		label_file.setBounds(12, 348, 57, 15);
		
		file_name = new JTextField();
		file_name.setBounds(22, 373, 358, 21);
		file_name.setColumns(10);
		
		transfer_bar = new JTextField();
		transfer_bar.setBounds(22, 404, 358, 21);
		transfer_bar.setEditable(false);
		transfer_bar.setColumns(10);
		
		JButton btn_file = new JButton("파일 찾기(O)");
		btn_file.setBounds(381, 372, 107, 23);
		
		JButton btn_file_transfer = new JButton("전송(F)");
		btn_file_transfer.setBounds(381, 403, 107, 23);
		
		JLabel label_setting = new JLabel("설정");
		label_setting.setBounds(510, 13, 57, 15);
		
		JLabel label_NIC = new JLabel("NIC 선택");
		label_NIC.setBounds(510, 38, 57, 15);
		
		Choice choice_NIC = new Choice();
		choice_NIC.setBounds(510, 60, 264, 21);
		
		text_src_addr = new JTextField();
		text_src_addr.setBounds(510, 115, 264, 21);
		text_src_addr.setColumns(10);
		
		JLabel label_dst_addr = new JLabel("목적지 주소");
		label_dst_addr.setBounds(510, 146, 80, 15);
		
		text_dst_addr = new JTextField();
		text_dst_addr.setBounds(510, 171, 264, 21);
		text_dst_addr.setColumns(10);
		
		JLabel label_src_addr = new JLabel("시작 주소");
		label_src_addr.setBounds(510, 86, 57, 15);
		
		Button btn_reset = new Button("재설정(R)");
		btn_reset.setBounds(605, 248, 76, 23);
		
		Button btn_set = new Button("설정(S)");
		btn_set.setBounds(605, 217, 76, 23);
		contentPane.setLayout(null);
		contentPane.add(label_chatting);
		contentPane.add(chatting_area);
		contentPane.add(input_text);
		contentPane.add(btn_text_transfer);
		contentPane.add(label_file);
		contentPane.add(file_name);
		contentPane.add(transfer_bar);
		contentPane.add(btn_file);
		contentPane.add(btn_file_transfer);
		contentPane.add(label_setting);
		contentPane.add(label_NIC);
		contentPane.add(choice_NIC);
		contentPane.add(text_src_addr);
		contentPane.add(label_dst_addr);
		contentPane.add(text_dst_addr);
		contentPane.add(label_src_addr);
		contentPane.add(btn_reset);
		contentPane.add(btn_set);
	}
}
