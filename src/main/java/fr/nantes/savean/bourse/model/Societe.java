package fr.nantes.savean.bourse.model;

import java.util.ArrayList;
import java.util.List;

public class Societe {

	private List<Information> informationAnnuel;
	private String id;
	private String idElement;
	private String secteurActivite;
	private String codeIsin;
	private String symbSociete;
	private String indicePrincipal;
	private String bourseLabel;
	private String code;
	private String isin;
	private String nom;
	private List<Rendement> rendements;

	public List<Information> getInformationAnnuel() {
		return informationAnnuel;
	}

	public void setInformationAnnuel(List<Information> informationAnnuel) {
		this.informationAnnuel = informationAnnuel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdElement() {
		return idElement;
	}

	public void setIdElement(String idElement) {
		this.idElement = idElement;
	}

	public String getSecteurActivite() {
		return secteurActivite;
	}

	public void setSecteurActivite(String secteurActivite) {
		this.secteurActivite = secteurActivite;
	}

	public String getCodeIsin() {
		return codeIsin;
	}

	public void setCodeIsin(String codeIsin) {
		this.codeIsin = codeIsin;
		String[] codeSplit = codeIsin.split("_");
		code = codeSplit[0];
		isin = codeSplit[1];
	}

	public String getSymbSociete() {
		return symbSociete;
	}

	public void setSymbSociete(String symbSociete) {
		this.symbSociete = symbSociete;
	}

	public String getIndicePrincipal() {
		return indicePrincipal;
	}

	public void setIndicePrincipal(String indicePrincipal) {
		this.indicePrincipal = indicePrincipal;
	}

	public String getBourseLabel() {
		return bourseLabel;
	}

	public void setBourseLabel(String bourseLabel) {
		this.bourseLabel = bourseLabel;
	}

	public String getCode() {
		return code;
	}

	public String getIsin() {
		return isin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public List<Rendement> getRendements() {
		if (rendements == null) {
			rendements = new ArrayList<Rendement>();
		}
		return rendements;
	}

	public void setRendements(List<Rendement> rendements) {
		this.rendements = rendements;
	}

}
