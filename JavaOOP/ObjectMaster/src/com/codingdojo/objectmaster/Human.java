package com.codingdojo.objectmaster;

public class Human {

	public int strength = 3;
	public int intelligence = 3;
	public int stealth = 3;
	public int health = 100;
	
	
	public Integer attackHuman(Human victim) {
		
		victim.health -= strength;
		return health;
	}
	
	public Integer displayHealth() {
		return health;
	}
	
}
