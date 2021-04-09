package co.simplon.DAO;

import java.util.List;

import co.simplon.JavaBeans.Vol;

public interface VolDAO {
	public void createVol(Vol vol);
	public List<Vol> getAllVol();
	public Vol getVol(int volID);
	public void deleteVol(Vol vol);
	public void updateVol(Vol vol);
}
