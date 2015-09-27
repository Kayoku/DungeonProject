package model;

import java.util.ArrayList;

import item.Item;

public class Character {

	protected String name;
	protected ArrayList<Item> bag;
	protected boolean isAlive;
	
	public Character (String name){
		this.name = name;
		this.isAlive = true;
		this.bag = new ArrayList<>();
	}
	
}
