package fr.nantes.savean.bourse.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.junit.Test;

import fr.nantes.savean.bourse.model.Societe;

public class TestDataSourceDao {
	
	@Test
	public void getIdPea() throws IOException, URISyntaxException, ClassNotFoundException, SQLException{
		DataSourceDao dataSourceDao = new DataSourceDao();
		InternetDao internetDao = new InternetDao();
		Societe societe = internetDao.getSociete("AB");
		dataSourceDao.saveDonneeSociete(societe);
	}

}
