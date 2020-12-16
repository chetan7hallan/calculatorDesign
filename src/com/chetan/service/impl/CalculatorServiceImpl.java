package com.chetan.service.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import com.chetan.enums.CalculatorStrategiesEnum;
import com.chetan.exceptions.BodmasOperationException;
import com.chetan.operation.ArithmeticOperationStrategy;
import com.chetan.service.CalculatorService;

/**
 * @author chetan.hallan
 *
 */
public class CalculatorServiceImpl implements CalculatorService{

	/**
	 * All strategies available MAP
	 */
	Map<String, ArithmeticOperationStrategy> strategies;
	
	{
		strategies = new HashMap<>();
		CalculatorStrategiesEnum[] calculatorStrategies = CalculatorStrategiesEnum.values();
		for(CalculatorStrategiesEnum cal : calculatorStrategies) {
			strategies.put(cal.getName(), cal.getArithmeticOperationStrategy());
		}
		
	}
	
	@Override
	public BigInteger calculate(String expression) {

		BigInteger result = null;
		result = performBodmas(expression);
		return result;
	}


	private BigInteger performBodmas(String expression) {
		
		BigInteger result = new BigInteger("0");
		
		try {
			return strategies.get(CalculatorStrategiesEnum.BODMAS.getName()).findAnswer(expression);
		}catch(ArithmeticException ex) {
			System.out.println("INVALID ARITHMETIC OPERATION");
		}catch(BodmasOperationException ex) {
			System.out.println(ex.getErrorMsg());
		}
		
		return result;
	}
}
