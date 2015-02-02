package fr.istic.tpjpa.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
@Table(name="DEVICES")
public abstract class Devices {
	
	private long idDevice;
	private String nomDevice;
	private double consoMoyen;
	private Home homeDevice;
	
	//constructeur par défaut
	public Devices() {
		
	}
	
	public Devices(String nomDevice, double consoMoyen){
		
		this.nomDevice = nomDevice;
		this.consoMoyen = consoMoyen;
		
	}
	

	public Devices(String nomDevice, double consoMoyen, Home homeDevice){
		
		this.nomDevice = nomDevice;
		this.consoMoyen = consoMoyen;
		this.homeDevice = homeDevice;
		
	}
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getIdDevice() {
		return idDevice;
	}

	public void setIdDevice(long idDevice) {
		this.idDevice = idDevice;
	}

	public String getNomDevice() {
		return nomDevice;
	}

	public void setNomDevice(String nomDevice) {
		this.nomDevice = nomDevice;
	}

	public double getConsoMoyen() {
		return consoMoyen;
	}

	public void setConsoMoyen(double consoMoyen) {
		this.consoMoyen = consoMoyen;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="home_id")
	public Home getHomeDevice() {
		return homeDevice;
	}

	public void setHomeDevice(Home homeDevice) {
		this.homeDevice = homeDevice;
        if (!homeDevice.getEquipements().contains(this)) {
        	homeDevice.getEquipements().add(this);
        }
	}
	

}
