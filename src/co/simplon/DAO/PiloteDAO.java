package co.simplon.DAO;

import java.util.List;

import co.simplon.JavaBeans.Pilote;

public interface PiloteDAO {
	public void createPilote(Pilote pilote);
	public List<Pilote> getAllPilote();
	public Pilote getPilote(int piloteID);
	public void updatePilote(Pilote pilote);
	public void deletePilote(Pilote pilote);
}
