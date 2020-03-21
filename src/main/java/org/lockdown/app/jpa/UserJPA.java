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
import org.lockdown.app.model.LeaveRequest;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"hashIdentityNumber", "userPin"})})
public class UserJPA {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "hashIdentityNumber")
    private String hashIdentityNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    @JsonIgnore
    private Set<LeaveRequest> leaveRequests;

    @Column(name = "userPin")
    private int userPin;


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
        UserJPA userJPA = (UserJPA) o;
        return userPin == userJPA.userPin &&
                Objects.equals(hashIdentityNumber, userJPA.hashIdentityNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashIdentityNumber, userPin);
    }

    public Set<LeaveRequest> getLeaveRequests() {
        return leaveRequests;
    }

    public void setLeaveRequests(Set<LeaveRequest> leaveRequests) {
        this.leaveRequests = leaveRequests;
    }
}
