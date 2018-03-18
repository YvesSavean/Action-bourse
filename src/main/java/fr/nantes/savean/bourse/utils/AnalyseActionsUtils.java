package fr.nantes.savean.bourse.utils;

import fr.nantes.savean.bourse.model.Information;
import fr.nantes.savean.bourse.model.Societe;

public class AnalyseActionsUtils {
//	
//	/**
//	 * Calcul du BPA
//	 */
//	public static Double calculBeneficeParAction(Information information) {
//		return information.getBeneficeTotal()/information.getNombredeTitreEnCirulation();
//		
//	}
	
	/**
	 * Calcul du PER
	 * coup l'action en fonction du benefice
	 */
	public static Double calculPriceToEarnings(Double bpa,Double valeurTitre) {
		return valeurTitre/bpa;
		
	}
	

	/**
	 * Calcul du PEG
	 * coup l'action en fonction du benefice
	 * plus c'est petit mieux c'est
	 */
	public static Double calculPricToEarningsGrowth(Double per,Double CroissanceBeneficeFuturEnPourcentage) {
		return per/CroissanceBeneficeFuturEnPourcentage;
	}
	
	/**
	 * Calcul du rendement d'une action
	 */
	public static Double calculrendement(Double dividende,Double courDuTitre) {
		return dividende/courDuTitre;
		
	}
	
	/**
	 * Calcul taux de distribution
	 */
	public static Double calculTauxDeDistribution(Double dividende,Double bpa) {
		return dividende/bpa;
		
	}
	
	
	/**
	 * Calcul Valeur nette Comptable par action
	 * Plus ce ratio est �lev�, plus le march� est pr�t � payer cher pour s�offir l�entreprise, � un prix au-dessus de l�actif net.
	 */
	public static Double calculPriceToBook(Double capitauxPropre, Double valeurTitre) {
		return valeurTitre/capitauxPropre;
		
	}
	
	/**
	 * Calcul ROE
	 * b�n�fice g�n�r� par l�entreprise par rapport � son actif net
	 * Un ROE �lev� et constant est le signe qu�une entreprise dispose d�un avantage comp�titif durable.
	 * � l�inverse, un ROE faible ou en d�croissance est le signe qu�une entreprise perd son avantage comp�titif.
	 */
	public static Double calculReturnOnEquity(Double capitauxPropre,Double resultatNet) {
		return resultatNet/capitauxPropre;
		
	}
	
	public static boolean getEtape1(Societe societe) {
		
		
		return false;
		//si financi�re 	capitaux propre/total des actifs > 20%
		//ROE >15%
		//taux de distribution < 60%
	}


}
