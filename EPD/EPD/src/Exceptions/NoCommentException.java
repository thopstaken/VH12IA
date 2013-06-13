package Exceptions;

public class NoCommentException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public NoCommentException(){}

    public NoCommentException(String message)
    {
            super(message);
    }

    public NoCommentException(Throwable cause)
    {
            super(cause);
    }

    public NoCommentException(String message, Throwable cause)
    {
            super(message, cause);
    }
}
