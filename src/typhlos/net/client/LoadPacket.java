package typhlos.net.client;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import typhlos.client.Client;
import typhlos.net.ClientPacket;

public class LoadPacket extends ClientPacket {
	
	public int charId = 296;
	public boolean isFromArena = false;
	
	public LoadPacket(){
		
	}
	
	public LoadPacket(int charId){
		this.charId = charId;
	}
	
	public void parseFromInput(DataInput in) throws IOException {
		this.charId = in.readInt();
		this.isFromArena = in.readBoolean();
	}

	public void writeToOutput(DataOutput out) throws IOException {
		out.writeInt(this.charId);
		out.writeBoolean(this.isFromArena);
	}
	
	public void send(Client client){
		super.send(client);
	}
	
}
