package fr.istic.tpjpa.domain;

public class Home {
	
	private long idHome;
	private int taille;
	private int consoMoyen;
	
	public Home() {
		
	}
	
	
	public long getIdHome() {
		return idHome;
	}
	public void setIdHome(long idHome) {
		this.idHome = idHome;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public int getConsoMoyen() {
		return consoMoyen;
	}
	public void setConsoMoyen(int consoMoyen) {
		this.consoMoyen = consoMoyen;
	}

}
