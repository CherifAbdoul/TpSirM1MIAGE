package fr.istic.tpjpa.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("E")
public class ElectronicDevice extends Devices {
	
//	private double consoMoyen;
//
//	public double getConsoMoyen() {
//		return consoMoyen;
//	}
//
//	public void setConsoMoyen(double consoMoyen) {
//		this.consoMoyen = consoMoyen;
//	}

}
