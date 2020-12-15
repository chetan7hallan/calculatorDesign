/**
 * 
 */
package com.chetan.operation.impl;

import java.math.BigInteger;
import java.util.Stack;
import com.chetan.operation.ArithmeticOperationStrategy;
import com.chetan.operation.OperatorStrategy;

/**
 * @author chetan.hallan
 *
 */
public class BodmasArithmeticOperationStrategy implements ArithmeticOperationStrategy {
	
	/**
	 * @see com.chetan.operation.ArithmeticOperationStrategy#findAnswer(java.lang.String)
	 */
	@Override
	public BigInteger findAnswer(String expression) {
		
		char[] tokens = expression.toCharArray();

		Stack<BigInteger> integers = new Stack<BigInteger>();

		Stack<Character> characters = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++){
			
			// skip whitespace
			if (tokens[i] == ' ')
				continue;

			if (tokens[i] >= '0' && tokens[i] <= '9')
			{
				StringBuffer sbuf = new StringBuffer();
				
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
					sbuf.append(tokens[i++]);
				}
				integers.push(new BigInteger(sbuf.toString()));
				i--;
			}

			else if (tokens[i] == '(') {
				characters.push(tokens[i]);
			}

			else if (tokens[i] == ')')
			{
				while (characters.peek() != '(') {
					integers.push(applyOperation(characters.pop(),integers.pop(),integers.pop()));
				}
				characters.pop();
			}

			else if (tokens[i] == '+' || tokens[i] == '-' ||
					tokens[i] == '*' || tokens[i] == '/')
			{
				
				while (!characters.empty() && hasPrecendence(tokens[i], characters.peek())) {
					integers.push(applyOperation(characters.pop(), integers.pop(),integers.pop()));
				}
				characters.push(tokens[i]);
			}
		}

		while (!characters.empty()) {
			integers.push(applyOperation(characters.pop(), integers.pop(), integers.pop()));
		}

		if(integers.size()>1) {
			System.out.println("OPERATION NOT CONFIGURED");
			return new BigInteger("0");
		}
		return integers.pop();
	}
	
	private boolean hasPrecendence(char operator1, Character operator2) {
		
		if (operator2 == '(' || operator2 == ')') 
			return false; 
		if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) 
			return false; 
		else
			return true;
	}

	private BigInteger applyOperation(Character operation, BigInteger var2, BigInteger var1) {
		
		OperatorStrategy operatorStrategy = null;
		
		switch(operation) {
			case '+' : operatorStrategy = new AddOperatorStrategy();
			break;
			
			case '-' : operatorStrategy = new SubtractOperatorStrategy();
			break;
	
			case '*' : operatorStrategy = new MultiplicationOperatorStrategy();
			break;
	
			case '/' : operatorStrategy = new DivideOperatorStrategy();
			break;
		}
		
		return operatorStrategy.calculate(var1, var2);
	}
}
