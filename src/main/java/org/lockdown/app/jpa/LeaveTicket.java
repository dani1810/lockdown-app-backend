package org.lockdown.app.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import org.openapitools.model.TicketPayload;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaveTicket extends TicketPayload {

}
