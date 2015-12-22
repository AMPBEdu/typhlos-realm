package typhlos.net.packets.client;

import java.io.DataOutput;
import java.io.IOException;

import typhlos.client.Client;
import typhlos.net.data.ByteArrayDataInput;
import typhlos.net.packets.ClientPacket;
import typhlos.net.packets.Packets;

public class LoadPacket extends ClientPacket {
	
	public int charId = 296;
	public boolean isFromArena = false;
	
	public LoadPacket(){
		this.id = Packets.LOAD;
	}
	
	public LoadPacket(byte[] data){
		this.id = Packets.LOAD;
		readData(data);
	}
	
	public LoadPacket(int charId){
		this.id = Packets.LOAD;
		this.charId = charId;
	}
	
	public void readData(byte[] data) {
		super.readData(data);
		ByteArrayDataInput in = new ByteArrayDataInput(data);
		try{
		this.charId = in.readInt();
		this.isFromArena = in.readBoolean();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void writeData(DataOutput out) {
		try{
		out.writeInt(this.charId);
		out.writeBoolean(this.isFromArena);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void send(Client client){
		super.send(client);
	}
	
}
