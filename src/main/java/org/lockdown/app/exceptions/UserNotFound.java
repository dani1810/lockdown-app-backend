package org.lockdown.app.exceptions;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
public class UserNotFound extends DomainException {

    @Override
    public String toString() {
        return "User Not Found for the pin and hash";
    }
}
