package exceptions;

public class AlreadyExistAccountException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlreadyExistAccountException(String message){
		super(message);
	}

}
