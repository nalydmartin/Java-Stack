package com.codingdojo.phone;

public class IPhone extends Phone implements Ringable {
	
	    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
	        super(versionNumber, batteryPercentage, carrier, ringTone);
	    }
	    
	    
	    @Override
	    public String ring() {
	    	String irt = "iPhone 12 says " + getRingtone();
	    	
	       return irt;
	    }
	    
	    
	    @Override
	    public String unlock() {
	        // your code here
	    	String u = "Unlocking via facial recognition.";
	    	
	    	return u;
	    }
	    
	    
	    @Override
	    public void displayInfo() {
	        // your code here
	    	String d = getDevice();
	    	int bp = getBattPercent();
	    	String c = getCarrier();
	    	String rt = getRingtone();
	    	System.out.println("Device: " + d + ", " + "Battery: "  + bp  + ", " + "Carrier: " + c + ", " + "Ringtone: " + rt);

	}

}
