package vttp.paf.day22workshop.models;

public class RecordNotFoundException extends RuntimeException {
    
    public RecordNotFoundException(String message){
        super(message);
    }

    public RecordNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
    
}
