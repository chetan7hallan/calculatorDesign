package com.chetan.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import com.chetan.enums.BodmasOperatorEnum;
import com.chetan.service.CalculatorService;
import com.chetan.service.impl.CalculatorServiceImpl;

/**
 * @author chetan.hallan
 *
 */
public class MainController {

	static CalculatorService calculatorService;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		calculatorService = new CalculatorServiceImpl();
		showCalculatorOperations();
		performOperation(takeInput());
		
	}
	
	private static void showCalculatorOperations() {
		
		BodmasOperatorEnum[] operations = BodmasOperatorEnum.values();
		System.out.print("CALCULATOR::OPERATIONS ALLOWED (Operand operator operand)");
		for(BodmasOperatorEnum operation : operations) {
			System.out.print(" "+operation.getOperator());
		}
		System.out.println();
	}
	
	private static String takeInput() {
		
		System.out.print("Input : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String inputString = null;
		try {
			inputString = reader.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return inputString;
	}
	
	private static void performOperation(String inputString) {
		
		BigInteger result = calculatorService.calculate(inputString);
		System.out.println("Output: "+result.toString());
		
	}


	
}
