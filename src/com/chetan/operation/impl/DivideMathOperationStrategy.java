package com.chetan.operation.impl;

import java.math.BigInteger;

import com.chetan.operation.MathOperationStrategy;

/**
 * @author chetan.hallan
 *
 */
public class DivideMathOperationStrategy implements MathOperationStrategy {

	/**
	 * @see com.chetan.operation.MathOperationStrategy#calculate(java.math.BigInteger, java.math.BigInteger)
	 */
	@Override
	public BigInteger calculate(BigInteger var1, BigInteger var2) throws ArithmeticException {
		
		return var1.divide(var2);
	}

}
