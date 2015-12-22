package typhlos.net.packets;

import java.io.IOException;

import typhlos.client.Client;

public class ClientPacket extends Packet{
	
	public ClientPacket(){
		super();
	}
	
	public ClientPacket(int id, byte[] data){
		super(id, data);
	}
	
	//Send the packet object to server
	public void send(Client client){
		/*
		 * Place to do whatever you want when any packet is sent to the server
		 * such as printing all outgoing packets.
		 */
		if(!client.isConnected()){
			System.out.println("Not connected to a server.");
			return;
		}
		try {
			byte[] data = this.getData();
			client.getWrite().writeInt(data.length + 5);
			client.getWrite().writeByte(this.getID());
			client.getWrite().write(client.getCipherOut().rc4(data));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
