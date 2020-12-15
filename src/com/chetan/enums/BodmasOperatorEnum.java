package com.chetan.enums;

/**
 * @author chetan.hallan
 *
 */
public enum BodmasOperatorEnum {

	ADDITION("+","add operation"),
	SUBTRACTION("-","subtract operation"),
	MULTIPLICATION("*","multiply operation"),
	DIVIDE("/", "device operation");
	
	/**
	 * To store the allowed operator.
	 */
	private String operator;
	
	/**
	 * Description regarding the operator
	 */
	private String description;
	
	BodmasOperatorEnum(String operator) {
		this.setOperator(operator);
	}
	
	BodmasOperatorEnum(String operator,String description) {
		this.setOperator(operator);
		this.setDescription(description);
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operation the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
