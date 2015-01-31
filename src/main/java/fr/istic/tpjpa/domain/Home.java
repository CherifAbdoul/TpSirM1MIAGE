package fr.istic.tpjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Home {
	
	private long idHome;
	private String adresse;
	private String adresseIP;
	private double superficie;
	private int nbPiece;
	private Person proprietaires;
	
	
	//constructeur par defaut
	public Home() {
		
	}
	
	public Home(String adresse, String adresseIP, double superficie, int nbPiece, Person proprietaires){
		this.adresse = adresse;
		this.adresseIP = adresseIP;
		this.superficie = superficie;
		this.nbPiece = nbPiece;
		this.setProprietaires(proprietaires);
	}
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getIdHome() {
		return idHome;
	}
	public void setIdHome(long idHome) {
		this.idHome = idHome;
	}




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

	public int getNbPiece() {
		return nbPiece;
	}

	public void setNbPiece(int nbPiece) {
		this.nbPiece = nbPiece;
	}

	@ManyToOne
	public Person getProprietaires() {
		return proprietaires;
	}

	public void setProprietaires(Person proprietaires) {
		this.proprietaires = proprietaires;
	}



}
