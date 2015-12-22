package typhlos.net.packets;

import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet {

	protected int id;
	protected byte[] data;

	public Packet() {
		
	}

	public Packet(int id, byte[] data) {
		this.id = id;
		this.data = data;
		this.readData(data);
	}

	public void readData(byte[] data){
		this.data = data;
	}
	
	public void writeData(DataOutput out) {
		
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
	
	public byte[] getData(){
		try {
			this.data = getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.data;
	}
	
	public void setData(byte[] data){
		this.readData(data);
	}
	
	private byte[] getBytes() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(baos);
		this.writeData(out);
		return baos.toByteArray();
	}
}
