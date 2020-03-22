package org.lockdown.app.jpa;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.lockdown.app.model.TicketPayload;
import org.lockdown.app.model.TicketRequest;

/**
 * User Entity
 */
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"hashIdentityNumber", "userPin"})})
public class UserE {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "hashIdentityNumber")
    private String hashIdentityNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JsonIgnore
    private Set<TicketRequestE> ticketRequests;

    @Column(name = "userPin")
    private int userPin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHashIdentityNumber() {
        return hashIdentityNumber;
    }

    public void setHashIdentityNumber(String hashIdentityNumber) {
        this.hashIdentityNumber = hashIdentityNumber;
    }

    public int getUserPin() {
        return userPin;
    }

    public void setUserPin(int userPin) {
        this.userPin = userPin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserE userE = (UserE) o;
        return userPin == userE.userPin &&
                Objects.equals(hashIdentityNumber, userE.hashIdentityNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashIdentityNumber, userPin);
    }

    public Set<TicketRequestE> getTicketPayloads() {
        return ticketRequests;
    }

    public void setTicketPayloads(Set<TicketRequestE> ticketRequests) {
        this.ticketRequests = ticketRequests;
    }

}
