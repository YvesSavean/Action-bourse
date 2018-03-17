package fr.nantes.savean.bourse.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import fr.nantes.savean.bourse.dao.DataSourceDao;
import fr.nantes.savean.bourse.dao.InternetDao;
import fr.nantes.savean.bourse.model.Societe;

public class RestService {

	InternetDao internetDao;
	DataSourceDao dataSourceDao;

	public RestService() throws ClassNotFoundException, SQLException, IOException {
		internetDao = new InternetDao();
		dataSourceDao = new DataSourceDao();
	}

	public void refreshBase() throws IOException, URISyntaxException, SQLException {
		List<String> idsPea = internetDao.getIdPea();
		for (String id : idsPea) {
			Societe societe = internetDao.getSociete(id);
			if(societe != null) {
				dataSourceDao.saveDonneeSociete(societe);
			}
		}
	}

}
