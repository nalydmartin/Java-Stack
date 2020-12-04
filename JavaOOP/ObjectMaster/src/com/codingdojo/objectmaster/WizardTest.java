package com.codingdojo.objectmaster;

public class WizardTest {

	public static void main(String[] args) {
		
		Wizard w = new Wizard();
		
		Human h = new Human();
		
		w.heal(h);
		System.out.println(h.displayHealth());
		
		w.fireball(h);
		System.out.println(h.displayHealth());
		
	}

}
