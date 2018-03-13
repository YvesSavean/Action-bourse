package fr.nantes.savean.bourse.utils;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

public class TestXmlUtils {

	@Test
	public void getInfoFile() throws IOException, URISyntaxException{
		ClassLoader classLoader = getClass().getClassLoader();
		XmlUtils.getInfoFile(classLoader.getResource("test.html").getFile(),"//table");
	}
}
