package fr.nantes.savean.bourse.dao.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresConfig {

	Connection connection = null;

	public Connection getConnection() throws SQLException,
			ClassNotFoundException, IOException {
		Class.forName("org.postgresql.Driver");

		Properties propertieConfig = new Properties();
		propertieConfig.load(PostgresConfig.class
				.getResourceAsStream("PostgreSQLConnect.properties"));
		String hostname = propertieConfig.getProperty("hostname");
		String port = propertieConfig.getProperty("port");
		String dbname = propertieConfig.getProperty("dbname");
		String username = propertieConfig.getProperty("username");
		String password = propertieConfig.getProperty("password");
		connection = DriverManager.getConnection("jdbc:postgresql://"
				+ hostname + ":" + port + "/" + dbname + "," + username + ", "
				+ password);
		return connection;
	}

	public void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

}
