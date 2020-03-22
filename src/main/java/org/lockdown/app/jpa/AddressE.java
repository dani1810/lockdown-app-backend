package org.lockdown.app.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.lockdown.app.model.Address;

/**
 * Created by @author Jorge Machado on 22.03.20.
 */
@Entity
public class AddressE extends Address {

    @Id
    @GeneratedValue
    private long id;
}
