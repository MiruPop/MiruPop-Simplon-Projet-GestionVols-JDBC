package co.simplon.DAO;

import javax.servlet.ServletContext;
import java.sql.*;

public class DAOContext {
	protected static String url;
	protected static String user;
	protected static String passw;
	protected static String driver;

	public static void init(ServletContext context) {
		try {
			url = context.getInitParameter("URL");
			user = context.getInitParameter("USER");
			passw = context.getInitParameter("PASSWORD");
			driver = context.getInitParameter("DRIVER");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println("Le driver ne s'est pas corréctement chargé");
		}
		Connection conn = DriverManager.getConnection(url, user, passw);
		if (conn != null)
	        System.out.println("Connexion BDD réussie");
		else
			System.out.println("Connexion BDD échouée");
		
		return conn;
	}

	public AvionDAO getAvion() {
		return new AvionDaoImpl(this);
	}
}
