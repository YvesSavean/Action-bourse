package fr.nantes.savean.bourse.dao.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresConfig {

	Connection connection = null;

	public Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
		Class.forName("org.postgresql.Driver");

		Properties propertieConfig = new Properties();
		propertieConfig.load(PostgresConfig.class.getClassLoader().getResourceAsStream("PostgreSQLConnect.properties"));
		String hostname = propertieConfig.getProperty("hostname").trim();
		String port = propertieConfig.getProperty("port").trim();
		String dbname = propertieConfig.getProperty("dbname").trim();
		String username = propertieConfig.getProperty("username").trim();
		String password = propertieConfig.getProperty("password").trim();
		connection = DriverManager.getConnection("jdbc:postgresql://" + hostname + ":" + port + "/" + dbname, username,
				password);
		return connection;
	}

	public void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

}
