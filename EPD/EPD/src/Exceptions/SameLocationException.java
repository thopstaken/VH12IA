package Exceptions;

public class SameLocationException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public SameLocationException() {}
	
	public SameLocationException(String message)
	{
		super(message);
	}

	public SameLocationException(Throwable cause)
	{
		super(cause);
	}

	public SameLocationException(String message, Throwable cause)
	{
		super(message, cause);
	}
}