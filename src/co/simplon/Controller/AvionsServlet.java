package co.simplon.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.DAO.AvionDAO;
import co.simplon.DAO.DAOContext;
import co.simplon.JavaBeans.Avion;

/**
 * Servlet implementation class gestionVols
 */
@WebServlet("/avions")
public class AvionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VUE_LISTE = "/WEB-INF/avions.jsp";
	private static final String VUE_FICHE = "/WEB-INF/ficheAvion.jsp";
	
	private static final String ATT_LISTE = "liste";
	
	private static final String ATT_ID="id";
	private static final String ATT_CONSTRUCTEUR = "constructeur";
	private static final String ATT_MODELE = "modele";
	private static final String ATT_CAPACITE = "capacite";
	private static final String ATT_SITE = "site";
	

	private AvionDAO avionDao;

	public AvionsServlet() {
		super();
	}

	public void init() {
		DAOContext context = new DAOContext();
		DAOContext.init(getServletContext());
		this.avionDao = context.getAvion();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		System.out.println("METHODE GET REALISEE - redir vers POST");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getContextPath();

		switch (action) {
			case "/avions/addForm" :
				try {
					ficheVide(request, response);
					System.out.println("fiche vide chargée");
				} catch (SQLException | IOException | ServletException e) {
					System.out.println("fiche vide PAS chargée");
					e.printStackTrace();
				}
				break;
			case "/avions/add" :
				try {
					inscrire(request, response);
					System.out.println("ajout réalisé");
				} catch (SQLException | IOException | ServletException e) {
					System.out.println("ajout PAS FAIT");
					e.printStackTrace();
				}
				break;
			case "/avions/updateForm" :
				try {
					ficheModif(request, response);
					System.out.println("formulaire modif OK");
				} catch (SQLException | IOException | ServletException e) {
					System.out.println("formulaire modif PAS CHARGE");
					e.printStackTrace();
				}
				break;
			case "/avions/update" :
				try {
					modifier(request, response);
					System.out.println("mofification faite");
				} catch (SQLException | IOException | ServletException e) {
					System.out.println("PAS DE mofification");
					e.printStackTrace();
				}
				break;
			default :
				try {
					listAll(request, response);
					System.out.println("liste complète affichée");
				} catch (SQLException | IOException | ServletException e) {
					System.out.println("PROBLEME D'AFFICHAGE");
					e.printStackTrace();
				}
				break;
		}

	}

	// méthode de rédirection vers le formulaire d'inscription
	private void ficheVide(HttpServletRequest request,
			HttpServletResponse response)
					throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(VUE_FICHE);
		dispatcher.forward(request, response);
	}

	// méthode qui récupère les données saisies par l'utilisateur,
	// crée une nouvelle entrée et la sauvegarde dans la variable "avions" de la
	// vue principale
	private void inscrire(HttpServletRequest request,
			HttpServletResponse response)
					throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter(ATT_ID));
		String constructeur = request.getParameter(ATT_CONSTRUCTEUR);
		String modele = request.getParameter(ATT_MODELE);
		int capacite = Integer.parseInt(request.getParameter(ATT_CAPACITE));
		String site = request.getParameter(ATT_SITE);

		Avion newPlane = new Avion();
		newPlane.setId(id);
		newPlane.setConstructeur(constructeur);
		newPlane.setModele(modele);
		newPlane.setCapacite(capacite);
		newPlane.setSite(site);

		avionDao.createAvion(newPlane);
		response.sendRedirect(ATT_LISTE);
		// "avions" est la variable dans la vue principale qui permet le
		// stockage du rés de la méthode getAllAvions
	}

	private void ficheModif(HttpServletRequest request,
			HttpServletResponse response)
					throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter(ATT_ID));
		Avion selectOne = avionDao.getAvion(id);
		RequestDispatcher rd = request.getRequestDispatcher(VUE_FICHE);
		request.setAttribute("avion", selectOne);
		rd.forward(request, response);
	}

	private void modifier(HttpServletRequest request,
			HttpServletResponse response)
					throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter(ATT_ID));
		String constructeur = request.getParameter(ATT_CONSTRUCTEUR);
		String modele = request.getParameter(ATT_MODELE);
		int capacite = Integer.parseInt(request.getParameter(ATT_CAPACITE));
		String site = request.getParameter(ATT_SITE);

		Avion aPlane = new Avion();
		aPlane.setId(id);
		aPlane.setConstructeur(constructeur);
		aPlane.setModele(modele);
		aPlane.setCapacite(capacite);
		aPlane.setSite(site);

		avionDao.updateAvion(aPlane);
		response.sendRedirect(ATT_LISTE);
	}

	private void listAll(HttpServletRequest request,
			HttpServletResponse response)
					throws SQLException, IOException, ServletException {
		// je crée une variable "avions" dans laquelle je stocke le résultat de
		// la méthode .getAllAvions
		request.setAttribute(ATT_LISTE, this.avionDao.getAllAvions());
		// et je l'nvoie vers la vue
		RequestDispatcher rd = request.getRequestDispatcher(VUE_LISTE);
		rd.forward(request, response);
	}
}
