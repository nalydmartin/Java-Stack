package com.codingdojo.calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator calc1 = new Calculator();
		
		Calculator calc2 = new Calculator(9, 10);
		
		
		// Test for calc1 
		
		calc1.setOperandOne(50);
		calc1.setOperandTwo(20);
		calc1.setOperation("-");
		calc1.performOperation();
		System.out.println(calc1.getResults());
		
		
		// Test for calc2
		
		calc2.setOperation("+");
		calc2.performOperation();
		System.out.println(calc2.getResults());
		
		
		
	}

}
