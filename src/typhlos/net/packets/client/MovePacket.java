package typhlos.net.packets.client;

import java.io.DataOutput;
import java.io.IOException;

import typhlos.client.Client;
import typhlos.net.data.ByteArrayDataInput;
import typhlos.net.packets.ClientPacket;
import typhlos.net.packets.Packets;

public class MovePacket extends ClientPacket{

	private int example;
	private String example2;
	private boolean variableThatDoesntNeedToBeRead = false;
	
	public MovePacket(){
		this.id = Packets.MOVE;
	}
	
	public MovePacket(byte[] data){
		this.id = Packets.MOVE;
	}
	
	public MovePacket(int example, String example2){
		this.id = Packets.MOVE;
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
	
	public void send(Client client){
		//Do something before this type of packet is sent here
		super.send(client);
		//Do something after this type of packet is sent here
	}
	
}
