package com.codingdojo.calculator;

public class Calculator implements java.io.Serializable{

	private double operandOne;
	private double operandTwo;
	private String operator;
	private double sum;
	
	// Constructors 
	
	public Calculator() {
		
	}
	
	public Calculator(double num1, double num2) {
		operandOne = num1;
		operandTwo = num2;
	}
	
	
	// Setters
	
	public void setOperandOne(double number) {
		operandOne = number;
	}
	
	
	public void setOperandTwo(double number) {
		operandTwo = number;
	}
	
	
	public void setOperation(String math) {
		operator = math;
	}
	
	
	// Getters 
	
	public double getOperandOne() {
		return operandOne;
	}
	
	
	public double getOperandTwo() {
		return operandTwo;
	}
	
	public double getResults() {
		return sum;
	}
	
	// Perform operations
	
	public void performOperation() {
		if (operator == "+") {
			sum = operandOne + operandTwo;
		} else if (operator == "-") {
			sum = operandOne - operandTwo;
		}
	}
	
	
	
}
