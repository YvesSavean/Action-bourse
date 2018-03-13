package fr.nantes.savean.bourse.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import us.codecraft.xsoup.XElements;
import us.codecraft.xsoup.Xsoup;

/**
 * Class permettant la gestion des fichiers xml
 * 
 * @author yves savean
 *
 */
public class XmlUtils {

	/**
	 * Methode permettant la récupération dans un elements via xpath dans une
	 * fichier html
	 * 
	 * @param file
	 * @param xpath
	 * @return la liste des éléments trouvés
	 * @throws IOException
	 */
	public static List<Element> getInfoFile(String file, String xpath) throws IOException {
		Document document = Jsoup.parse(new File(file), Charset.forName("UTF-8").displayName(Locale.FRANCE));
		return getElements(document, xpath);
	}

	/**
	 * Methode permettant la récupération dans un elements via xpath sur une url
	 * 
	 * @param file
	 * @param xpath
	 * @return la liste des éléments trouvés
	 * @throws IOException
	 */
	public static List<Element> getInfoUrl(URL url, int timeout, String xpath) throws IOException {
		Document document = Jsoup.parse(url, timeout);
		return getElements(document, xpath);
	}

	/**
	 * Methode permettant de crée un objet java via un élement xml
	 * 
	 * @param classe
	 * @param element
	 * @return l'objet java crée
	 * @throws JAXBException
	 */
	public static <T> T getObject(Class<T> classe, Element element) throws JAXBException {
		StringReader reader = new StringReader(element.toString());
		return JAXB.unmarshal(reader, classe);
	}

	/**
	 * Methode généric permettant de récupérer via un xpath les élements trouver
	 * 
	 * @param document
	 * @return la liste des éléments trouvés
	 */
	private static List<Element> getElements(Document document, String xpath) {
		XElements listTableElement = Xsoup.compile(xpath).evaluate(document);
		return listTableElement.getElements();
	}

	public static List<Element> getInfoString(String html, String xpath) {
		Document document = Jsoup.parse(html);
		return getElements(document, xpath);
	}

}
