package fr.nantes.savean.bourse.service;

import java.io.IOException;
import java.util.List;

import fr.nantes.savean.bourse.dao.InternetDao;

public class RestService {
	
	InternetDao internetDao  = new InternetDao();
	
	public void refreshBase() throws IOException {
		List<String> idsPea = internetDao.getIdPea();
	}

}
