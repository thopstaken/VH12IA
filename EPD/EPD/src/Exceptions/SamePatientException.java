package Exceptions;

public class SamePatientException extends Exception {

	private static final long serialVersionUID = 1L;

	
	public SamePatientException(){}

	public SamePatientException(String message)
	{
		super(message);
	}

	public SamePatientException(Throwable cause)
	{
		super(cause);
	}

	public SamePatientException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
}