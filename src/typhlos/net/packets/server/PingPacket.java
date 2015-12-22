package typhlos.net.packets.server;

import java.io.DataOutput;
import java.io.IOException;

import typhlos.client.Client;
import typhlos.net.data.ByteArrayDataInput;
import typhlos.net.packets.Packets;
import typhlos.net.packets.ServerPacket;
import typhlos.net.packets.client.PongPacket;

public class PingPacket extends ServerPacket{
	
	private int serial;
	
	public PingPacket(){
		this.id = Packets.PING;
	}
	
	public PingPacket(byte[] data){
		this.id = Packets.PING;
	}
	
	public PingPacket(int serial){
		this.serial = serial;
	}
	
	public void readData(byte[] data){
		super.readData(data);
		ByteArrayDataInput in = new ByteArrayDataInput(data);
		try{
		this.serial = in.readInt();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void writeData(DataOutput out){
		try{
		out.writeInt(serial);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void onReceive(Client client){
		super.onReceive(client);
		long time = System.currentTimeMillis() - client.getStartTime();
		PongPacket pongPacket = new PongPacket(this.serial, (int)time);
		pongPacket.send(client);
	}
	
}
