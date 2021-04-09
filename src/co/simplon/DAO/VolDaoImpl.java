package co.simplon.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import co.simplon.JavaBeans.Vol;

public class VolDaoImpl implements VolDAO {

	private DAOContext context;
	private Connection con = null;
	private PreparedStatement ps = null;

	private static final String createVol = "insert into bd_avion.vols(id, avion, pilote, site_arrivee, site_depart, heure_depart, heure_arrivee) values(?,?);";
	private static final String selectVol = "select id, avion, pilote, site_arrivee, site_depart, heure_depart, heure_arrivee from bd_avion.vols where id =?";
	private static final String listVol = "select * from bd_avion.vols;";
	private static final String updateVol = "update bd_avion.vols set id, avion=?, pilote=?, site_arrivee=?, site_depart=?, heure_depart=?, heure_arrivee=? where id = ?;";
	private static final String deleteVol = "delete from bd_avion.vols where id = ?;";

	@Override
	public List<Vol> getAllVol() {
		return null;
	}

	@Override
	public void createVol(Vol vol) {
	}

	@Override
	public Vol getVol(int volID) {
		return null;
	}

	@Override
	public void deleteVol(Vol vol) {
	}

	@Override
	public void updateVol(Vol vol) {
	}
}
