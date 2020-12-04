package com.codingdojo.objectmaster;

public class Samurai extends Human {

	public static int health = 200;
	public static int samurais = 0;
	
	public Samurai() {
		samurais += 1;
	}
	
	
	public Integer deathBlow(Human victim) {
		
		victim.health -= victim.health;
		
		this.health -= this.health/2;
		
		return health;
	}
	
	
	public void meditate() {
		this.health += this.health / 2;
		System.out.println("This samurai's health is now: " + this.health);
	}
	
	
	public Integer howMany() {
		//System.out.println("The samurai count is: " + samurais);
		return samurais;
	}
	
	
	
	
}
