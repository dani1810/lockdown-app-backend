package org.lockdown.app.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.MappedSuperclass;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public class PojoObject implements Serializable {

}
