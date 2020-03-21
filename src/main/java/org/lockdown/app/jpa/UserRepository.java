package org.lockdown.app.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
public interface UserRepository extends JpaRepository<UserJPA, Long> {


    Optional<UserJPA> findByHashIdentityNumberAndUserPin(String hashIdentityNumber, Long userPin);
}
