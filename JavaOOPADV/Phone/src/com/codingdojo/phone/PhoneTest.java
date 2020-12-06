package com.codingdojo.phone;

public class PhoneTest {

	public static void main(String[] args) {

		Galaxy s12 = new Galaxy("S12", 99, "Verizon", "My milkshake brings all the boys to the yard...");
		
		IPhone iphone12 = new IPhone("XII", 100, "AT&T", "I'm a barbie girl in a barbie world...");
		
		s12.displayInfo();
		System.out.println(s12.ring());
		System.out.println(s12.unlock());

		iphone12.displayInfo();
		System.out.println(iphone12.ring());
		System.out.println(iphone12.unlock());
		
		
		iphone12.setDevice("iPhone 12 Max");
		iphone12.setBattPercent(45);
		iphone12.setCarrier("T-Mobile");
		iphone12.setRingtone("Ooh honey I'll do anything for you. Ooh honey just tell me what yo ");
		System.out.println(iphone12.ring());
		iphone12.displayInfo();
		
	}

}
