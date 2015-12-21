package typhlos.net.server;

import typhlos.client.Client;
import typhlos.net.ServerPacket;
import typhlos.net.data.ServerPackets;
import typhlos.net.client.LoadPacket;

public class MapInfoPacket extends ServerPacket{
	
	public MapInfoPacket(byte[] data){
		this.id = ServerPackets.MAPINFO.id();
	}
	
	public void onReceive(Client client){
		System.out.println("MapInfo onReceive Method");
		LoadPacket load = new LoadPacket();
		load.send(client);
	}
	
}
