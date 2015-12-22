package typhlos.net.packets.client;

import java.io.DataOutput;
import java.io.IOException;

import typhlos.client.Client;
import typhlos.net.data.ByteArrayDataInput;
import typhlos.net.packets.ClientPacket;
import typhlos.net.packets.Packets;

public class PongPacket extends ClientPacket{

	public int serial;
	public int time;
	
	public PongPacket(){
		this.id = Packets.PONG;
	}
	
	public PongPacket(byte[] data){
		readData(data);
	}
	
	public PongPacket(int serial, int time){
		this.id = Packets.PONG;
		this.serial = serial;
		this.time = time;
	}
	
	public void readData(byte[] data){
		super.readData(data);
		ByteArrayDataInput in = new ByteArrayDataInput(data);
		try{
		this.serial = in.readInt();
		this.time = in.readInt();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void writeData(DataOutput out){
		try{
		out.writeInt(serial);
		out.writeInt(time);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void send(Client client){
		super.send(client);
	}
	
}
