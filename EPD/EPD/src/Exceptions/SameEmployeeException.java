package Exceptions;

public class SameEmployeeException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public SameEmployeeException(){}

	public SameEmployeeException(String message)
	{
		super(message);
	}

	public SameEmployeeException(Throwable cause)
	{
		super(cause);
	}

	public SameEmployeeException(String message, Throwable cause)
	{
		super(message, cause);
	}
}