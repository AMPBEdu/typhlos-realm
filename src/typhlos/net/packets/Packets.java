package typhlos.net.packets;

import typhlos.net.packets.server.MapInfoPacket;
import typhlos.net.packets.server.PingPacket;
import typhlos.net.packets.server.UpdatePacket;

public class Packets {
	// This is used for the packet templates
	public static final int EXAMPLE = -1337;

	// Packet ID's
	public static final int FAILURE = 0; // slotid = 1
	public static final int CREATE_SUCCESS = 86; // slotid = 2
	public static final int CREATE = 90; // slotid = 3
	public static final int PLAYERSHOOT = 16; // slotid = 4
	public static final int MOVE = 14; // slotid = 5
	public static final int PLAYERTEXT = 67; // slotid = 6
	public static final int TEXT = 10; // slotid = 7
	public static final int SHOOT2 = 88; // slotid = 8
	public static final int DAMAGE = 57; // slotid = 9
	public static final int UPDATE = 49; // slotid = 10
	public static final int UPDATEACK = 37; // slotid = 11
	public static final int NOTIFICATION = 99; // slotid = 12
	public static final int NEW_TICK = 47; // slotid = 13
	public static final int INVSWAP = 44; // slotid = 14
	public static final int USEITEM = 92; // slotid = 15
	public static final int SHOW_EFFECT = 89; // slotid = 16
	public static final int HELLO = 83; // slotid = 17
	public static final int GOTO = 50; // slotid = 18
	public static final int INVDROP = 8; // slotid = 19
	public static final int INVRESULT = 45; // slotid = 20
	public static final int RECONNECT = 101; // slotid = 21
	public static final int PING = 38; // slotid = 22
	public static final int PONG = 68; // slotid = 23
	public static final int MAPINFO = 58; // slotid = 24
	public static final int LOAD = 66; // slotid = 25
	public static final int PIC = 28; // slotid = 26
	public static final int SETCONDITION = 46; // slotid = 27
	public static final int TELEPORT = 5; // slotid = 28
	public static final int USEPORTAL = 4; // slotid = 29
	public static final int DEATH = 75; // slotid = 30
	public static final int BUY = 24; // slotid = 31
	public static final int BUYRESULT = 3; // slotid = 32
	public static final int AOE = 53; // slotid = 33
	public static final int GROUNDDAMAGE = 59; // slotid = 34
	public static final int PLAYERHIT = 22; // slotid = 35
	public static final int ENEMYHIT = 97; // slotid = 36
	public static final int AOEACK = 82; // slotid = 37
	public static final int SHOOTACK = 7; // slotid = 38
	public static final int OTHERHIT = 94; // slotid = 39
	public static final int SQUAREHIT = 19; // slotid = 40
	public static final int GOTOACK = 9; // slotid = 41
	public static final int EDITACCOUNTLIST = 60; // slotid = 42
	public static final int ACCOUNTLIST = 79; // slotid = 43
	public static final int QUESTOBJID = 77; // slotid = 44
	public static final int CHOOSENAME = 27; // slotid = 45
	public static final int NAMERESULT = 76; // slotid = 46
	public static final int CREATEGUILD = 69; // slotid = 47
	public static final int CREATEGUILDRESULT = 21; // slotid = 48
	public static final int GUILDREMOVE = 40; // slotid = 49
	public static final int GUILDINVITE = 25; // slotid = 50
	public static final int ALLYSHOOT = 74; // slotid = 51
	public static final int SHOOT = 20; // slotid = 52
	public static final int REQUESTTRADE = 78; // slotid = 53
	public static final int TRADEREQUESTED = 23; // slotid = 54
	public static final int TRADESTART = 11; // slotid = 55
	public static final int CHANGETRADE = 56; // slotid = 56
	public static final int TRADECHANGED = 17; // slotid = 57
	public static final int ACCEPTTRADE = 98; // slotid = 58
	public static final int CANCELTRADE = 15; // slotid = 59
	public static final int TRADEDONE = 36; // slotid = 60
	public static final int TRADEACCEPTED = 26; // slotid = 61
	public static final int CLIENTSTAT = 62; // slotid = 62
	public static final int CHECKCREDITS = 35; // slotid = 63
	public static final int ESCAPE = 33; // slotid = 64
	public static final int FILE = 84; // slotid = 65
	public static final int INVITEDTOGUILD = 1; // slotid = 66
	public static final int JOINGUILD = 48; // slotid = 67
	public static final int CHANGEGUILDRANK = 6; // slotid = 68
	public static final int PLAYSOUND = 55; // slotid = 69
	public static final int GLOBAL_NOTIFICATION = 31; // slotid = 70
	public static final int RESKIN = 61; // slotid = 71
	// public static final int _-12t = 12; // slotid = 72
	// public static final int _-02u = 63; // slotid = 73
	// public static final int _-0kN = 95; // slotid = 74
	// public static final int _-00N = 30; // slotid = 75
	// public static final int _-1US = 80; // slotid = 76
	// public static final int _-0Xg = 91; // slotid = 77
	// public static final int _-0MY = 85; // slotid = 78
	// public static final int _-05N = 18; // slotid = 79
	public static final int ENTER_ARENA = 51; // slotid = 80
	// public static final int _-0wo = 34; // slotid = 81
	// public static final int _-0jA = 39; // slotid = 82
	// public static final int _-0UC = 93; // slotid = 83
	// public static final int _-1KK = 65; // slotid = 84
	// public static final int _-zh = 100; // slotid = 85
	// public static final int _-1uy = 96; // slotid = 86
	// public static final int _-z0 = 41; // slotid = 87
	// public static final int _-21M = 87; // slotid = 88
	// public static final int _-1pU = 52; // slotid = 89
	// public static final int _-1XQ = 64; // slotid = 90
	// public static final int _-1sf = 42; // slotid = 91
	// public static final int _-185 = 13; // slotid = 92
	// public static final int _-Xd = 81; // slotid = 93

	public static Packet parse(int id, byte[] data) {
		switch (id) {
		case Packets.MAPINFO:
			return new MapInfoPacket(data);
		case Packets.PING:
			return new PingPacket(data);
		case Packets.UPDATE:
			return new UpdatePacket(data);
		default:
			return new ServerPacket(id, data);
		}

	}
}