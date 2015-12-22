package typhlos.net.packets.server;

import java.io.DataOutput;
import java.io.IOException;

import typhlos.client.Client;
import typhlos.net.data.ByteArrayDataInput;
import typhlos.net.packets.Packets;
import typhlos.net.packets.ServerPacket;

public class TextPacket extends ServerPacket {
	
	private String name;
	private int objectId;
	private int numStars;
	private int bubbleTime; //try using long instead of int if needed
	private String recipient;
	private String text;
	private String cleanText;
	
	public TextPacket() {
		this.id = Packets.TEXT;		
	}
	
	public TextPacket(byte[] data) {
		this.id = Packets.TEXT;
		readData(data);
	}

	public TextPacket (String name, int objectId, int numStars, int bubbleTime, String recipient, String text, String cleanText) {
		this.id = Packets.TEXT;
		this.name = name;
		this.objectId = objectId;
		this.numStars = numStars;
		this.bubbleTime = bubbleTime;
		this.recipient = recipient;
		this.text = text;
		this.cleanText = cleanText;
	}
	
	public void readData(byte[] data) {
		super.readData(data);
		ByteArrayDataInput in = new ByteArrayDataInput(data);
		
		try {
			this.name = in.readUTF();
			this.objectId = in.readInt();
			this.numStars = in.readInt();
			this.bubbleTime = in.readInt();
			this.recipient = in.readUTF();
			this.text = in.readUTF();
			this.cleanText = in.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeData(DataOutput out) {
		try {
			out.writeUTF(name);
			out.writeInt(objectId);
			out.writeInt(numStars);
			out.writeInt(bubbleTime);
			out.writeUTF(recipient);
			out.writeUTF(text);
			out.writeUTF(cleanText);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onReceive(Client client) {
		super.onReceive(client);
	}	
}
