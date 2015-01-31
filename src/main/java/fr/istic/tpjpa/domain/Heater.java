package fr.istic.tpjpa.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("H")
public class Heater extends Devices {
	

}
