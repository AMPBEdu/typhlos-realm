package typhlos.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

import typhlos.net.Packet;
import typhlos.net.client.HelloPacket;
import typhlos.net.crypto.RC4;
import typhlos.net.data.*;

public class Client {

	private String username;
	private String password;

	private InetAddress server;
	private InetAddress localhost;
	private Socket socket;
	private int port;
	private boolean connected = false;
	private boolean running = true;

	private RC4 cipherOut = new RC4(fromHexString("311f80691451c71d09a13a2a6e"));
	private RC4 cipherIn = new RC4(fromHexString("72c5583cafb6818995cdd74b80"));
	private DataInputStream read;
	private DataOutputStream write;

	Thread send, receive;

	public Client(String username, String password, String server, int port) {
		this.username = username;
		this.password = password;
		this.port = port;
		try {
			this.localhost = InetAddress.getByName("localhost");
			//Set this.server = InetAddress.getByName(server); if you want to use server from gui
			this.server = InetAddress.getByName(server);
			//this.server = InetAddress.getByName("ec2-54-80-67-112.compute-1.amazonaws.com");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void connect() {
		receive = new Thread(new Runnable() {
			public void run() {
				runListenThread();
			}
		}, "receive");
		receive.start();

		HelloPacket hello = new HelloPacket(username, password);
		hello.send(this);
	}

	public void runListenThread() {
		try {
			socket = new Socket(localhost, port);
			setWrite(new DataOutputStream(socket.getOutputStream()));
			setRead(new DataInputStream(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setConnected(true);
		
		receive = new Thread("receive") {
			public void run() {
				while(isConnected()){
				try {
					int length = read.readInt();
					byte id = read.readByte();
					System.out.println(id);
					byte[] data = new byte[length - 5];
					read.readFully(data);
					ServerPackets.process(id, data);
				} catch (IOException e) {
					e.printStackTrace();
				}
				}
			}
		};
		
		receive.start();

	}

	private static byte[] fromHexString(final String encoded) {
		if ((encoded.length() % 2) != 0)
			throw new IllegalArgumentException("Input string must contain an even number of characters");

		final byte result[] = new byte[encoded.length() / 2];
		final char enc[] = encoded.toCharArray();
		for (int i = 0; i < enc.length; i += 2) {
			StringBuilder curr = new StringBuilder(2);
			curr.append(enc[i]).append(enc[i + 1]);
			int ix = Integer.parseInt(curr.toString(), 16);
			result[i / 2] = (byte) ix;
		}
		return result;
	}

	public boolean isConnected() {
		return connected;
	}

	public DataOutputStream getWrite() {
		return write;
	}

	public RC4 getCipherOut() {
		return cipherOut;
	}

	public void setCipherOut(RC4 cipherOut) {
		this.cipherOut = cipherOut;
	}

	public RC4 getCipherIn() {
		return cipherIn;
	}

	public void setCipherIn(RC4 cipherIn) {
		this.cipherIn = cipherIn;
	}

	public DataInputStream getRead() {
		return read;
	}

	public void setRead(DataInputStream read) {
		this.read = read;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public void setWrite(DataOutputStream write) {
		this.write = write;
	}

}
