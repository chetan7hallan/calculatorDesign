package com.chetan.operation.impl;

import java.math.BigInteger;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import com.chetan.exceptions.BodmasOperationException;
import com.chetan.helper.BodmasHelperUtil;
import com.chetan.helper.ErrorMessages;
import com.chetan.operation.ArithmeticOperationStrategy;
import com.chetan.operation.OperatorStrategy;

public class BodmasAdvancedArithmeticOperationStrategy implements ArithmeticOperationStrategy {

	@Override
	public BigInteger findAnswer(String expression) {
		
		expression.replaceAll("\\s", "");
		
		char[] tokens = expression.toCharArray();

		Stack<BigInteger> integers = new Stack<BigInteger>();
		Deque<Character> characters = new LinkedList<Character>();

		for (int i = 0; i < tokens.length; i++){
			
			if (Character.isDigit(tokens[i])) {
				
				StringBuffer sbuf = new StringBuffer();
				
				while (i < tokens.length && Character.isDigit(tokens[i])) {
					sbuf.append(tokens[i++]);
				}
				integers.push(new BigInteger(sbuf.toString()));
				i--;
			}

			else if (BodmasHelperUtil.isOpenParenthesis(tokens[i])) {
				characters.push(tokens[i]);
			}

			else if (BodmasHelperUtil.isClosedParenthesis(tokens[i])) {
				while (!BodmasHelperUtil.isOpenParenthesis(characters.peek())) {
					integers.push(applyOperation(BodmasHelperUtil.getCorrectSign(characters, integers), 
							BodmasHelperUtil.getDefaultIfNotExist(integers), BodmasHelperUtil.getDefaultIfNotExist(integers)));
				}
				characters.poll();
			}

			else if (BodmasHelperUtil.isValidBodmasOperator(tokens[i]))
			{
				while (!characters.isEmpty() && BodmasHelperUtil.hasPrecendence(tokens[i], characters.peek())) {
					integers.push(applyOperation(BodmasHelperUtil.getCorrectSign(characters, integers), 
							BodmasHelperUtil.getDefaultIfNotExist(integers), BodmasHelperUtil.getDefaultIfNotExist(integers)));
				}
				characters.push(tokens[i]);
			}
		}
		

		while (!characters.isEmpty()) {
			integers.push(applyOperation(BodmasHelperUtil.getCorrectSign(characters, integers), 
					BodmasHelperUtil.getDefaultIfNotExist(integers), BodmasHelperUtil.getDefaultIfNotExist(integers)));
		}
		return integers.pop();
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
		
		if(operatorStrategy == null) {
			throw new BodmasOperationException(ErrorMessages.INVALID_OPERATOR);
		}
		
		return operatorStrategy.calculate(var1, var2);
	}

}
