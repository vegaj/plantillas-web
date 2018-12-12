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
public class NotAvailableException extends RuntimeException { 
    
    public NotAvailableException(int requested, int existing) {
        super(String.format("You tried to buy %d, but there are only %d", requested, existing));
    }
}
