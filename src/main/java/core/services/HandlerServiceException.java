package core.services;

/**
 * Created by Altair on 25.09.2017.
 */
public class HandlerServiceException extends Exception{

    public HandlerServiceException(String message){
        super("Exception in the service: "+message);
    }

    public HandlerServiceException(String message, Throwable cause){
        super("Exception in the service: "+message, cause);
    }
}
