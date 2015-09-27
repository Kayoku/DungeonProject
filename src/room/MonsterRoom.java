package room;

import java.util.Map;

import model.Direction;

public class MonsterRoom extends Room {

	public MonsterRoom(String roomName) {
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
		
		System.out.println("A terrible monster appears behind you ! You need to fight ! Kill him, or he will kill... YOU.");
		System.out.println("The monster fell on the ground, it's your chance ! What do you want do to ?");
		System.out.print("> ");
		
		String line = this.scanner.nextLine();
		
		if(line.equals("fight")){
			System.out.println("You decides to fight the monster, and you break his neck with your weapon ! Good job, you are alive.");
		} else {
			System.out.println("You try to run away and you stumble because of a banana. (Hahaha), the monster break your head, sorry, you are dead.");
		}
		
	}

}
