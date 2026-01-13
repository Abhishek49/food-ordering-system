package org.example.exceptions;

/**
 * @author abhishekraj
 **/
public class BadRequest extends Exception{
    public BadRequest(String message) {
        super(message);
    }
}
