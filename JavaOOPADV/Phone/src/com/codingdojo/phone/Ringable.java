package com.codingdojo.phone;

public interface Ringable {

	default String ring() {
		String defaultRing = "Brrrrrrrrr";
		
		return defaultRing;
	}
	
	default String unlock() {
		String defaultUnlock = "Phone unlocked, now what?";
		
		return defaultUnlock;
	}
	
}
