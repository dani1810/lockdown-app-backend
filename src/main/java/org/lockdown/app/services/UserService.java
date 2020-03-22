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
    public Optional<UserE> getUserById(String hashedString, int pin) {
        return userRepository.findByHashIdentityNumberAndUserPin(hashedString, pin);
    }

    @Override
    public UserE createUser(String hashIdentityNumber, int userPin) {
        UserE userE = new UserE();
        userE.setUserId(userPin);
        userE.setHashIdentityNumber(hashIdentityNumber);
        final UserE save = userRepository.save(userE);
        return save;
    }

}
