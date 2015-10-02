/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.exceptions;

/**
 *
 * @author Ant
 */
public class SimpleException extends Exception {
    
    int errorCode = -1;
    Exception originalException = null;
    Exception extraException = null;
    
    public SimpleException(String message) {
        this(null, null, message, -1);
    }
    
    public SimpleException(Exception originalException, Exception extraException, String message, int errorCode) {
        super(originalException != null ? originalException.getMessage() : message);
        if (originalException != null && originalException.getClass() == this.getClass()) {
            this.errorCode = ((SimpleException) originalException).getErrorCode();
        } else {
            this.errorCode=errorCode;
            this.originalException = originalException;
            this.extraException = extraException;
        }
    }
    
    public int getErrorCode() {
        return errorCode;
    }
}
