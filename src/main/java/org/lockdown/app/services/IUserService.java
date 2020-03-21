package org.lockdown.app.services;

import java.util.Optional;

import org.lockdown.app.jpa.User;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
public interface IUserService {


    public Optional<User> getUserById(String hashedString, long pin);

    public void createUser(String hashIdentityNumber, int userPin);

}
