package typhlos.net.packets.client;

import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

import typhlos.client.Client;
import typhlos.net.packets.ClientPacket;
import typhlos.net.packets.ClientPackets;

public class LoadPacket extends ClientPacket {
	
	public int charId = 296;
	public boolean isFromArena = false;
	
	public LoadPacket(){
		this.id = ClientPackets.LOAD.id();
	}
	
	public LoadPacket(int charId){
		this.id = ClientPackets.LOAD.id();
		this.charId = charId;
	}
	
	public void readData(DataInput in) throws IOException {
		this.charId = in.readInt();
		this.isFromArena = in.readBoolean();
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
	
	public byte[] getBytes() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(baos);
		this.writeData(out);
		//System.out.println(new String(baos.toByteArray()));
		return baos.toByteArray();
	}
	
}
