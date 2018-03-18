package fr.nantes.savean.bourse.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.similarity.JaroWinklerDistance;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import fr.nantes.savean.bourse.model.Data;
import fr.nantes.savean.bourse.model.Information;
import fr.nantes.savean.bourse.model.Rendement;
import fr.nantes.savean.bourse.model.Societe;
import fr.nantes.savean.bourse.utils.HttpUtils;
import fr.nantes.savean.bourse.utils.XmlUtils;

public class InternetDao {
	private static final String[] LETTRE_ALPHABET = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
			"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", };
	private static final String URL = "http://www.boursorama.com/";
	private static final String URL_TRADING = "https://www.tradingsat.com/";
	private static final Pattern PATTERN_INFO_VARS = Pattern.compile("tc_vars[ ]+=[ ]+(\\{.*})");
	private static final Pattern PATTERN_INFO_ID = Pattern.compile("/cours.phtml\\?symbole=1rP(.*)");

	public Societe getSociete(String id) {
		Societe societe = new Societe();
		societe.setId(id);
		try {
			getInfosAnnuel(societe);
		} catch (IOException | URISyntaxException e) {
			societe = null;
		}
		return societe;
	}

	private void remplirSocieteInformation(Societe societe, String html)
			throws MalformedURLException, IOException, URISyntaxException {
		Matcher matcher = PATTERN_INFO_VARS.matcher(html);
		if (matcher.find()) {
			String jsonInfo = matcher.group(1);
			JSONObject jsonInfoObj = new JSONObject(jsonInfo);
			societe.setIdElement(jsonInfoObj.getString("id_element"));
			societe.setSecteurActivite(jsonInfoObj.getString("fv_secteur_activite"));
			societe.setCodeIsin(jsonInfoObj.getString("fv_code_isin"));
			societe.setSymbSociete(jsonInfoObj.getString("fv_symb_societe"));
			societe.setIndicePrincipal(jsonInfoObj.getString("fv_indice_principal"));
			societe.setBourseLabel(jsonInfoObj.getString("fv_bourse_label"));
		}
		getValeurs(societe);
	}

	private void getValeurs(Societe societe) throws IOException {
		String contenu;
		contenu = HttpUtils.getHTML("https://www.quandl.com/api/v3/datasets/EURONEXT/" + societe.getIsin()
				+ ".json?api_key=yWNy_cjsfRsuw28KvjdM");
		JSONObject jsonInfoObj = new JSONObject(contenu);
		if (jsonInfoObj.get("dataset") != null) {
			JSONObject dataset = jsonInfoObj.getJSONObject("dataset");
			societe.setNom(dataset.getString("name").split("\\(")[0].trim());
			JSONArray arrayData = dataset.getJSONArray("data");
			getValeur(societe, arrayData);
		}
	}

	private void getValeur(Societe societe, JSONArray arrayData) {
		Iterator<Object> setIterator = arrayData.iterator();
		HashMap<String, List<Data>> map = new HashMap<String, List<Data>>();
		while (setIterator.hasNext()) {
			JSONArray arrayInfo = (JSONArray) setIterator.next();
			Data data = new Data();
			if (!arrayInfo.isNull(0)) {
				data.setDate(arrayInfo.getString(0));
			}
			if (!arrayInfo.isNull(1)) {
				data.setOpen(arrayInfo.getDouble(1));
			}
			if (!arrayInfo.isNull(2)) {
				data.setHigh(arrayInfo.getDouble(2));
			}
			if (!arrayInfo.isNull(3)) {
				data.setLow(arrayInfo.getDouble(3));
			}
			if (!arrayInfo.isNull(4)) {
				data.setLast(arrayInfo.getDouble(4));
			}
			if (!arrayInfo.isNull(5)) {
				data.setVolume(arrayInfo.getDouble(5));
			}
			if (!arrayInfo.isNull(6)) {
				data.setTurnover(arrayInfo.getDouble(6));
			}
			String annee = data.getDate().split("-")[0];
			if (map.get(annee) == null) {
				List<Data> datas = new ArrayList<Data>();
				datas.add(data);
				map.put(annee, datas);
			} else {
				map.get(annee).add(data);
			}
		}
		addToListInformation(map, societe.getInformationAnnuel());

	}

	private void addToListInformation(HashMap<String, List<Data>> map, List<Information> informationsAnnuel) {
		for (Information informationAnnuel : informationsAnnuel) {
			informationAnnuel.setDatas(map.get(informationAnnuel.getAnnee()));
		}

	}

	private void getInfosAnnuel(Societe societe) throws IOException, URISyntaxException {
		List<Element> elements;
		String html = HttpUtils.getHTML(URL + "bourse/profil/profil_finance.phtml?symbole=1rP" + societe.getId());
		String xpath = "//table";
		elements = XmlUtils.getInfoString(html, xpath);

		Element compteDeResultat = elements.get(0);
		Element bilan = elements.get(1);
		Element annees = compteDeResultat.getElementsByTag("thead").get(0).getElementsByTag("tr").get(0);
		Elements ligneBodyComposteDeResultat = compteDeResultat.getElementsByTag("tbody").get(0).getElementsByTag("tr");
		Elements ligneBodyBilan = bilan.getElementsByTag("tbody").get(0).getElementsByTag("tr");
		List<Information> informations = new ArrayList<Information>();
		societe.setInformationAnnuel(informations);
		int idResultatNet = getIdSpecifique(ligneBodyComposteDeResultat, "Résultat net");
		int idResultatNetParGroupe = getIdSpecifique(ligneBodyComposteDeResultat, "Résultat net (part du groupe)");
		int idChiffreAffaire = getIdSpecifique(ligneBodyComposteDeResultat, "Chiffre d'affaires");
		int idTotalActif = getIdSpecifique(ligneBodyBilan, "Total actif");
		int idTotalpassif = getIdSpecifique(ligneBodyBilan, "Total passif");
		int idCapitauxpropres = getIdSpecifique(ligneBodyBilan, "Capitaux propres");

		for (int i = 2; i < annees.getAllElements().size(); i++) {
			Information information = new Information();
			information.setAnnee(getAnnee(annees.getAllElements().get(i).text()));
			// /* information Compte de resultat */
			if (idResultatNet != -1) {
				information
						.setResultatNet(ligneBodyComposteDeResultat.get(idResultatNet).getAllElements().get(i).text());
			}
			if (idResultatNetParGroupe != -1) {
				information
						.setResultatNetParGroupe(ligneBodyComposteDeResultat.get(idResultatNetParGroupe).getAllElements().get(i).text());
			}
			if (idChiffreAffaire != -1) {
				information.setChiffreAffaire(
						ligneBodyComposteDeResultat.get(idChiffreAffaire).getAllElements().get(i).text());
			}
			// /* fin information Compte de resultat */
			// /* information bilan */
			if (idTotalActif != -1) {
				information.setTotalActif(ligneBodyBilan.get(idTotalActif).getAllElements().get(i).text());
			}
			if (idTotalpassif != -1) {
				information.setTotalPassif(ligneBodyBilan.get(idTotalpassif).getAllElements().get(i).text());
			}
			if (idCapitauxpropres != -1) {
				information.setCapitauxpropre(ligneBodyBilan.get(idCapitauxpropres).getAllElements().get(i).text());
			}
			/* fin information bilan */
			informations.add(information);
		}
		remplirSocieteInformation(societe, html);
		getRendement(societe);
	}

	private int getIdSpecifique(Elements ligneBody, String value) {
		double rapprochement = 0;
		int idLePlusproche = 0;
		for (int i = 0; i < ligneBody.size(); i++) {
			String id = ligneBody.get(i).getAllElements().get(1).text();
			JaroWinklerDistance jaroWinklerDistance = new JaroWinklerDistance();
			double rapprochementId = jaroWinklerDistance.apply(id.toLowerCase(Locale.FRANCE).trim(),
					value.toLowerCase(Locale.FRANCE).trim());
			if (rapprochement < rapprochementId) {
				rapprochement = rapprochementId;
				idLePlusproche = i;
			}
		}
		if (rapprochement < 0.9) {
			idLePlusproche = -1;
		}
		return idLePlusproche;
	}

	private void getRendement(Societe societe) throws IOException {
		String html = HttpUtils.getHTML(URL_TRADING + societe.getNom().toLowerCase(Locale.FRANCE).replaceAll(" ", "-")
				+ "-" + societe.getCode() + "/dividende.html");
		String xpath = "//table";
		List<Element> elements = XmlUtils.getInfoString(html, xpath);
		Element rendementAnnuel = elements.get(1);
		Elements ligneBodyRendementAnnuel = rendementAnnuel.getElementsByTag("tbody").get(0).getElementsByTag("tr");
		System.out.println(societe.getNom().toLowerCase(Locale.FRANCE).replaceAll(" ", "-") + "-" + societe.getCode());
		for (Element elementLigneBodyRendementAnnuel : ligneBodyRendementAnnuel) {
			Elements elementsTrRendementAnnuel = elementLigneBodyRendementAnnuel.getElementsByTag("td");
			if (elementsTrRendementAnnuel.get(0).text().length() == 4) {
				Rendement rendement = new Rendement();
				rendement.setAnnee(elementsTrRendementAnnuel.get(0).text());
				rendement.setMontant(getWithoutExtension(elementsTrRendementAnnuel.get(1).text()));
				rendement.setCours(getWithoutExtension(elementsTrRendementAnnuel.get(2).text()));
				rendement.setRendement(getRendement(elementsTrRendementAnnuel.get(3).text()));
				societe.getRendements().add(rendement);
			}
		}
	}

	private Double getWithoutExtension(String valeur) {
		Double retour;
		if (valeur.isEmpty()) {
			retour = 0.0;
		} else {
			valeur = valeur.replaceAll("[^0-9.]", "");
			if (valeur.isEmpty()) {
				retour = 0.0;
			} else {
				retour = Double.parseDouble(valeur);
			}
		}
		return retour;
	}

	private Double getRendement(String valeur) {
		Double retour;
		if (valeur.isEmpty()) {
			retour = 0.0;
		} else {
			valeur = valeur.replaceAll("[^0-9.]", "").substring(0, 4);
			if (valeur.isEmpty()) {
				retour = 0.0;
			} else {
				retour = Double.parseDouble(valeur);
			}
		}
		return retour;
	}

	private String getAnnee(String annee) {
		String anneeSur2Caractere = annee.split("\\.")[1];
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int caractereAnneepredit = Integer.parseInt(String.valueOf(year).substring(0, 2));
		int valuePredit = Integer.parseInt(String.valueOf(caractereAnneepredit) + anneeSur2Caractere);
		if (valuePredit > year) {
			caractereAnneepredit--;
		}
		return String.valueOf(caractereAnneepredit) + anneeSur2Caractere;
	}

	public List<String> getIdPea() throws IOException {
		List<String> idSocietes = new ArrayList<String>();
		String xpath = "//table";
		for (String lettre : LETTRE_ALPHABET) {
			String html = HttpUtils.getHTML(URL + "bourse/actions/cours_az.phtml?pea=1&LETTRE=" + lettre);
			List<Element> elements = XmlUtils.getInfoString(html, xpath);
			Element tablePrincipal = elements.get(0);
			Elements ligneBodyBilan = tablePrincipal.getElementsByTag("tbody").get(0).getElementsByTag("tr");
			for (Element trElement : ligneBodyBilan) {
				String hrefTr = trElement.attr("href");
				Matcher matcher = PATTERN_INFO_ID.matcher(hrefTr);
				if (matcher.find()) {
					idSocietes.add(matcher.group(1));
				}
			}
		}

		return idSocietes;
	};

}
