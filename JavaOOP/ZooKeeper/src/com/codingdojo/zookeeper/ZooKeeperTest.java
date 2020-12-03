package com.codingdojo.zookeeper;

public class ZooKeeperTest {

	public static void main(String[] args) {
		
		ZooKeeper zk = new ZooKeeper();
		
		int test = zk.displayEnergy();
		System.out.println(test);
	}

}
