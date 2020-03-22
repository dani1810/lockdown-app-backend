package org.lockdown.app.services;

import java.util.Optional;
import java.util.Set;

import org.lockdown.app.model.TicketPayload;
import org.lockdown.app.model.TicketRequest;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
public interface ITicketPayloadService {

    TicketRequest addNewLeaveRequestToUser(TicketPayload payload);

    Set<TicketRequest> getByHashAndPin(String hash, int pin);

    Optional<TicketRequest> getByTicketRequestIdAndPin(long ticketId, int pin);
}
