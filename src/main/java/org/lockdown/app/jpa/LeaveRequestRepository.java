package org.lockdown.app.jpa;

import java.util.Set;

import org.lockdown.app.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {



    Set<LeaveRequest> findByUser(UserJPA userJPA);

}
