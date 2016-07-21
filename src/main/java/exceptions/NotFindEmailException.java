package exceptions;

public class NotFindEmailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotFindEmailException(String message){
		super(message);
	}
}