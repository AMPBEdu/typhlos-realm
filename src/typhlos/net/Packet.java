package typhlos.net;

import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet {

	protected int id;

	public Packet() {

	}

	public Packet(int id, byte[] data) {
		this.id = id;
	}

	public byte[] getBytes() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(baos);
		this.writeData(out);
		//System.out.println(new String(baos.toByteArray()));
		return baos.toByteArray();
	}

	private void writeData(DataOutput out) {
		
	}

	public void parseData() {

	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
}
