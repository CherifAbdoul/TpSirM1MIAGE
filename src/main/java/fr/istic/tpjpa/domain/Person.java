package fr.istic.tpjpa.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	
	private int idPers;
	private String nom;
	private String prenom;
	private String mail;
	private int age;
	private Calendar dateNais;
	private String profil;
	
	
	
	public Person() {
		
	}
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdPers() {
		return idPers;
	}



	public void setIdPers(int idPers) {
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



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
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

}
