package org.openapitools.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * WorkTicketPayload
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-03-21T20:43:12.797Z[GMT]")
@Entity
@DiscriminatorValue("work")
public class WorkTicketPayload extends TicketPayload  {
  @JsonProperty("employerCode")
  private String employerCode;

  public WorkTicketPayload employerCode(String employerCode) {
    this.employerCode = employerCode;
    return this;
  }

  /**
   * Get employerCode
   * @return employerCode
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getEmployerCode() {
    return employerCode;
  }

  public void setEmployerCode(String employerCode) {
    this.employerCode = employerCode;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(employerCode.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkTicketPayload {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    employerCode: ").append(toIndentedString(employerCode)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

