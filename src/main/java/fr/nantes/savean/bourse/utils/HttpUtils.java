package fr.nantes.savean.bourse.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtils {

	public static String getHTML(String urlToRead) throws IOException {
		URL urlObject = new URL(urlToRead);
		URLConnection urlConnection = urlObject.openConnection();
		urlConnection.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

		return toString(urlConnection.getInputStream());
	}

	private static String toString(InputStream inputStream) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String inputLine;
		StringBuilder stringBuilder = new StringBuilder();
		while ((inputLine = bufferedReader.readLine()) != null) {
			stringBuilder.append(inputLine);
		}
		return stringBuilder.toString();
	}

}
