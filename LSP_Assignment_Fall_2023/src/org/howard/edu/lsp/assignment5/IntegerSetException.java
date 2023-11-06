package org.howard.edu.lsp.assignment5;


/**
 * Implementation of IntegerSetException class for empty sets
 * @author Myles Block
 */
public class IntegerSetException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * throw EmptySetException with error string
	 * @param error ~ string
	 */
	public IntegerSetException(String error) {
		super(error);
	}
	
	/**
	 * throw EmptySetException without error string
	 */
	public IntegerSetException() {
	}

}
