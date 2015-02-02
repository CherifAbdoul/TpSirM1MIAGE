package fr.istic.tpjpa.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
public class Person {
	
	private long idPers;
	private String nom;
	private String prenom;
	private String mail;
	private String genre;
	
	@Temporal(TemporalType.DATE)
	private Calendar dateNais;
	
	@Transient
	private String profil;
	
	//OneToMany : liste de residence
	private List<Home> residences = new ArrayList<Home>();
	
	/**
	 *  
	@ManyToMany	
	@JoinTable(name = "relationships", 
       joinColumns = @JoinColumn(name = "user_id"), 
       inverseJoinColumns = @JoinColumn(name = "friend_id"))
   protected List friends = null;
   @ManyToMany(mappedBy = "friends")
   protected List befriended = null;
	 * 
	 */
	
	private List<Person> relationships = new ArrayList<Person>();
	
	//constructeur par defaut
	public Person() {
		
	}
	
	//constructeur de la classe avec parametres
	public Person(String nom, String prenom, String mail, String genre ,Calendar dateNais, String profil)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.genre = genre;
		this.dateNais = dateNais;
		this.profil = profil;
		
	}
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getIdPers() {
		return idPers;
	}
	

	
	public void setIdPers(long idPers) {
		this.idPers = idPers;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Calendar getDateNais() {
		return dateNais;
	}



	public void setDateNais(Calendar dateNais) {
		this.dateNais = dateNais;
	}



	public String getProfil() {
		return profil;
	}



	public void setProfil(String profil) {
		this.profil = profil;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}

	@OneToMany(mappedBy = "proprietaires", cascade= CascadeType.PERSIST)
	public List<Home> getResidences() {
		return residences;
	}

	public void setResidences(List<Home> residences) {
		this.residences = residences;
	}

	
	@ManyToMany//(mappedBy = "friends")
	@JoinTable(name="friends")
	public List<Person> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<Person> relationships) {
		this.relationships = relationships;
	}
	
	 public void addHome(Home home) {
	        this.residences.add(home);
	        if (home.getProprietaires() != this) {
	        	home.setProprietaires(this);
	        }
	  }
	
	//ajout de devices
	public void addPerson(Person person){
		this.relationships.add(person);
//	        if(person.get != this) {
//	        	device.setHomeDevice(this);
//	        
//	    }
	}



}
