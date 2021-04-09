package co.simplon.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.JavaBeans.Avion;

public class AvionDaoImpl implements AvionDAO {
	
	@SuppressWarnings("unused")
	private DAOContext context;
	private Connection con = null;
	private PreparedStatement ps = null;
	
	private static final String createAvion = "insert into avions(id, constructeur, modele, capacite, site) values(?,?,?,?,?);";
	private static final String selectAvion = "select * from bd_avion.avions where id =?";
	private static final String listAvion = "select * from bd_avion.avions;";
	private static final String updateAvion = "update bd_avion.avions set id = ?, constructeur=?, modele=?, capacite=?, site=? where id = ?;";
	private static final String deleteAvion = "delete from bd_avion.avions where id = ?;";
	
	public AvionDaoImpl(DAOContext context) {
		this.context = context;
	}
	

	@Override
	public List<Avion> getAllAvions() {
		List<Avion> allAvions = new ArrayList<>();
		Avion avion = null;
		ResultSet rs = null;
		
		try {
			this.con = DAOContext.getConnection();
			ps = con.prepareStatement(listAvion);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String constructeur = rs.getString("constructeur");
				String modele = rs.getString("modele");
				int capacite = rs.getInt("capacite");
				String site = rs.getString("site");
				
				avion = new Avion();
				avion.setId(id);
				avion.setConstructeur(constructeur);
				avion.setModele(modele);
				avion.setCapacite(capacite);
				avion.setSite(site);
				
				allAvions.add(avion);
			}
			
		} catch (SQLException e) {
			System.out.println("connexion à la BDD échouée");
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allAvions;
	}

	@Override
	public void createAvion(Avion avion) {
		try {
			this.con = DAOContext.getConnection();
			ps = con.prepareStatement(createAvion);
			ps.setInt(1, avion.getId());
			ps.setString(2, avion.getConstructeur());
			ps.setString(3, avion.getModele());
			ps.setInt(4, avion.getCapacite());
			ps.setString(5, avion.getSite());
			
			int created = ps.executeUpdate();
			if (created > 0)
				System.out.println("Insertion d'un nouvel élément réussie");
		}catch(SQLException e) {
			System.out.println("connexion à la BDD échouée");
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Avion getAvion(int avionID) {
		Avion avion = null;
		try {
			this.con = DAOContext.getConnection();
			ps = con.prepareStatement(selectAvion);
			ps.setInt(1, avionID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String constructeur = rs.getString("constructeur");
				String modele = rs.getString("modele");
				int capacite = rs.getInt("capacite");
				String site = rs.getString("site");
				
				avion = new Avion();
				
				avion.setId(id);
				avion.setConstructeur(constructeur);
				avion.setModele(modele);
				avion.setCapacite(capacite);
				avion.setSite(site);
			}
		} catch (SQLException e) {
			System.out.println("connexion à la BDD échouée");
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return avion;
	}

	@Override
	public void updateAvion(Avion avion) {
		try {
			this.con = DAOContext.getConnection();
			ps = con.prepareStatement(updateAvion);
			
			ps.setInt(1, avion.getId());
			ps.setString(2, avion.getConstructeur());
			ps.setString(3, avion.getModele());
			ps.setInt(4, avion.getCapacite());
			ps.setString(5, avion.getSite());
			ps.setInt(6, avion.getId());
			
			int modified = ps.executeUpdate();
			if (modified > 0)
				System.out.println("Modification de données réussie");
		} catch (SQLException e) {
			System.out.println("impossible de se connecter à la BDD");
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAvion(int id) {
		try {
			con = DAOContext.getConnection();
			ps = con.prepareStatement(deleteAvion);
			ps.setInt(1, id);
			
			int deleted = ps.executeUpdate();
			if (deleted > 0)
				System.out.println("Element retiré avec succès");
		} catch (SQLException e) {
			System.out.println("connexion à la BDD échouée");
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
