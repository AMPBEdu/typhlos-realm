package typhlos.net;

import typhlos.client.Client;

public class ServerPacket extends Packet{
	
	public ServerPacket(){
		super();
	}
	
	public ServerPacket(int id, byte[] data) {
		super(id, data);
	}

	/*
	 * Place to do something whenever you receive a packet.
	 */
	public void onReceive(Client client){
		System.out.println("ServerPacket onReceive Method");
	}
}
