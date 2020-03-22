package org.lockdown.app.services;

import java.util.Optional;

import org.lockdown.app.jpa.UserE;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
public interface IUserService {


    public Optional<UserE> getUserById(String hashedString, int pin);

    public UserE createUser(String hashIdentityNumber, int userPin);

}
