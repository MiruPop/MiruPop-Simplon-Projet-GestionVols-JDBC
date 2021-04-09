package co.simplon.DAO;

import java.util.List;

import co.simplon.JavaBeans.Avion;

public interface AvionDAO {
	public void createAvion(Avion avion);
	public List<Avion> getAllAvions();
	public Avion getAvion(int avionID);
	public void updateAvion(Avion avion);
	public void deleteAvion(int avionID);
}