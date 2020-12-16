package com.chetan.helper;

import java.math.BigInteger;
import java.util.Deque;
import java.util.Stack;

import com.chetan.enums.BodmasOperatorEnum;
import com.chetan.exceptions.BodmasOperationException;

public class BodmasHelperUtil {
	
	public static boolean isValidBodmasOperator(char c) {
		
		if(Character.isSpaceChar(c))
			return false;
		
		for(BodmasOperatorEnum bodmasOperatorEnum : BodmasOperatorEnum.values()){
			if(bodmasOperatorEnum.getOperator().equals(c+"")) {
				return true;
			}
		}
		
		throw new BodmasOperationException(ErrorMessages.INVALID_OPERATOR);
	}


	public static Character getCorrectSign(Deque<Character> characters, Stack<BigInteger> integers) {
		
		if(integers.size() < characters.size()) {
			return characters.pollLast();
		}
		return characters.pollFirst();
	}


	public static BigInteger getDefaultIfNotExist(Stack<BigInteger> integers) {
		
		 if(integers.size() == 0) {
			 return new BigInteger("0");
		 }
		 
		return integers.pop();
	}

	public static boolean isOpenParenthesis( char c ) {
	     
		 if ( c=='(' || c=='[' || c=='{' )
	        return true;
	     else
	        return false;
     }

	 public static boolean isClosedParenthesis( char c ) {
	    
		 if ( c==')' || c==']' || c=='}' )
	        return true;
	     else
	        return false;
     }
	 
	 public static boolean hasPrecendence(char operator1, Character operator2) {
			
			if (isOpenParenthesis(operator2) || isClosedParenthesis(operator2)) 
				return false; 
			if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) 
				return false; 
			else
				return true;
		}


	public static void checkIfValid(char c) {
		
		if(!Character.isDigit(c)) {
			throw new BodmasOperationException(ErrorMessages.INVALID_INPUT);
		}
		
	}
}
