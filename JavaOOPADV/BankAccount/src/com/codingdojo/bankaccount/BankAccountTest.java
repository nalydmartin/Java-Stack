package com.codingdojo.bankaccount;

//import java.util.ArrayList;
//import java.util.Arrays;


public class BankAccountTest {

	public static void main(String[] args) {
		
		// line separator
		String newLine = System.lineSeparator();
		
		// Bank account instances
		BankAccount bb = new BankAccount();
		BankAccount bb2 = new BankAccount();
		

		// Get account number after new construction of class
		System.out.println("This is your new account number: " + bb.getAccntNumber());
		System.out.println("This is your new account number: " + bb2.getAccntNumber());

		
		// Check the total amount of bank accounts
		System.out.println("Total open bank accounts: " + bb.getTotalAccounts());
		
		
		// Check bank account checking balance
		System.out.printf("This is your checking account balance: " + "%.2f", bb.getCheckingBal());
		System.out.println(newLine);
		
		// Check bank account savings balance
		System.out.printf("This is your savings account balance: " + "%.2f", bb.getSavingBal());
		System.out.println(newLine);
		
		// Deposit into savings account
		bb.depositSaving(45.50);
		System.out.printf("New savings account balance: " + "%.2f", bb.getSavingBal());
		System.out.println(newLine);
		
		bb.depositSaving(600.85);
		System.out.printf("New savings account balance: " + "%.2f", bb.getSavingBal());
		System.out.println(newLine);
		
		
		// Deposit into checking account
		bb.depositChecking(400.009);
		System.out.printf("New checking account balance: " + "%.2f", bb.getCheckingBal());
		System.out.println(newLine);
		
		bb.depositChecking(30);
		System.out.printf("New checking account balance: " + "%.2f", bb.getCheckingBal());
		System.out.println(newLine);
		
		// Withdraw from savings account
		bb.withdrawSavings(250);
		System.out.printf("New savings account balance: " + "%.2f", bb.getSavingBal());
		System.out.println(newLine);
		
		bb.withdrawSavings(650);
		System.out.printf("New savings account balance: " + "%.2f", bb.getSavingBal());
		System.out.println(newLine);
		
		// Withdraw from checking account
		bb.withdrawChecking(75.88);
		System.out.printf("New checking account balance: " + "%.2f", bb.getCheckingBal());
		System.out.println(newLine);
		
		bb.withdrawChecking(905.89);
		System.out.printf("New checking account balance: " + "%.2f", bb.getCheckingBal());
		System.out.println(newLine);
		
		// Check total amount of money from checking and saving 
		System.out.printf("This is your total money amount from savings and checking: " + "%.2f", bb.getTotalMoneyAMT());
		System.out.println(newLine);
	}

}
