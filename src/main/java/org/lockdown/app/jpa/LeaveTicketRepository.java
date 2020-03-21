package org.lockdown.app.jpa;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
@Repository
public interface LeaveTicketRepository extends JpaRepository<LeaveTicket, Long> {

    Set<LeaveTicket> findByUser(User user);

}
