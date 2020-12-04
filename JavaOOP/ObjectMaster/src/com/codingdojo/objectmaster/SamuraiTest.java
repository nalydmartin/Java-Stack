package com.codingdojo.objectmaster;

public class SamuraiTest {

	public static void main(String[] args) {
		
		Samurai sam = new Samurai();
		
		Samurai sam2 = new Samurai();
		
		Samurai sam3 = new Samurai();
		
		Samurai sam4 = new Samurai();
		
		Human hum = new Human();
		
		sam.deathBlow(hum);
		System.out.println("Samurai Health: " + sam.displayHealth());
		System.out.println("Human Health: " + hum.displayHealth());

		sam.meditate();
		
		int samCount = sam.howMany();
		
		System.out.println("The samurai count is: " + samCount);
	}
}
