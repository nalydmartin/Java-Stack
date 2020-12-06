package com.codingdojo.bankaccount;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class BankAccount {

	private String acntNum;
	private double chkBal;
	private double savBal;
	
	private static int allAcnts = 0;
	private static double totalMoney = 0;
	
	
	// Bank Account Constructor
	public BankAccount() {
		allAcnts++;
		ArrayList<Integer> ACNTNUM = new ArrayList<Integer>();
		ACNTNUM = randAcnt();
		//System.out.println(ACNTNUM);
		Integer[] convert = ACNTNUM.toArray(new Integer[ACNTNUM.size()]);
		//System.out.println(Arrays.toString(convert));
		String temp = Arrays.toString(convert);
		this.acntNum = temp;
	}
	
	
	// Random account number generator
	private ArrayList<Integer> randAcnt() {
		Random r = new Random();
		ArrayList<Integer> randAcntNums = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			randAcntNums.add(r.nextInt(10));
		}
		//System.out.println(randAcntNums);
		return randAcntNums;
	}
	
	
	// Getters
	public String getAccntNumber() {
		return acntNum;
	}
	
	public int getTotalAccounts() {
		return allAcnts;
	}
	
	public double getCheckingBal() {
		return chkBal;
	}
	
	public double getSavingBal() {
		return savBal;
	}
	
	public double getTotalMoneyAMT() {
		return totalMoney;
	}
	
	// Deposit into savings account
	public void depositSaving(double amount) {
		this.savBal += amount;
		totalMoney += this.savBal;
	}
	
	
	//Deposit into checking account
	public void depositChecking(double amount) {
		this.chkBal += amount;
		totalMoney += this.chkBal;
	}
	
	
	// Withdraw from savings account
	public void withdrawSavings(double amount) {
		
		if(savBal > 0 && amount <= savBal) {
			this.savBal -= amount;
			totalMoney -= amount;
		} else {
			System.out.println("Insufficent funds.");
		}
	}
	

	// Withdraw from checking account
	public void withdrawChecking(double amount) {
		
		if(chkBal > 0 && amount <= chkBal) {
			this.chkBal -= amount;
			totalMoney -= amount;
		} else {
			System.out.println("Insufficent funds.");
		}
	}
	
	
}
