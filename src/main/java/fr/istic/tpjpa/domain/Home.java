package fr.istic.tpjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Home {
	
	private long idHome;
	private String adresse;
	private String adresseIP;
	private double superficie;
	//private int consoMoyen;
	
	//constructeur par defaut
	public Home() {
		
	}
	
	public Home(String adresse, String adresseIP, double superficie){
		this.adresse = adresse;
		this.adresseIP = adresseIP;
		this.setSuperficie(superficie);
		
	}
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getIdHome() {
		return idHome;
	}
	public void setIdHome(long idHome) {
		this.idHome = idHome;
	}

//	public int getConsoMoyen() {
//		return consoMoyen;
//	}
//	public void setConsoMoyen(int consoMoyen) {
//		this.consoMoyen = consoMoyen;
//	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getAdresseIP() {
		return adresseIP;
	}


	public void setAdresseIP(String adresseIP) {
		this.adresseIP = adresseIP;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

}
