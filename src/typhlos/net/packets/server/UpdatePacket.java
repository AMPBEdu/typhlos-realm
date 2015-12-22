package typhlos.net.packets.server;

import java.io.DataOutput;

import typhlos.client.Client;
import typhlos.net.packets.Packets;
import typhlos.net.packets.ServerPacket;
import typhlos.net.packets.client.UpdateAckPacket;

public class UpdatePacket extends ServerPacket{
	
	public UpdatePacket(){
		this.id = Packets.UPDATE;
	}
	
	public UpdatePacket(byte[] data){
		this.id = Packets.UPDATE;
		readData(data);
	}
	//For now this does nothing
	public UpdatePacket(int example, String example2){
		
	}
	
	public void readData(byte[] data){
		super.readData(data);
	}
	
	public void writeData(DataOutput out){
	}
	
	public void onReceive(Client client){
		super.onReceive(client);
		UpdateAckPacket updack = new UpdateAckPacket();
		updack.send(client);
	}
	
}
