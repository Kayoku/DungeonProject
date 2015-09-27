package room;

import java.util.Map;

import model.Direction;

public class NormalRoom extends Room {
	
	public NormalRoom(String roomName) {
		super(roomName);
	}
	
	@Override
	public Room interpretCommand(String command) {
		
		for(Map.Entry<Direction, Room> entry : this.roomList.entrySet()) {
			if(command.equals(entry.getKey().toString())) {
				return entry.getValue();
			}
		}

		System.out.println("You try to go in a very strange direction... It's not working !");

		return this;		
	}

	@Override
	public void action() {
	}
	
	

}
