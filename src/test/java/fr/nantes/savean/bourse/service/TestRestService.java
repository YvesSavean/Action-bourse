package fr.nantes.savean.bourse.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.junit.Test;

public class TestRestService {
	
	@Test
	public void Refresh() throws ClassNotFoundException, SQLException, IOException, URISyntaxException {
		RestService restService = new RestService();
		restService.refreshBase();
	}

}
