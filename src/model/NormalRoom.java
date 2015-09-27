package model;

import java.util.Map;

public class NormalRoom extends Room {
	
	public NormalRoom(String roomName) {
		this.roomName = roomName;
		this.id = countId;
		countId++;
	}
	
	@Override
	public void interpretCommand(String command) {
		System.out.println(command);
		
	}

}
