package com.codingdojo.objectmaster;

public class Ninja extends Human {

	public int stealth = 10;
	
	
	public Integer steal(Human peasant) {
		peasant.health -= 10;
		return health;
	}
	
	public Integer runAway() {
		health -= 10;
		return health;
	}
	
	
}
