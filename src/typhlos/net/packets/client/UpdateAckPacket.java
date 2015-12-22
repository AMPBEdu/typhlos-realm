package typhlos.net.packets.client;

import java.io.DataOutput;
import java.io.IOException;

import typhlos.client.Client;
import typhlos.net.data.ByteArrayDataInput;
import typhlos.net.packets.ClientPacket;
import typhlos.net.packets.Packets;

public class UpdateAckPacket extends ClientPacket{
	
	public UpdateAckPacket(){
		this.id = Packets.UPDATEACK;
	}
	
	public void readData(byte[] data){
		super.readData(data);
	}
	
	public void writeData(DataOutput out){
	}
	
	public void send(Client client){
		System.out.println("Sent updateack");
		super.send(client);
	}
	
}
