package exceptions;

public class NotMatchPasswordException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotMatchPasswordException(String message){
		super(message);
	}
}