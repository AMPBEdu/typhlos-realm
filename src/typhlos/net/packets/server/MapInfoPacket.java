package typhlos.net.packets.server;

import java.io.ByteArrayInputStream;
import java.io.DataOutput;

import typhlos.client.Client;
import typhlos.net.packets.Packets;
import typhlos.net.packets.ServerPacket;
import typhlos.net.packets.client.LoadPacket;

public class MapInfoPacket extends ServerPacket{
	
	public MapInfoPacket(){
		this.id = Packets.MAPINFO;
	}
	
	public MapInfoPacket(byte[] data){
		this.id = Packets.MAPINFO;
		readData(data);
	}
	
	public void readData(byte[] data){
		super.readData(data);
		ByteArrayInputStream in = new ByteArrayInputStream(data);
		//read data into variables here
	}
	
	public void writeData(DataOutput out){
		super.writeData(out);
	}
	
	public void onReceive(Client client){
		System.out.println("MapInfo onReceive Method");
		LoadPacket load = new LoadPacket();
		load.send(client);
	}
	
}
