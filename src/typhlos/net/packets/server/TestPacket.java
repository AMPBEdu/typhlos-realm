package typhlos.net.packets.server;

import typhlos.client.Client;
import typhlos.net.packets.ServerPacket;
import typhlos.net.packets.ServerPackets;

/*
 * A packet the client accepts from a proxy/server to test the packet listener
 */

public class TestPacket extends ServerPacket{
	
	private String text;
	private static int testId = 137;
	public TestPacket() {
		super();
		id = testId;
	}
	
	public TestPacket(byte[] data){
		super(testId, data);
		id = testId;
	}

	public void onReceive(Client client){
		super.onReceive(client);
		System.out.println(text);
	}
	
}
