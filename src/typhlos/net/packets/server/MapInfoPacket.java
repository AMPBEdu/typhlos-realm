package typhlos.net.packets.server;

import typhlos.client.Client;
import typhlos.net.packets.ServerPacket;
import typhlos.net.packets.ServerPackets;
import typhlos.net.packets.client.LoadPacket;

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
