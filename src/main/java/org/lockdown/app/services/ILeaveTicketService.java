package org.lockdown.app.services;

import org.lockdown.app.jpa.User;
import org.openapitools.model.TicketPayload;
import org.openapitools.model.TicketRequest;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
public interface ILeaveTicketService {

    public TicketRequest addNewLeaveRequestToUser(TicketPayload payload);
}
