package fr.nantes.savean.bourse.model;

import java.util.List;

public class Information {

	private String annee;
	private Double beneficeTotal;
	private Double nombredeTitreEnCirulation;
	private Double croissanceFutureEnPourcentage;
	private Double capitauxPropre;
	private Double resultatNet;
	private List<Data> datas;

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public Double getBeneficeTotal() {
		return beneficeTotal;
	}

	public void setBeneficeTotal(Double beneficeTotal) {
		this.beneficeTotal = beneficeTotal;
	}

	public Double getNombredeTitreEnCirulation() {
		return nombredeTitreEnCirulation;
	}

	public void setNombredeTitreEnCirulation(Double nombredeTitreEnCirulation) {
		this.nombredeTitreEnCirulation = nombredeTitreEnCirulation;
	}

	public List<Data> getDatas() {
		return datas;
	}

	public void setDatas(List<Data> datas) {
		this.datas = datas;
	}

	public Double getCroissanceFutureEnPourcentage() {
		return croissanceFutureEnPourcentage;
	}

	public void setCroissanceFutureEnPourcentage(Double croissanceFutureEnPourcentage) {
		this.croissanceFutureEnPourcentage = croissanceFutureEnPourcentage;
	}

	

	public Double getCapitauxPropre() {
		return capitauxPropre;
	}

	public void setCapitauxPropre(Double capitauxPropre) {
		this.capitauxPropre = capitauxPropre;
	}

	public Double getResultatNet() {
		return resultatNet;
	}

	public void setResultatNet(Double resultatNet) {
		this.resultatNet = resultatNet;
	}

}
