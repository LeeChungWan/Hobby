package transfer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField input_text;
	private JTextField file_name;
	private JTextField transfer_bar;
	private JTextField text_src_addr;
	private JTextField text_dst_addr;
	private Button btn_set;
	private Button btn_reset;
	private Choice choice_NIC;
	
	// Layer ���� ����.
	static NILayer m_NiLayer;
	static EthernetLayer m_EthernetLayer;
	static IPLayer m_IpLayer;
	static TCPLayer m_TcpLayer;
	static ChatAppLayer m_ChatAppLayer;
	static FileAppLayer m_FileAppLayer;
	static GUI m_gui;

	private Listener listener = new Listener();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		m_NiLayer = new NILayer("NILayer");
		m_EthernetLayer = new EthernetLayer("EthernetLayer");
		m_IpLayer = new IPLayer("IPLayer");
		m_TcpLayer = new TCPLayer("TCPLayer",m_ChatAppLayer,m_FileAppLayer);
		m_ChatAppLayer = new ChatAppLayer("ChatAppLayer");
		m_FileAppLayer = new FileAppLayer("FileAppLayer");
		m_gui = new GUI();
		
		// NiLayer ���� ���̾� ����.
		m_NiLayer.setUpperLayer(m_EthernetLayer);
		
		// EthernetLayer�� ��,���� ���̾� ����.
		m_EthernetLayer.setUpperLayer(m_IpLayer);
		m_EthernetLayer.setUnderLayer(m_NiLayer);
		
		// IPLayer�� ��,���� ���̾� ����.
		m_IpLayer.setUpperLayer(m_TcpLayer);
		m_IpLayer.setUnderLayer(m_EthernetLayer);
		
		// TCPLayer�� ��,���� ���̾� ����.
		m_TcpLayer.setUnderLayer(m_IpLayer);
		
		// ChatAppLayer ��, ���� ���̾� ����.
		m_ChatAppLayer.setUpperLayer(m_gui);
		m_ChatAppLayer.setUnderLayer(m_TcpLayer);
		
		// FileAppLayer ��, ���� ���̾� ����.
		m_ChatAppLayer.setUpperLayer(m_gui);
		m_ChatAppLayer.setUnderLayer(m_TcpLayer);
		
		
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

	class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// ���� ��ư�� Ŭ������ ���.
			if(e.getSource() == btn_set){
				choice_NIC.setEnabled(false);
				text_src_addr.setEnabled(false);
				text_dst_addr.setEnabled(false);
			}
			// �缳�� ��ư�� Ŭ������ ���.
			if(e.getSource() == btn_reset){
				choice_NIC.setEnabled(true);
				text_src_addr.setEnabled(true);
				text_dst_addr.setEnabled(true);
			}
		}
		
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		JLabel label_chatting = new JLabel("ä��");
		label_chatting.setBounds(12, 10, 36, 20);
		
		//ä��â
		JTextArea chatting_area = new JTextArea();
		chatting_area.setBounds(22, 40, 472, 261);
		
		input_text = new JTextField();
		input_text.setBounds(24, 317, 356, 21);
		input_text.setColumns(10);
		
		JButton btn_text_transfer = new JButton("����(F)");
		btn_text_transfer.setBounds(381, 316, 107, 23);
		
		JLabel label_file = new JLabel("��������");
		label_file.setBounds(12, 348, 57, 15);
		
		file_name = new JTextField();
		file_name.setBounds(22, 373, 358, 21);
		file_name.setColumns(10);
		
		transfer_bar = new JTextField();
		transfer_bar.setBounds(22, 404, 358, 21);
		transfer_bar.setEditable(false);
		transfer_bar.setColumns(10);
		
		JButton btn_file = new JButton("���� ã��(O)");
		btn_file.setBounds(381, 372, 107, 23);
		
		JButton btn_file_transfer = new JButton("����(F)");
		btn_file_transfer.setBounds(381, 403, 107, 23);
		
		JLabel label_setting = new JLabel("����");
		label_setting.setBounds(510, 13, 57, 15);
		
		JLabel label_NIC = new JLabel("NIC ����");
		label_NIC.setBounds(510, 38, 57, 15);
		
		// NIC ���� ��.
		choice_NIC = new Choice();
		choice_NIC.setBounds(510, 60, 264, 21);
		// NIC bar�� ��Ʈ��ũ ī�� ����Ʈ �߰�.
		for(int i=0; i<m_NiLayer.m_pAdapterList.size();i++){
			choice_NIC.add(m_NiLayer.m_pAdapterList.get(i).getName());			
		}
		
		JLabel label_src_addr = new JLabel("���� �ּ�");
		label_src_addr.setBounds(510, 86, 57, 15);
		text_dst_addr = new JTextField();
		text_dst_addr.setText("XX:XX:XX:XX:XX");
		text_dst_addr.setHorizontalAlignment(SwingConstants.CENTER);
		text_dst_addr.setBounds(510, 171, 264, 21);
		text_dst_addr.setColumns(10);
		
		JLabel label_dst_addr = new JLabel("������ �ּ�");
		label_dst_addr.setBounds(510, 146, 80, 15);
		text_src_addr = new JTextField();
		text_src_addr.setHorizontalAlignment(SwingConstants.CENTER);
		text_src_addr.setText("XX:XX:XX:XX:XX");
		text_src_addr.setBounds(510, 115, 264, 21);
		text_src_addr.setColumns(10);
		
		btn_set = new Button("����(S)");
		btn_set.setBounds(605, 217, 76, 23);
		btn_set.addActionListener(listener); // �׼� ������ �߰�.

		btn_reset = new Button("�缳��(R)");
		btn_reset.setBounds(605, 248, 76, 23);
		btn_reset.addActionListener(listener); // �׼� ������ �߰�.
		
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
