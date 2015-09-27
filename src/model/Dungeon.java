package model;

import java.util.Scanner;

import room.MonsterRoom;
import room.NormalRoom;
import room.Room;

public class Dungeon {

	protected Room currentRoom;
	protected boolean gameIsFinished;
	protected boolean playerIsAlive;
	protected final Scanner scanner;
	protected Character character;
	
	public Dungeon() {
		this.character = new Character("George");
		this.scanner = new Scanner(System.in);
		this.playerIsAlive = true;
		this.gameIsFinished = false;
	}

	public void interpretCommand(String command){
		
		char charG = command.charAt(0);
		char charO = command.charAt(1);
		
		if(charG == 'g' && charO == 'o'){
			this.currentRoom = this.currentRoom.interpretCommand(command);
		} else {
			System.out.println("I don't know what you mean !");
		}
		
	}
	
	public void start(){

		/* Generation of the static dungeon */
		this.currentRoom = generateDungeon();
		
		do {
			this.currentRoom.action();
			
			System.out.println("You are in " + getCurrentRoom().getRoomName());
			System.out.println("What do you want to do ?");
			System.out.print("> ");
			
			// Read a command from the user (stdin)
			String line = scanner.nextLine();
			interpretCommand(line);
		} while (!gameIsFinished());
		
		System.out.println("You are in " + getCurrentRoom().getRoomName());
		
		if(gameIsWon()){
			System.out.println("You win !");
		} else {
			System.out.println("You loose !");
		}
		
	}
	
	public Room generateDungeon() {

		// Declaration & initialization of the dungeon
		NormalRoom exitRoom = new NormalRoom("exit");
		NormalRoom trapRoom = new NormalRoom("trap");
		MonsterRoom intersectionRoom = new MonsterRoom("intersection");
		NormalRoom entranceRoom = new NormalRoom("entrance");

		// "Connection" of the dungeon's rooms
		intersectionRoom.addAroundRoom(Direction.WEST, trapRoom);
		intersectionRoom.addAroundRoom(Direction.NORTH, exitRoom);
		entranceRoom.addAroundRoom(Direction.NORTH, intersectionRoom);
	
		return entranceRoom;

	}
	

	public boolean gameIsFinished() {
		return gameIsLost() || gameIsWon();
	}
	
	public boolean gameIsLost() {
		return this.currentRoom.getRoomName().equals("trap");
	}
	
	public boolean gameIsWon() {
		return this.currentRoom.getRoomName().equals("exit");
	}
	public Room getCurrentRoom(){
		return currentRoom;
	}
	
}