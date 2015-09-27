package room;

import java.util.Map;

import model.Direction;

public class TreasureRoom extends Room {

	public TreasureRoom(String roomName) {
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
		
		System.out.println("You find a so beautiful treasure, you are rich !");

	}

}
