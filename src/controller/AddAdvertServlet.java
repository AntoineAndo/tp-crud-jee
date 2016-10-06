package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.AdvertDao;
import listener.StartupListener;
import model.Advert;

/**
 * Servlet implementation class addAdvert
 */
@WebServlet("/addAdvert")
public class AddAdvertServlet extends HttpServlet {
	private static final Logger logger = LogManager.getLogger(StartupListener.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdvertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    logger.info("Affichage du formulaire de création d'annonce");
		request.getRequestDispatcher("addAdvert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    logger.info("Insertion en base de données de la nouvelle annonce");
		doGet(request, response);
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		Advert newAdvert = new Advert();
		newAdvert.setTitle(title);
		newAdvert.setDescription(description);
		
		AdvertDao dao = new AdvertDao();
		
		dao.addAdvert(newAdvert);
	    logger.info("Redirection vers la page d'accueil");
	}

}
