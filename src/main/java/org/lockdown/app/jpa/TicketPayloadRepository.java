package org.lockdown.app.jpa;

import java.util.Set;

import org.openapitools.model.TicketPayload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
@Repository
public interface TicketPayloadRepository extends JpaRepository<TicketPayload, Long> {

    Set<TicketPayload> findByUser(User user);

}
