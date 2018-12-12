/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

/**
 *
 * @author jose
 */
public class ValidationException extends RuntimeException { 
    
    public ValidationException(String field, String cause) {
        super(String.format("Entity validation failed for field <%s>. Cause <%s>.", field,cause));
    }
}
