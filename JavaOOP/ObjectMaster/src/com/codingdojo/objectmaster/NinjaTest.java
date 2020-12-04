package com.codingdojo.objectmaster;

public class NinjaTest {

	public static void main(String[] args) {
		
		Ninja n = new Ninja();
		
		Human h = new Human();
		
		n.steal(h);
		System.out.println("Human Health: " + h.displayHealth());
		
		n.runAway();
		System.out.println("Ninja Health: " + n.displayHealth());

	}

}
