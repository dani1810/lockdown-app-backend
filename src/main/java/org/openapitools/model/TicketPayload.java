package org.openapitools.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.lockdown.app.jpa.User;

/**
 * TicketPayload
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-03-21T20:43:12.797Z[GMT]")
@MappedSuperclass
public class TicketPayload {

    @Id
    @GeneratedValue
    @JsonIgnore
    private long id;

    @Version
    private int version;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @NotNull
    private User user;

    @JsonProperty("hashIdentityNumber")
    private String hashIdentityNumber;

    @JsonProperty("userPin")
    @Transient
    private Integer userPin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @NotNull
    @JsonProperty("startPosition")
    private Address startPosition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @NotNull
    @JsonProperty("finishPosition")
    private Address finishPosition;

    @JsonProperty("reason")
    private String reason;

    @JsonProperty("signature")
    private String signature;

    @JsonProperty("leaveTime")
    private OffsetDateTime leaveTime;

    @JsonProperty("arrivalTime")
    private OffsetDateTime arrivalTime;




    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public TicketPayload hashIdentityNumber(String hashIdentityNumber) {
        this.hashIdentityNumber = hashIdentityNumber;
        return this;
    }

    /**
     * Get hashIdentityNumber
     *
     * @return hashIdentityNumber
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public String getHashIdentityNumber() {
        return hashIdentityNumber;
    }

    public void setHashIdentityNumber(String hashIdentityNumber) {
        this.hashIdentityNumber = hashIdentityNumber;
    }

    public TicketPayload userPin(Integer userPin) {
        this.userPin = userPin;
        return this;
    }

    /**
     * Get userPin
     *
     * @return userPin
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public Integer getUserPin() {
        return userPin;
    }

    public void setUserPin(Integer userPin) {
        this.userPin = userPin;
    }

    public TicketPayload startPosition(Address startPosition) {
        this.startPosition = startPosition;
        return this;
    }

    /**
     * Get startPosition
     *
     * @return startPosition
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public Address getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Address startPosition) {
        this.startPosition = startPosition;
    }

    public TicketPayload finishPosition(Address finishPosition) {
        this.finishPosition = finishPosition;
        return this;
    }

    /**
     * Get finishPosition
     *
     * @return finishPosition
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public Address getFinishPosition() {
        return finishPosition;
    }

    public void setFinishPosition(Address finishPosition) {
        this.finishPosition = finishPosition;
    }

    public TicketPayload reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Get reason
     *
     * @return reason
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public TicketPayload signature(String signature) {
        this.signature = signature;
        return this;
    }

    /**
     * Get signature
     *
     * @return signature
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public TicketPayload leaveTime(OffsetDateTime leaveTime) {
        this.leaveTime = leaveTime;
        return this;
    }

    /**
     * Get leaveTime
     *
     * @return leaveTime
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public OffsetDateTime getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(OffsetDateTime leaveTime) {
        this.leaveTime = leaveTime;
    }

    public TicketPayload arrivalTime(OffsetDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    /**
     * Get arrivalTime
     *
     * @return arrivalTime
     */
    @ApiModelProperty(value = "")

    @Valid

    public OffsetDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(OffsetDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TicketPayload ticketPayload = (TicketPayload) o;
        return Objects.equals(this.hashIdentityNumber, ticketPayload.hashIdentityNumber) &&
                Objects.equals(this.userPin, ticketPayload.userPin) &&
                Objects.equals(this.startPosition, ticketPayload.startPosition) &&
                Objects.equals(this.finishPosition, ticketPayload.finishPosition) &&
                Objects.equals(this.reason, ticketPayload.reason) &&
                Objects.equals(this.signature, ticketPayload.signature) &&
                Objects.equals(this.leaveTime, ticketPayload.leaveTime) &&
                Objects.equals(this.arrivalTime, ticketPayload.arrivalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashIdentityNumber,
                userPin,
                startPosition,
                finishPosition,
                reason,
                signature,
                leaveTime,
                arrivalTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TicketPayload {\n");

        sb.append("    hashIdentityNumber: ").append(toIndentedString(hashIdentityNumber)).append("\n");
        sb.append("    userPin: ").append(toIndentedString(userPin)).append("\n");
        sb.append("    startPosition: ").append(toIndentedString(startPosition)).append("\n");
        sb.append("    finishPosition: ").append(toIndentedString(finishPosition)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
        sb.append("    leaveTime: ").append(toIndentedString(leaveTime)).append("\n");
        sb.append("    arrivalTime: ").append(toIndentedString(arrivalTime)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

