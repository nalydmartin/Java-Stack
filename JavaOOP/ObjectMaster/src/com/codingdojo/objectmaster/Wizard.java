package com.codingdojo.objectmaster;

public class Wizard extends Human{

	public int health = 50;
	public int intelligence = 8;
	
	public Integer heal(Human player) {
		player.health += intelligence;
		return health;
	}
	
	public Integer fireball(Human burned) {
		burned.health -= intelligence * 3;
		return health;
	}
	
}
