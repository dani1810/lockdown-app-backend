package org.lockdown.app.services;

import java.util.Optional;

import org.lockdown.app.jpa.UserE;
import org.lockdown.app.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<UserE> getUserById(String hashedString, long pin) {
        return null;
    }

    @Override
    public void createUser(String hashIdentityNumber, int userPin) {

    }

}
