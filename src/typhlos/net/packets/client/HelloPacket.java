package typhlos.net.packets.client;

import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

import typhlos.client.Client;
import typhlos.net.crypto.GUID;
import typhlos.net.packets.ClientPacket;
import typhlos.net.packets.ClientPackets;

public class HelloPacket extends ClientPacket {
	
	private String buildVersion = "27.7.0";
	private int gameId = -2;
	private String guid = "";
	private static final int random0 = (int) Math.floor(Math.random() * 1000000000);
	private String password = "";
	private static final int random1 = (int) Math.floor(Math.random() * 1000000000);
	private String secret = "";
	private int keyTime = -1;
	private byte[] key = new byte[0];
	private byte[] obf1 = new byte[0];
	public String obf2 = "";
	public String obf3 = "";
	public String obf4 = "";
	public String obf5 = "";
	public String obf6 = "";

	public HelloPacket(String username, String password) {
		this.id = ClientPackets.HELLO.id();
		this.guid = GUID.encrypt(username);
		this.password = GUID.encrypt(password);
	}
	
	// parse data to variables
	public void parseData(DataInput in) {
		try {
			this.buildVersion = in.readUTF();
			this.gameId = in.readInt();
			this.guid = in.readUTF();
			this.password = in.readUTF();
			this.secret = in.readUTF();
			this.keyTime = in.readInt();
			this.key = new byte[in.readShort()];
			in.readFully(this.key);
			this.obf1 = new byte[in.readInt()];
			in.readFully(this.obf1);
			this.obf2 = in.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeData(DataOutput out) {
		try {
			out.writeUTF(this.buildVersion);
			out.writeInt(this.gameId);
			out.writeUTF(this.guid);
			out.writeInt(random0);
			out.writeUTF(this.password);
			out.writeInt(random1);
			out.writeUTF(this.secret);
			out.writeInt(this.keyTime);
			out.writeByte(this.key.length);
			out.write(this.key);
			out.writeLong(this.obf1.length);
			out.write(this.obf1);
			out.writeUTF(this.obf2);
			out.writeUTF(this.obf3);
			out.writeUTF(this.obf4);
			out.writeUTF(this.obf5);
			out.writeUTF(this.obf6);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public byte[] getBytes() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(baos);
		this.writeData(out);
		//System.out.println(new String(baos.toByteArray()));
		return baos.toByteArray();
	}
	
	public void send(Client client){
		super.send(client);
		//Do something whenever this type of packet is sent.
	}
}
