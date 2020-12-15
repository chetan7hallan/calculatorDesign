package com.chetan.operation.impl;

import java.math.BigInteger;

import com.chetan.operation.OperatorStrategy;

/**
 * @author chetan.hallan
 *
 */
public class MultiplicationOperatorStrategy implements OperatorStrategy {

	/**
	 * @see com.chetan.operation.OperatorStrategy#calculate(java.math.BigInteger, java.math.BigInteger)
	 */
	@Override
	public BigInteger calculate(BigInteger var1, BigInteger var2) {
		
		return var1.multiply(var2);
	}

}
