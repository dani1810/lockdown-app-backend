package org.lockdown.app.exceptions;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
public class TicketPayloadOnFuture extends DomainException {

    @Override
    public String toString() {
        return "The Leave Request is on the Future and therefore not valid";
    }
}
