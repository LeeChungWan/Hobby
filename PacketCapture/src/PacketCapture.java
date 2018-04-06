import java.io.File;

public class PacketCapture {
	// �������� jnetpcap.dll ���� �ε�
	static{
		try{
			// native Library Load
			System.load(new File("jnetpcap.dll").getAbsolutePath());
			System.out.println(new File("jnetpcap.dll").getAbsolutePath());
		}catch (UnsatisfiedLinkError e) {
			System.out.println("Native code library failed to load.\n " +e);
			System.exit(1);
		}
	}
	
	public static void main(String[] args) {
		// .. ���ۼ�
	}
}
