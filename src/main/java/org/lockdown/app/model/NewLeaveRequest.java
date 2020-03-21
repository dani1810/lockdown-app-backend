package org.lockdown.app.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * NewLeaveRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-03-21T14:31:13.518Z[GMT]")
public class NewLeaveRequest  extends PojoObject {
  @JsonProperty("hashIdentityNumber")
  private String hashIdentityNumber;

  @JsonProperty("userPin")
  private Integer userPin;

  @JsonProperty("startPosition")
  private String startPosition;

  @JsonProperty("finishPosition")
  private String finishPosition;

  @JsonProperty("reason")
  private String reason;

  @JsonProperty("signature")
  private String signature;

  @JsonProperty("leaveTime")
  private OffsetDateTime leaveTime;

  @JsonProperty("arrivalTime")
  private OffsetDateTime arrivalTime;

  public NewLeaveRequest hashIdentityNumber(String hashIdentityNumber) {
    this.hashIdentityNumber = hashIdentityNumber;
    return this;
  }

  /**
   * Get hashIdentityNumber
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

  public NewLeaveRequest userPin(Integer userPin) {
    this.userPin = userPin;
    return this;
  }

  /**
   * Get userPin
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

  public NewLeaveRequest startPosition(String startPosition) {
    this.startPosition = startPosition;
    return this;
  }

  /**
   * Get startPosition
   * @return startPosition
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getStartPosition() {
    return startPosition;
  }

  public void setStartPosition(String startPosition) {
    this.startPosition = startPosition;
  }

  public NewLeaveRequest finishPosition(String finishPosition) {
    this.finishPosition = finishPosition;
    return this;
  }

  /**
   * Get finishPosition
   * @return finishPosition
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getFinishPosition() {
    return finishPosition;
  }

  public void setFinishPosition(String finishPosition) {
    this.finishPosition = finishPosition;
  }

  public NewLeaveRequest reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * Get reason
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

  public NewLeaveRequest signature(String signature) {
    this.signature = signature;
    return this;
  }

  /**
   * Get signature
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

  public NewLeaveRequest leaveTime(OffsetDateTime leaveTime) {
    this.leaveTime = leaveTime;
    return this;
  }

  /**
   * Get leaveTime
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

  public NewLeaveRequest arrivalTime(OffsetDateTime arrivalTime) {
    this.arrivalTime = arrivalTime;
    return this;
  }

  /**
   * Get arrivalTime
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
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewLeaveRequest newLeaveRequest = (NewLeaveRequest) o;
    return Objects.equals(this.hashIdentityNumber, newLeaveRequest.hashIdentityNumber) &&
        Objects.equals(this.userPin, newLeaveRequest.userPin) &&
        Objects.equals(this.startPosition, newLeaveRequest.startPosition) &&
        Objects.equals(this.finishPosition, newLeaveRequest.finishPosition) &&
        Objects.equals(this.reason, newLeaveRequest.reason) &&
        Objects.equals(this.signature, newLeaveRequest.signature) &&
        Objects.equals(this.leaveTime, newLeaveRequest.leaveTime) &&
        Objects.equals(this.arrivalTime, newLeaveRequest.arrivalTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashIdentityNumber, userPin, startPosition, finishPosition, reason, signature, leaveTime, arrivalTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewLeaveRequest {\n");
    
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
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

