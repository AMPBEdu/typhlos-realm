package typhlos.net.data;

import typhlos.net.ServerPacket;
import typhlos.net.server.TestPacket;

public enum ServerPackets {
	TEST(-119, new TestPacket()), 
	UNKNOWN(-1, new ServerPacket());
	
	int id;
	ServerPacket packet;
	
	ServerPackets(int id, ServerPacket packet){
		this.id = id;
		this.packet = packet;
	}
	
	public int id(){
		return id;
	}
	
	ServerPacket get(){
		return packet;
	}
	
	public static void process(int id, byte[] data){
		boolean known = false;
		System.out.println("s2c:id:" + id);
		for(ServerPackets packet : ServerPackets.values()){
			if(id == packet.id){
				known = true;
				ServerPacket receivedPacket = new ServerPacket(id, data);
				receivedPacket.onReceive();
				System.out.println("Known: " + id);
				break;
			}
		}
		if(!known){
			System.out.println("s2c:Unknown: " + id);
		}
	}
}
