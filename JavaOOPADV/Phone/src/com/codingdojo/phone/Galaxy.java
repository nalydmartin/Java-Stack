package com.codingdojo.phone;

public class Galaxy extends Phone implements Ringable {
	
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    
    
    @Override
    public String ring() {
        // your code here
    	String grt = "Galaxy S12 says " + getRingtone();
    	
    	return grt;
    }
    
    
    @Override
    public String unlock() {
        // your code here
    	String u = "Unlocking via fingerprint";
    	
    	return u;
    }
    
    
    @Override
    public void displayInfo() {
        // your code here    
    	String d = getDevice();
    	int bp = getBattPercent();
    	String c = getCarrier();
    	String rt = getRingtone();
    	System.out.println("Device: " + d + ", " + "Battery: " + bp + ", " + "Carrier: " + c + ", " + "Ringtone: " + rt);
    }
}
