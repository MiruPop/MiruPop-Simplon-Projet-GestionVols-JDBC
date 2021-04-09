package co.simplon.JavaBeans;

import java.time.LocalTime;

public class Vol {
	private int id;
	private LocalTime h_depart;
	private LocalTime h_arrivee;
	private String siteDepart;
	private String siteArrivee;
	private Avion avion;
	private Pilote pilote;
	
	public Vol() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalTime getH_depart() {
		return h_depart;
	}

	public void setH_depart(LocalTime h_depart) {
		this.h_depart = h_depart;
	}

	public LocalTime getH_arrivee() {
		return h_arrivee;
	}

	public void setH_arrivee(LocalTime h_arrivee) {
		this.h_arrivee = h_arrivee;
	}

	public String getSiteDepart() {
		return siteDepart;
	}

	public void setSiteDepart(String siteDepart) {
		this.siteDepart = siteDepart;
	}

	public String getSiteArrivee() {
		return siteArrivee;
	}

	public void setSiteArrivee(String siteArrivee) {
		this.siteArrivee = siteArrivee;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Pilote getPilote() {
		return pilote;
	}

	public void setPilote(Pilote pilote) {
		this.pilote = pilote;
	}
}
