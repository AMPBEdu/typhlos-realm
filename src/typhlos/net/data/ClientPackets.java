package typhlos.net.data;

public enum ClientPackets {
	HELLO(83), LOAD(66);
	
	int id;
	
	ClientPackets(int id){
		this.id = id;
	}
	
	public int id(){
		return id;
	}
}
