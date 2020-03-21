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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import org.openapitools.model.TicketPayload;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"hashIdentityNumber", "userPin"})})
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "hashIdentityNumber")
    private String hashIdentityNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = TicketPayload.class)
    @JsonIgnore
    private Set<TicketPayload> ticketPayloads;

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
        User user = (User) o;
        return userPin == user.userPin &&
                Objects.equals(hashIdentityNumber, user.hashIdentityNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashIdentityNumber, userPin);
    }

    public Set<TicketPayload> getTicketPayloads() {
        return ticketPayloads;
    }

    public void setTicketPayloads(Set<TicketPayload> TicketPayloads) {
        this.ticketPayloads = TicketPayloads;
    }

}
