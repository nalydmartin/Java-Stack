package com.codingdojo.zookeeper;

public class ZooKeeperTest {

	public static void main(String[] args) {
		
		// For ZooKeeper Class
		
		ZooKeeper zk = new ZooKeeper();
		
		Integer test = zk.displayEnergy();
		System.out.println("The current energy level is: " + test);

		
		
	}

}
