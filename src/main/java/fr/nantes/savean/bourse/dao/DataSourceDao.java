package fr.nantes.savean.bourse.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import fr.nantes.savean.bourse.dao.config.PostgresConfig;
import fr.nantes.savean.bourse.model.Data;
import fr.nantes.savean.bourse.model.Information;
import fr.nantes.savean.bourse.model.Rendement;
import fr.nantes.savean.bourse.model.Societe;

public class DataSourceDao {
	PostgresConfig postgresConfig;
	Connection connection;

	public DataSourceDao() throws ClassNotFoundException, SQLException, IOException {
		postgresConfig = new PostgresConfig();
		connection = postgresConfig.getConnection();
	}

	public void saveDonneeSociete(Societe societe) throws SQLException {
		// récupération de l'id société avec la dernière année enregistrer
		// si l'année existe déja alors on ne fait rien
		// si la société existe mais pas l'année alors on ajoute l'année
		// si la société existe pas on rajoute tout
		creationSociete(societe);
		for (Rendement rendement : societe.getRendements()) {
			creationRendement(rendement, societe.getId());
		}
		for (Information information : societe.getInformationAnnuel()) {
			long idInformation = creationInformation(information, societe.getId());
			if (information.getDatas() != null) {
				for (Data data : information.getDatas()) {
					creationData(data, idInformation);
				}
			}
		}

	}

	private void creationData(Data data, long idInformation) throws SQLException {
		PreparedStatement preparedStatement = null;

		String insertTableRendement = "INSERT INTO actions.data"
				+ "(dateData, Open, High,Low,Last,Volume,Turnover,idInformation) VALUES" + "(?,?,?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(insertTableRendement);
			if(data.getDate() != null) {
				preparedStatement.setString(1, data.getDate());
			}else {
				preparedStatement.setNull(1, Types.VARCHAR);
			}
			if(data.getOpen() != null) {
				preparedStatement.setDouble(2, data.getOpen());
			}else {
				preparedStatement.setNull(2, Types.DOUBLE);
			}
			if(data.getHigh() != null) {
				preparedStatement.setDouble(3, data.getHigh());
			}else {
				preparedStatement.setNull(3, Types.DOUBLE);
			}
			if(data.getLow() != null) {
				preparedStatement.setDouble(4, data.getLow());
			}else {
				preparedStatement.setNull(4, Types.DOUBLE);
			}
			if(data.getLast() != null) {
				preparedStatement.setDouble(5, data.getLast());
			}else {
				preparedStatement.setNull(5, Types.DOUBLE);
			}
			if(data.getVolume() != null) {
				preparedStatement.setDouble(6, data.getVolume());
			}else {
				preparedStatement.setNull(6, Types.DOUBLE);
			}
			if(data.getTurnover() != null) {
				preparedStatement.setDouble(7, data.getTurnover());
			}else {
				preparedStatement.setNull(7, Types.DOUBLE);
			}
			preparedStatement.setLong(8, idInformation);
			// execute insert SQL stetement
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}

	private long creationInformation(Information information, String id) throws SQLException {
		PreparedStatement preparedStatement = null;
		String generatedColumns[] = { "id" };
		String insertTableRendement = "INSERT INTO actions.information (annee, resultatNetParGroupe, "
				+ "croissanceFutureEnPourcentage, resultatNet, chiffreAffaire,"
				+ "totalActif,totalPassif,capitauxPropre,idSociete) VALUES"
				+ "(?,?,?,?,?,?,?,?,?)";
		
		try {
			preparedStatement = connection.prepareStatement(insertTableRendement, generatedColumns);
			preparedStatement.setString(1, information.getAnnee());
			preparedStatement.setString(2, information.getResultatNetParGroupe());
			preparedStatement.setString(3, information.getCroissanceFutureEnPourcentage());
			preparedStatement.setString(4, information.getResultatNet());
			preparedStatement.setString(5, information.getChiffreAffaire());
			preparedStatement.setString(6, information.getTotalActif());
			preparedStatement.setString(7, information.getTotalPassif());
			preparedStatement.setString(8, information.getCapitauxpropre());
			preparedStatement.setString(9, id);
			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();

			if (rs.next()) {
				return rs.getLong(1);
			} else {
				throw new SQLException("impossible de récupérer l'id crée");
			}
		} catch (SQLException e) {
			throw e;

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}

	}

	private void creationRendement(Rendement rendement, String id) throws SQLException {
		PreparedStatement preparedStatement = null;

		String insertTableRendement = "INSERT INTO actions.rendement"
				+ "(annee, montant, Cours,rendement,idSociete) VALUES" + "(?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(insertTableRendement);
			preparedStatement.setString(1, rendement.getAnnee());
			preparedStatement.setDouble(2, rendement.getMontant());
			preparedStatement.setDouble(3, rendement.getCours());
			preparedStatement.setDouble(4, rendement.getRendement());
			preparedStatement.setString(5, id);
			// execute insert SQL stetement
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}

	private void creationSociete(Societe societe) throws SQLException {
		PreparedStatement preparedStatement = null;

		String insertTableSociete = "INSERT INTO actions.societe"
				+ "(id, idElement, secteurActivite, codeIsin,symbSociete,indicePrincipal,bourseLabel,code,isin,nom) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(insertTableSociete);
			preparedStatement.setString(1, societe.getId());
			preparedStatement.setString(2, societe.getIdElement());
			preparedStatement.setString(3, societe.getSecteurActivite());
			preparedStatement.setString(4, societe.getCodeIsin());
			preparedStatement.setString(5, societe.getSymbSociete());
			preparedStatement.setString(6, societe.getIndicePrincipal());
			preparedStatement.setString(7, societe.getBourseLabel());
			preparedStatement.setString(8, societe.getCode());
			preparedStatement.setString(9, societe.getIsin());
			preparedStatement.setString(10, societe.getNom());
			// execute insert SQL stetement
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}

	public void getSociete(Societe societe) {
		// récupération de l'id société avec la dernière année enregistrer
		// si l'année existe déja alors on ne fait rien
		// si la société existe mais pas l'année alors on ajoute l'année
		// si la société existe pas on rajoute tout
	}

}
