package org.lockdown.app.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * TicketRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-03-21T20:43:12.797Z[GMT]")

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "reason", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = WorkTicketPayload.class, name = "work"),
        @JsonSubTypes.Type(value = FoodTicketPayload.class, name = "food"),
        @JsonSubTypes.Type(value = HealthTicketPayload.class, name = "health"),
        @JsonSubTypes.Type(value = HelpTicketPayload.class, name = "help"),
        @JsonSubTypes.Type(value = RecreationTicketPayload.class, name = "recreation"),
        @JsonSubTypes.Type(value = FamilyTicketPayload.class, name = "family"),
})
@DiscriminatorColumn(name = "reason")
@MappedSuperclass
public class TicketRequest {

    @JsonProperty("id")
    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("hashIdentityNumber")
    @Transient
    private String hashIdentityNumber;

    @JsonProperty("userPin")
    @Transient
    private Integer userPin;

    @JsonProperty("startPosition")
    private Address startPosition;

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

    public TicketRequest id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TicketRequest hashIdentityNumber(String hashIdentityNumber) {
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

    public TicketRequest userPin(Integer userPin) {
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

    public TicketRequest startPosition(Address startPosition) {
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

    public TicketRequest finishPosition(Address finishPosition) {
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

    public TicketRequest reason(String reason) {
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

    public TicketRequest signature(String signature) {
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

    public TicketRequest leaveTime(OffsetDateTime leaveTime) {
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

    public TicketRequest arrivalTime(OffsetDateTime arrivalTime) {
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
        TicketRequest ticketRequest = (TicketRequest) o;
        return Objects.equals(this.id, ticketRequest.id) &&
                Objects.equals(this.hashIdentityNumber, ticketRequest.hashIdentityNumber) &&
                Objects.equals(this.userPin, ticketRequest.userPin) &&
                Objects.equals(this.startPosition, ticketRequest.startPosition) &&
                Objects.equals(this.finishPosition, ticketRequest.finishPosition) &&
                Objects.equals(this.reason, ticketRequest.reason) &&
                Objects.equals(this.signature, ticketRequest.signature) &&
                Objects.equals(this.leaveTime, ticketRequest.leaveTime) &&
                Objects.equals(this.arrivalTime, ticketRequest.arrivalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                hashIdentityNumber,
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
        sb.append("class TicketRequest {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

