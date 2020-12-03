package com.codingdojo.zookeeper;

public class GorillaTest {

	public static void main(String[] args) {
		
		//For Gorilla Class
		
		Gorilla g = new Gorilla();
				
		// For throw something method
		Integer gt = g.throwSomething();
		System.out.println("Gorilla threw a banana! Energy level: " + gt);
				
		// For eat bananas method
		Integer gb = g.eatBananas();
		System.out.println("Gorilla ate a banana! Energy level: " + gb);
		
		// For the climn method
		
		Integer gc = g.climb();
		System.out.println("The Gorilla is climbing! Energy level: " + gc);
		
		// Test 
		
		Gorilla gtest = new Gorilla();
		
		gtest.throwSomething();
		gtest.throwSomething();
		gtest.throwSomething();
		System.out.println(gtest.displayEnergy());
		
		gtest.eatBananas();
		gtest.eatBananas();
		System.out.println(gtest.displayEnergy());
		
		gtest.climb();
		
		System.out.println(gtest.displayEnergy());
				
	}

}
