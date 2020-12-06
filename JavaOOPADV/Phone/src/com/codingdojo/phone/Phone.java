package com.codingdojo.phone;

public abstract class Phone {
			
    private String versionNumber;
    private int batteryPercentage;
    private String carrier;
    private String ringTone;
    
    
    public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = ringTone;
    }
    
    // abstract method. This method will be implemented by the subclasses
    public abstract void displayInfo();
    
    
    
    // getters and setters removed for brevity. Please implement them yourself
    
    public String getDevice() {
    	return versionNumber;
    }
    
    
    public int getBattPercent() {
    	return batteryPercentage;
    }
    
    
    public String getCarrier() {
    	return carrier;
    }

    
    public String getRingtone() {
    	return ringTone;
    }
    
    public void setDevice(String device) {
    	this.versionNumber = device;
    }
    
    public void setBattPercent(int battery) {
    	this.batteryPercentage = battery;
    }
    
    public void setCarrier(String carrier) {
    	this.carrier = carrier;
    }
    
    public void setRingtone(String ringt) {
    	this.ringTone = ringt;
    }
}