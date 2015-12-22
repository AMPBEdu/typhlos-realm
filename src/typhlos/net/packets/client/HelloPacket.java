package typhlos.net.packets.client;

import java.io.DataOutput;
import java.io.IOException;

import typhlos.client.Client;
import typhlos.net.crypto.GUID;
import typhlos.net.data.ByteArrayDataInput;
import typhlos.net.packets.ClientPacket;
import typhlos.net.packets.Packets;

public class HelloPacket extends ClientPacket {
	
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

	public HelloPacket(){
		this.id = Packets.HELLO;
	}
	
	public HelloPacket(byte[] data){
		this.id = Packets.HELLO;
		readData(data);
	}
	
	public HelloPacket(String username, String password) {
		this.id = Packets.HELLO;
		this.guid = GUID.encrypt(username);
		this.password = GUID.encrypt(password);
	}
	
	// parse data to variables
	public void readData(byte[] data) {
		super.readData(data);
		ByteArrayDataInput in = new ByteArrayDataInput(data);
		try {
			in.readUTF();
			this.gameId = in.readInt();
			this.guid = in.readUTF();
			in.readInt();
			this.password = in.readUTF();
			in.readInt();
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
		super.writeData(out);
		try {
			out.writeUTF(Client.buildVersion);
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
	
	public void send(Client client){
		super.send(client);
	}
}
