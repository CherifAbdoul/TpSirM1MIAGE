package fr.istic.tpjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Home {
	
	private long idHome;
	private String adresse;
	private String adresseIP;
	private double superficie;
	private int nbPiece;
	private Person proprietaires;
	private List<Devices> equipements = new ArrayList<Devices>();
	
	//constructeur par defaut
	public Home() {
		
	}
	
	public Home(String adresse, String adresseIP, double superficie, int nbPiece, Person proprietaires){
		this.adresse = adresse;
		this.adresseIP = adresseIP;
		this.superficie = superficie;
		this.nbPiece = nbPiece;
		this.proprietaires = proprietaires;
		//equipements = new ArrayList<Devices>();
	}
	
	public Home(String adresse, String adresseIP, double superficie, int nbPiece){
		this.adresse = adresse;
		this.adresseIP = adresseIP;
		this.superficie = superficie;
		this.nbPiece = nbPiece;
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

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="person_id")
	public Person getProprietaires() {
		return proprietaires;
	}

	public void setProprietaires(Person proprietaires) {
		this.proprietaires = proprietaires;
	}

	
	@OneToMany(mappedBy="homeDevice", cascade = CascadeType.PERSIST)
	public List<Devices> getEquipements() {
		return equipements;
	}

	public void setEquipements(List<Devices> equipements) {
		this.equipements = equipements;
	}

	//ajout de devices
	public void addDevice(Devices device){
		this.equipements.add(device);
	        if(device.getHomeDevice() != this) {
	        	device.setHomeDevice(this);
	        
	    }
	}


}
