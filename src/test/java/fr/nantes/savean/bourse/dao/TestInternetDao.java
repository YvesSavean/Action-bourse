package fr.nantes.savean.bourse.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.nantes.savean.bourse.model.Societe;

public class TestInternetDao {
	
	@Test
	public void getIdPea() throws IOException, URISyntaxException{
		InternetDao internetDao = new InternetDao();
		List<String> ids = internetDao.getIdPea();
		Assert.assertNotNull(ids);
	}
	
	@Test
	public void getInfoFile() throws IOException, URISyntaxException{
		InternetDao internetDao = new InternetDao();
		Societe societe = internetDao.getSociete("AB");
		Assert.assertEquals(5, societe.getInformationAnnuel().size());
	}
}
