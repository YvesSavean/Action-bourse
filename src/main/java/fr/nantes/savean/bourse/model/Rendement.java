package fr.nantes.savean.bourse.model;

public class Rendement {
	
	private String annee;
	private Double montant;
	private Double Cours;
	private Double rendement;
	
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Double getCours() {
		return Cours;
	}
	public void setCours(Double cours) {
		Cours = cours;
	}
	public Double getRendement() {
		return rendement;
	}
	public void setRendement(Double rendement) {
		this.rendement = rendement;
	}
	
	
}
