package Exceptions;

public class BackToTheFutureException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public BackToTheFutureException(){}

    public BackToTheFutureException(String message)
    {
            super(message);
    }

    public BackToTheFutureException(Throwable cause)
    {
            super(cause);
    }

    public BackToTheFutureException(String message, Throwable cause)
    {
            super(message, cause);
    }
}
