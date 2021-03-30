package io.github.twosquirrels.httpasfunctions;

/*
 * An exception class that extends from RuntimeException that has a status code
 * @author TwoSquirrels
 * @version 1.2.2
 */
public class HaFException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    private final int code;
    private final String message;
    
    public HaFException(int code) {
        this.code = code;
        this.message = null;
    }
    
    public HaFException(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public int getStatusCode() {
        return code;
    }
    
    public String getStatusMessage() {
        return new StatusMessages().get(this.code);
    }
    
    @Override
    public String getMessage() {
        return this.message;
    }
    
}
