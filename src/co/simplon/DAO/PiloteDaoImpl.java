package co.simplon.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import co.simplon.JavaBeans.Pilote;

public class PiloteDaoImpl implements PiloteDAO {

	private DAOContext context;
	private Connection con = null;
	private PreparedStatement ps = null;

	private static final String createPilote = "insert into pilotes(nom, site) values(?,?);";
	private static final String selectPilote = "select id, nom, site from bd_avion.pilotes where id =?";
	private static final String listPilote = "select * from bd_avion.pilotes;";
	private static final String updatePilote = "update bd_avion.pilotes set nom=?, site=? where id = ?;";
	private static final String deletePilote = "delete from bd_avion.pilotes where id = ?;";

	@Override
	public List<Pilote> getAllPilote() {
		return null;
	}

	@Override
	public void createPilote(Pilote pilote) {
	}

	@Override
	public Pilote getPilote(int piloteID) {
		return null;
	}

	@Override
	public void updatePilote(Pilote pilote) {
	}

	@Override
	public void deletePilote(Pilote pilote) {
	}
}
