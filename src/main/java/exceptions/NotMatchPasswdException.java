package exceptions;

public class NotMatchPasswdException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotMatchPasswdException(String message){
		super(message);
	}
}