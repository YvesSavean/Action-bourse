package fr.nantes.savean.bourse.model;

import java.util.List;

public class Information {

	private String annee;
	private String ProduitNetBancaire;
	private String ChargesGeneralesExploitation;
	private String ResultatBrutExploitation;
	private String CoutDuRisque;
	private String ResultatExploitation;
	private String QuotePartResultatsDesSociétesMisesEnEquivalence;
	private String ResultatCourantAvantImpot;
	private String ResultatNet;
	private String ResultatNetPartDuGroupe;
	private String CaisseBanquesCentralesCcp;
	private String ActifsFinALaJusteValeurParResultat;
	private String InstrumentsDerivesDeCouverture;
	private String ActifsFinanciersDispoALaVente;
	private String ActifsFinDétenusALecheance;
	private String PretsEtAvancesSurLesEtsDeCrédit;
	private String TotalCreancesClientele;
	private String Immobilisations;
	private String AutresActifs;
	private String TotalActif;
	private String BanquesCentralesCCP;
	private String PassifsFinALaJusteValPaResultat;
	private String DettesEnversLesEtsDeCredit;
	private String DettesAupresDeLaClientele;
	private String DettesRepresenteesParUnTitre;
	private String DettesSubordonnees;
	private String ProvisionsTechniquesDesContratsAss;
	private String CapitauxPropres;
	private String AutresPassifs;
	private String TotalPassif;
	private String ResultatNetPartDuGroupeParAction;
	private String ResultatNetPartDuGroupeDilueParAction;
	private String CoefficientExploitation;
	private String RatioInternationalDeSolvabilité;
	private String RentabiliteDesFondsPropres;
	private String EffectifEnFinAnnee;
	private String EffectifMoyen;
	private List<Data> datas;
	
	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getProduitNetBancaire() {
		return ProduitNetBancaire;
	}

	public void setProduitNetBancaire(String produitNetBancaire) {
		ProduitNetBancaire = produitNetBancaire;
	}

	public String getChargesGeneralesExploitation() {
		return ChargesGeneralesExploitation;
	}

	public void setChargesGeneralesExploitation(String chargesGeneralesExploitation) {
		ChargesGeneralesExploitation = chargesGeneralesExploitation;
	}

	public String getResultatBrutExploitation() {
		return ResultatBrutExploitation;
	}

	public void setResultatBrutExploitation(String resultatBrutExploitation) {
		ResultatBrutExploitation = resultatBrutExploitation;
	}

	public String getCoutDuRisque() {
		return CoutDuRisque;
	}

	public void setCoutDuRisque(String coutDuRisque) {
		CoutDuRisque = coutDuRisque;
	}

	public String getResultatExploitation() {
		return ResultatExploitation;
	}

	public void setResultatExploitation(String resultatExploitation) {
		ResultatExploitation = resultatExploitation;
	}

	public String getQuotePartResultatsDesSociétesMisesEnEquivalence() {
		return QuotePartResultatsDesSociétesMisesEnEquivalence;
	}

	public void setQuotePartResultatsDesSociétesMisesEnEquivalence(
			String quotePartResultatsDesSociétesMisesEnEquivalence) {
		QuotePartResultatsDesSociétesMisesEnEquivalence = quotePartResultatsDesSociétesMisesEnEquivalence;
	}

	public String getResultatCourantAvantImpot() {
		return ResultatCourantAvantImpot;
	}

	public void setResultatCourantAvantImpot(String resultatCourantAvantImpot) {
		ResultatCourantAvantImpot = resultatCourantAvantImpot;
	}

	public String getResultatNet() {
		return ResultatNet;
	}

	public void setResultatNet(String resultatNet) {
		ResultatNet = resultatNet;
	}

	public String getResultatNetPartDuGroupe() {
		return ResultatNetPartDuGroupe;
	}

	public void setResultatNetPartDuGroupe(String resultatNetPartDuGroupe) {
		ResultatNetPartDuGroupe = resultatNetPartDuGroupe;
	}

	public String getCaisseBanquesCentralesCcp() {
		return CaisseBanquesCentralesCcp;
	}

	public void setCaisseBanquesCentralesCcp(String caisseBanquesCentralesCcp) {
		CaisseBanquesCentralesCcp = caisseBanquesCentralesCcp;
	}

	public String getActifsFinALaJusteValeurParResultat() {
		return ActifsFinALaJusteValeurParResultat;
	}

	public void setActifsFinALaJusteValeurParResultat(String actifsFinALaJusteValeurParResultat) {
		ActifsFinALaJusteValeurParResultat = actifsFinALaJusteValeurParResultat;
	}

	public String getInstrumentsDerivesDeCouverture() {
		return InstrumentsDerivesDeCouverture;
	}

	public void setInstrumentsDerivesDeCouverture(String instrumentsDerivesDeCouverture) {
		InstrumentsDerivesDeCouverture = instrumentsDerivesDeCouverture;
	}

	public String getActifsFinanciersDispoALaVente() {
		return ActifsFinanciersDispoALaVente;
	}

	public void setActifsFinanciersDispoALaVente(String actifsFinanciersDispoALaVente) {
		ActifsFinanciersDispoALaVente = actifsFinanciersDispoALaVente;
	}

	public String getActifsFinDétenusALecheance() {
		return ActifsFinDétenusALecheance;
	}

	public void setActifsFinDétenusALecheance(String actifsFinDétenusALecheance) {
		ActifsFinDétenusALecheance = actifsFinDétenusALecheance;
	}

	public String getPretsEtAvancesSurLesEtsDeCrédit() {
		return PretsEtAvancesSurLesEtsDeCrédit;
	}

