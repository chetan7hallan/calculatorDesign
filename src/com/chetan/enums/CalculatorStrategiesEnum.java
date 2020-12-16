package com.chetan.enums;

import com.chetan.operation.ArithmeticOperationStrategy;
import com.chetan.operation.impl.BodmasAdvancedArithmeticOperationStrategy;

/**
 * @author chetan.hallan
 *
 */
public enum CalculatorStrategiesEnum {
	
	BODMAS("BODMAS",1,new BodmasAdvancedArithmeticOperationStrategy());
	
	private String name;
	private int id;
	private ArithmeticOperationStrategy arithmeticOperationStrategy;
	
	CalculatorStrategiesEnum(String name, int id, ArithmeticOperationStrategy arithmeticOperationStrategy){
		this.name = name;
		this.id = id;
		this.setArithmeticOperationStrategy(arithmeticOperationStrategy);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the arithmeticOperationStrategy
	 */
	public ArithmeticOperationStrategy getArithmeticOperationStrategy() {
		return arithmeticOperationStrategy;
	}

	/**
	 * @param arithmeticOperationStrategy the arithmeticOperationStrategy to set
	 */
	public void setArithmeticOperationStrategy(ArithmeticOperationStrategy arithmeticOperationStrategy) {
		this.arithmeticOperationStrategy = arithmeticOperationStrategy;
	}
	
}
