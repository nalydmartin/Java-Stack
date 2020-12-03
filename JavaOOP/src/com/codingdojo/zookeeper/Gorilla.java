package com.codingdojo.zookeeper;

public class Gorilla extends ZooKeeper{
	
	
	public Integer throwSomething() {
		this.energyLevel -= 5;
		return energyLevel;
	}
	
	public Integer eatBananas() {
		this.energyLevel += 10;
		return energyLevel;
	}
	
	public Integer climb() {
		this.energyLevel -= 10;
		return energyLevel;
	}
}
