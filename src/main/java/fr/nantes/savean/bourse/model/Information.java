package fr.nantes.savean.bourse.model;

import java.util.List;

public class Information {

	private String annee;
	private String resultatNetParGroupe;
	private String croissanceFutureEnPourcentage;
	private String resultatNet;
	private String chiffreAffaire;
	private String totalActif;
	private String totalPassif;
	private String capitauxpropre;

	private List<Data> datas;

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getCroissanceFutureEnPourcentage() {
		return croissanceFutureEnPourcentage;
	}

	public void setCroissanceFutureEnPourcentage(String croissanceFutureEnPourcentage) {
		this.croissanceFutureEnPourcentage = croissanceFutureEnPourcentage;
	}

	public String getResultatNet() {
		return resultatNet;
	}

	public void setResultatNet(String resultatNet) {
		this.resultatNet = resultatNet;
	}

	public List<Data> getDatas() {
		return datas;
	}

	public void setDatas(List<Data> datas) {
		this.datas = datas;
	}

	public String getChiffreAffaire() {
		return chiffreAffaire;
	}

	public void setChiffreAffaire(String chiffreAffaire) {
		this.chiffreAffaire = chiffreAffaire;
	}

	public String getTotalActif() {
		return totalActif;
	}

	public void setTotalActif(String totalActif) {
		this.totalActif = totalActif;
	}

	public String getTotalPassif() {
		return totalPassif;
	}

	public void setTotalPassif(String totalPassif) {
		this.totalPassif = totalPassif;
	}

	public String getCapitauxpropre() {
		return capitauxpropre;
	}

	public void setCapitauxpropre(String capitauxpropre) {
		this.capitauxpropre = capitauxpropre;
	}

	public String getResultatNetParGroupe() {
		return resultatNetParGroupe;
	}

	public void setResultatNetParGroupe(String resultatNetParGroupe) {
		this.resultatNetParGroupe = resultatNetParGroupe;
	}

}
