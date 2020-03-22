package org.lockdown.app.jpa;

import java.util.Optional;
import java.util.Set;

import org.lockdown.app.model.TicketPayload;
import org.lockdown.app.model.TicketRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
@Repository
public interface TicketRequestloadRepository extends JpaRepository<TicketRequestE, Long> {

    Set<TicketRequestE> findByUser(UserE userE);
    Optional<TicketRequestE> findById(long id);

}
