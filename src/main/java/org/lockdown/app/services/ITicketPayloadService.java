package org.lockdown.app.services;

import java.util.Set;

import org.openapitools.model.TicketPayload;
import org.openapitools.model.TicketRequest;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
public interface ITicketPayloadService {

    TicketRequest addNewLeaveRequestToUser(TicketPayload payload);

    Set<TicketPayload> getByHashAndPin(String hash, int pin);
}
