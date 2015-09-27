package room;

import java.util.HashMap;
import java.util.Scanner;

import model.Direction;

public abstract class Room {
	
	protected static int countId = 1;

	protected HashMap<Direction, Room> roomList;
	protected int id;
	protected String roomName;
	protected final Scanner scanner = new Scanner(System.in);
	
	public Room(String roomName) {
		this.roomName = roomName;
		this.id = countId;
		countId++;
		this.roomList = new HashMap<>();
	}
		
	public int getId() {
		return this.id;
	}
	
	public String getRoomName(){
		return this.roomName;
	}
	
	public HashMap<Direction, Room> getRoomList() {
		return this.roomList;
	}
	
	public void addAroundRoom(Direction access, Room room) {
		this.roomList.put(access, room);
	}
	
	public abstract Room interpretCommand(String command);
	
	public abstract void action();
	
}
