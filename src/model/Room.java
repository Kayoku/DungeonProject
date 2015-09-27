package model;

import java.util.Map;

public abstract class Room {
	
	protected static int countId = 1;

	protected Map<String, Room> roomList;
	protected int id;
	protected String roomName;
		
	public int getId() {
		return this.id;
	}
	
	public Map<String, Room> getRoomList() {
		return this.roomList;
	}
	
	public abstract void interpretCommand(String command);
	
}
