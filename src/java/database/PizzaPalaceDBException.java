package database;

/**
 * NotesDBException - Passes exception
 * @author Declan is not a great manager
 */
public class PizzaPalaceDBException extends Exception {
    
    /**
     * Sends message from superclass Exception when there is an exception
     * @param message 
     */
    public PizzaPalaceDBException (String message)
    {
        super(message);
    }
    
    
}
