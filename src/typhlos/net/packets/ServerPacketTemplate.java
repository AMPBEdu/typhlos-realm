package typhlos.net.packets;

import java.io.DataOutput;
import java.io.IOException;

import typhlos.client.Client;
import typhlos.net.data.ByteArrayDataInput;

public abstract class ServerPacketTemplate extends ServerPacket{
	
	private int example;
	private String example2;
	private boolean variableThatDoesntNeedToBeRead = false;
	
	public ServerPacketTemplate(){
		this.id = Packets.EXAMPLE;
	}
	
	public ServerPacketTemplate(byte[] data){
		this.id = Packets.EXAMPLE;
		readData(data);
	}
	
	public ServerPacketTemplate(int example, String example2){
		this.id = Packets.EXAMPLE;
		this.example = example;
		this.example2 = example2;
	}
	
	public void readData(byte[] data){
		super.readData(data);
		ByteArrayDataInput in = new ByteArrayDataInput(data);
		try{
		this.example = in.readInt();
		this.example2 = in.readUTF();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void writeData(DataOutput out){
		try{
		out.writeInt(example);
		out.writeUTF(example2);
		out.writeBoolean(variableThatDoesntNeedToBeRead);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void onReceive(Client client){
		super.onReceive(client);
		//Do whatever you want when you receive this type of packet.
	}
	
}