	public void setPretsEtAvancesSurLesEtsDeCrédit(String pretsEtAvancesSurLesEtsDeCrédit) {
		PretsEtAvancesSurLesEtsDeCrédit = pretsEtAvancesSurLesEtsDeCrédit;
	}

	public String getTotalCreancesClientele() {
		return TotalCreancesClientele;
	}

	public void setTotalCreancesClientele(String totalCreancesClientele) {
		TotalCreancesClientele = totalCreancesClientele;
	}

	public String getImmobilisations() {
		return Immobilisations;
	}

	public void setImmobilisations(String immobilisations) {
		Immobilisations = immobilisations;
	}

	public String getAutresActifs() {
		return AutresActifs;
	}

	public void setAutresActifs(String autresActifs) {
		AutresActifs = autresActifs;
	}

	public String getTotalActif() {
		return TotalActif;
	}

	public void setTotalActif(String totalActif) {
		TotalActif = totalActif;
	}

	public String getBanquesCentralesCCP() {
		return BanquesCentralesCCP;
	}

	public void setBanquesCentralesCCP(String banquesCentralesCCP) {
		BanquesCentralesCCP = banquesCentralesCCP;
	}

	public String getPassifsFinALaJusteValPaResultat() {
		return PassifsFinALaJusteValPaResultat;
	}

	public void setPassifsFinALaJusteValPaResultat(String passifsFinALaJusteValPaResultat) {
		PassifsFinALaJusteValPaResultat = passifsFinALaJusteValPaResultat;
	}

	public String getDettesEnversLesEtsDeCredit() {
		return DettesEnversLesEtsDeCredit;
	}

	public void setDettesEnversLesEtsDeCredit(String dettesEnversLesEtsDeCredit) {
		DettesEnversLesEtsDeCredit = dettesEnversLesEtsDeCredit;
	}

	public String getDettesAupresDeLaClientele() {
		return DettesAupresDeLaClientele;
	}

	public void setDettesAupresDeLaClientele(String dettesAupresDeLaClientele) {
		DettesAupresDeLaClientele = dettesAupresDeLaClientele;
	}

	public String getDettesRepresenteesParUnTitre() {
		return DettesRepresenteesParUnTitre;
	}

	public void setDettesRepresenteesParUnTitre(String dettesRepresenteesParUnTitre) {
		DettesRepresenteesParUnTitre = dettesRepresenteesParUnTitre;
	}

	public String getDettesSubordonnees() {
		return DettesSubordonnees;
	}

	public void setDettesSubordonnees(String dettesDubordonnees) {
		DettesSubordonnees = dettesDubordonnees;
	}

	public String getProvisionsTechniquesDesContratsAss() {
		return ProvisionsTechniquesDesContratsAss;
	}

	public void setProvisionsTechniquesDesContratsAss(String provisionsTechniquesDesContratsAss) {
		ProvisionsTechniquesDesContratsAss = provisionsTechniquesDesContratsAss;
	}

	public String getCapitauxPropres() {
		return CapitauxPropres;
	}

	public void setCapitauxPropres(String capitauxPropres) {
		CapitauxPropres = capitauxPropres;
	}

	public String getAutresPassifs() {
		return AutresPassifs;
	}

	public void setAutresPassifs(String autresPassifs) {
		AutresPassifs = autresPassifs;
	}

	public String getTotalPassif() {
		return TotalPassif;
	}

	public void setTotalPassif(String totalPassif) {
		TotalPassif = totalPassif;
	}

	public String getResultatNetPartDuGroupeParAction() {
		return ResultatNetPartDuGroupeParAction;
	}

	public void setResultatNetPartDuGroupeParAction(String resultatNetPartDuGroupeParAction) {
		ResultatNetPartDuGroupeParAction = resultatNetPartDuGroupeParAction;
	}

	public String getResultatNetPartDuGroupeDilueParAction() {
		return ResultatNetPartDuGroupeDilueParAction;
	}

	public void setResultatNetPartDuGroupeDilueParAction(String resultatNetPartDuGroupeDilueParAction) {
		ResultatNetPartDuGroupeDilueParAction = resultatNetPartDuGroupeDilueParAction;
	}

	public String getCoefficientExploitation() {
		return CoefficientExploitation;
	}

	public void setCoefficientExploitation(String coefficientExploitation) {
		CoefficientExploitation = coefficientExploitation;
	}

	public String getRatioInternationalDeSolvabilité() {
		return RatioInternationalDeSolvabilité;
	}

	public void setRatioInternationalDeSolvabilité(String ratioInternationalDeSolvabilité) {
		RatioInternationalDeSolvabilité = ratioInternationalDeSolvabilité;
	}

	public String getRentabiliteDesFondsPropres() {
		return RentabiliteDesFondsPropres;
	}

	public void setRentabiliteDesFondsPropres(String rentabiliteDesFondsPropres) {
		RentabiliteDesFondsPropres = rentabiliteDesFondsPropres;
	}

	public String getEffectifEnFinAnnee() {
		return EffectifEnFinAnnee;
	}

	public void setEffectifEnFinAnnee(String effectifEnFinAnnee) {
		EffectifEnFinAnnee = effectifEnFinAnnee;
	}

	public String getEffectifMoyen() {
		return EffectifMoyen;
	}

	public void setEffectifMoyen(String effectifMoyen) {
		EffectifMoyen = effectifMoyen;
	}
	public List<Data> getDatas() {
		return datas;
	}

	public void setDatas(List<Data> datas) {
		this.datas = datas;
	}

}
