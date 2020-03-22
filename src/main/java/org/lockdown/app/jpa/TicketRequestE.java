package org.lockdown.app.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.lockdown.app.model.TicketRequest;

/**
 * Created by @author Jorge Machado on 22.03.20.
 */
@Entity(name = "ticket_request")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TICKET_TYPE",
        discriminatorType= DiscriminatorType.STRING)
public class TicketRequestE extends TicketRequest {

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private UserE user;

    public UserE getUser() {
        return user;
    }

    public void setUser(UserE user) {
        this.user = user;
    }

}
