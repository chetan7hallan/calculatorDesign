package com.chetan.operation.impl;

import java.math.BigInteger;

import com.chetan.operation.OperatorStrategy;

/**
 * @author chetan.hallan
 *
 */
public class SubtractOperatorStrategy implements OperatorStrategy {

	/** 
	 * com.chetan.operation.MathOperationStrategy#calculate(java.math.BigInteger, java.math.BigInteger)
	 */
	@Override
	public BigInteger calculate(BigInteger var1, BigInteger var2) {
		
		return var1.subtract(var2);
	}

}
