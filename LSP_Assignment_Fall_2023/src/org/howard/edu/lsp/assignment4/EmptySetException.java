package org.howard.edu.lsp.assignment4;


/**
 * Implementation of IntegerSetException class for empty sets
 * @author Myles Block
 */
public class EmptySetException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * throw EmptySetException with error string
	 * @param error ~ string
	 */
	public EmptySetException(String error) {
		super(error);
	}
	
	/**
	 * throw EmptySetException without error string
	 */
	public EmptySetException() {
	}

}
