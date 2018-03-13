package fr.nantes.savean.bourse.dao;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import fr.nantes.savean.bourse.model.Societe;

public class TestInternetDao {
	
	@Test
	public void getInfoFile() throws IOException, URISyntaxException{
		InternetDao internetDao = new InternetDao();
		Societe societe = internetDao.getSociete("ACA");
		Assert.assertEquals(5, societe.getInformationAnnuel().size());
	}
}
