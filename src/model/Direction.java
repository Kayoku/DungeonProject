package model;

public enum Direction {
	NORTH("go north"),
	WEST("go west"),
	EST("go est"),
	SOUTH("go south");
	
	protected String name;
	
	Direction(String name) {
		this.name = name;
	}
	
	public String toString(){
		return this.name;
	}
	
}
