package typhlos.net.packets.server;

import java.io.DataOutput;
import java.io.IOException;

import typhlos.net.packets.Packets;
import typhlos.net.packets.ServerPacket;
import typhlos.client.Client;
import typhlos.net.data.ByteArrayDataInput;

public class DeathPacket extends ServerPacket {
	
	private String accountId;
	private int charId;
	private String killedBy;
	private int obf0;
	private int obf1;
	private boolean bool0;
	
	public DeathPacket() {
		this.id = Packets.DEATH;
	}
	
	public DeathPacket(byte[] data) {
		this.id = Packets.DEATH;
		readData(data);
	}
	
	public DeathPacket(String accountId, int charId, String killedBy, int obf0, int obf1, boolean bool0) {
		this.id = Packets.DEATH;
		this.accountId = accountId;
		this.charId = charId;
		this.killedBy = killedBy;
		this.obf0 = obf0;
		this.obf1 = obf1;
		this.bool0 = bool0;
	}
	
	public void readData(byte[] data) {
		super.readData(data);
		ByteArrayDataInput in = new ByteArrayDataInput(data);
		
		try {
			this.accountId = in.readUTF();
			this.charId = in.readInt();
			this.killedBy = in.readUTF();
			this.obf0 = in.readInt();
			this.obf1 = in.readInt();
			this.bool0 = in.readBoolean();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void writeData(DataOutput out) {
		try {
			out.writeUTF(accountId);
			out.writeInt(charId);
			out.writeUTF(killedBy);
			out.writeInt(obf0);
			out.writeInt(obf1);
			out.writeBoolean(bool0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onReceive(Client client) {
		System.out.println("oh shiet i'm dead");
		super.onReceive(client);
	}

}
