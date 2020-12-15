package com.chetan.service.impl;

import java.math.BigInteger;

import com.chetan.operation.impl.BodmasArithmeticOperationStrategy;
import com.chetan.service.CalculatorService;

/**
 * @author chetan.hallan
 *
 */
public class CalculatorServiceImpl implements CalculatorService{

	BodmasArithmeticOperationStrategy bodmasArithmeticOperationStrategy;
	
	@Override
	public BigInteger calculate(String expression) {

		initialize();
		BigInteger result = null;
		result = performBodmas(expression);
		return result;
	}

	private void initialize() {
		bodmasArithmeticOperationStrategy = new BodmasArithmeticOperationStrategy();
		
	}

	private BigInteger performBodmas(String expression) {
		
		BigInteger result = new BigInteger("0");
		
		try {
			return bodmasArithmeticOperationStrategy.findAnswer(expression);
		}catch(ArithmeticException ex) {
			System.out.println("INVALID ARITHMETIC OPERATION");
		}
		
		return result;
	}
}
