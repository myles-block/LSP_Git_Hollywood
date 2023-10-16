package org.howard.edu.lsp.assignment4;

public class EmptySetException extends Exception {
	/**
	 * IntegerSetException for empty sets
	 */
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
