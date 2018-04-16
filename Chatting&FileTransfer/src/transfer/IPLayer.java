package transfer;

import java.util.Arrays;

public class IPLayer extends BaseLayer {
	final static int IP_HEADER_LENGTH = 20;
	final static int IP_SRC_INDEX = 12;
	final static int IP_DST_INDEX = 16;

	byte[] ip_verlen; // IP version.
	byte[] ip_tos; // type of service.
	byte[] ip_len; // total packet length.
	byte[] ip_id; // datagram id.
	byte[] ip_fragoff; // fragment offset.
	byte[] ip_ttl; // time to live in gateway hops.
	byte[] ip_proto; // IP protocol.
	byte[] ip_cksum; // header checksum.
	byte[] ip_src; // IP address of source.
	byte[] ip_dst; // IP address of destination.
	byte[] ip_data; // variable length data.
	byte[] ip_packet; // IPLayer packet.

	public IPLayer(String pName) {
		super(pName);
		resetHeader();
	}

	void resetHeader() {
		ip_verlen = new byte[1];
		ip_tos = new byte[1];
		ip_len = new byte[2];
		ip_id = new byte[2];
		ip_fragoff = new byte[2];
		ip_ttl = new byte[1];
		ip_proto = new byte[1];
		ip_cksum = new byte[2];
		ip_src = new byte[4];
		ip_dst = new byte[4];
	}

	public byte[] getIp_src() {
		return ip_src;
	}

	public void setIp_src(byte[] ip_src) {
		this.ip_src = Arrays.copyOf(ip_src, ip_src.length);

		for (int i = 0; i < 4; i++)
			ip_packet[i + IP_SRC_INDEX] = ip_src[i];
	}

	public byte[] getIp_dst() {
		return ip_dst;
	}

	public void setIp_dst(byte[] ip_dst) {
		this.ip_dst = Arrays.copyOf(ip_dst, ip_dst.length);

		for (int i = 0; i < 4; i++)
			ip_packet[i + IP_DST_INDEX] = ip_dst[i];
	}

	@Override
	boolean Send(byte[] data, int nlength) {
		// 이번 프로젝트는 IP를 사용하지 않아 해더를 비워주고 보낸다.
		ip_packet = new byte[IP_HEADER_LENGTH + nlength];
		System.arraycopy(data, IP_HEADER_LENGTH, ip_packet, 0, ip_packet.length);
		if (((IPLayer) this.getUnderLayer()).Send(ip_packet, ip_packet.length))
			return true;
		return false;
	}

	@Override
	boolean Receive(byte[] data) {
		// 이번 프로젝트에서는 IP 사용 X
		// for (int i = 0; i < 4; i++) {
		// if (data[IP_DST_INDEX + i] != ip_src[i])
		// return false;
		// }
		ip_data = new byte[data.length - IP_HEADER_LENGTH];
		System.arraycopy(data, IP_HEADER_LENGTH, ip_data, 0, ip_data.length);

		if (((IPLayer) this.getUpperLayer()).Receive(ip_data))
			return true;
		return false;
	}
}
