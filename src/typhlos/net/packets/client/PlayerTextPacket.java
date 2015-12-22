package typhlos.net.packets.client;

import java.io.DataOutput;
import java.io.IOException;

import typhlos.client.Client;
import typhlos.net.data.ByteArrayDataInput;
import typhlos.net.packets.ClientPacket;
import typhlos.net.packets.Packets;

public abstract class PlayerTextPacket extends ClientPacket {
	
	private String text;
	
	public PlayerTextPacket() {
		this.id = Packets.PLAYERTEXT;
	}
	
	public PlayerTextPacket(byte[] data) {
		this.id = Packets.PLAYERTEXT;
	}
	
	public PlayerTextPacket(String text) {
		this.id = Packets.PLAYERTEXT;
		this.text = text;
	}
	
	public void readData(byte[] data) {
		super.readData(data);
		ByteArrayDataInput in = new ByteArrayDataInput(data);
		try{
		this.text = in.readUTF();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeData(DataOutput out) {
		try{
		out.writeUTF(text);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(Client client) {
		super.send(client);
	}
	
}
