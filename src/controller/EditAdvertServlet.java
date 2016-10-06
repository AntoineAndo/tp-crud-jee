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
 * Servlet implementation class EditAdvertServlet
 */
@WebServlet("/editAdvert")
public class EditAdvertServlet extends HttpServlet {
	private static final Logger logger = LogManager.getLogger(StartupListener.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAdvertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AdvertDao dao = new AdvertDao();
		
		int id = Integer.parseInt(request.getParameter("id"));
	    logger.info("Affichage du formulaire d'édition de l'annonce " + id);
		
		Advert advert = dao.getAdvertById(id);
		
		request.setAttribute("advert", advert);
		
		request.getRequestDispatcher("editAdvert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    
		int id = Integer.parseInt(request.getParameter("id"));
		
	    logger.info("Mise à jour des modifications de l'annonce " + id);
	    
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		Advert newAdvert = new Advert();
		newAdvert.setId(id);
		newAdvert.setTitle(title);
		newAdvert.setDescription(description);
		
		AdvertDao dao = new AdvertDao();
		
		dao.updateAdvert(newAdvert);
		Advert advert = dao.getAdvertById(id);
		
		request.setAttribute("advert", advert);
		
	    logger.info("Redirection vers la page de détail de l'annonce " + id);
		
		request.getRequestDispatcher("advertDetail.jsp").forward(request, response);
		
		
	}

}
