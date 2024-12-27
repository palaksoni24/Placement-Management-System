package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Placement;
import repository.PlacementDao;

@WebServlet("/placement")
public class PlacementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlacementDao placementDao;

	public void init() {
		placementDao = new PlacementDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			switch (action) {
			case "placementnew":
				showNewForm(request, response);
				break;
			case "placementinsert":
				insertPlacement(request, response);
				break;
			case "placementdelete":
				deletePlacement(request, response);
				break;
			case "placementedit":
				showEditForm(request, response);
				break;
			case "placementupdate":
				updatePlacement(request, response);
				break;
			default:
				listPlacement(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

//  Display Placement Object on views
	private void listPlacement(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// get all placement detail from database and store as a list of placement
		List<Placement> listPlacement = placementDao.getAllPlacement();
		// setting attribute to display all placement details on placement display page
		request.setAttribute("listPlacement", listPlacement);
		// forward to placement display page
//		String view = request.getParameter("view");
//	    String targetPage = (view != null && view.equals("viewCompany")) 
//	                        ? "viewCompany.jsp" 
//	                        : "placementDisplay.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher("placementDisplay.jsp");
		dispatcher.forward(request, response);
	}

	// show placement registration page
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// forward to placement index page
		RequestDispatcher dispatcher = request.getRequestDispatcher("placementIndex.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get the placement selected id from view to edit its detail
		int id = Integer.parseInt(request.getParameter("id"));
		// get placement details using user id
		Placement existingPlacement = placementDao.getPlacement(id);
		// forward to placement index page
		RequestDispatcher dispatcher = request.getRequestDispatcher("placementIndex.jsp");
		// setting attribute to display specific placement details to edit on placement
		// display
		request.setAttribute("placement", existingPlacement);
		dispatcher.forward(request, response);

	}

	// insert the placement detail
	private void insertPlacement(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// getting name and password placement detail to insert in database
		String name = request.getParameter("name");
		String qualification = request.getParameter("qualification");
		String designation = request.getParameter("designation");
		String academicCriteria = request.getParameter("academicCriteria");
		String location = request.getParameter("location");
		String ctcOffered = request.getParameter("ctcOffered");
		String registrationLink = request.getParameter("registrationLink");
		String lastDate = request.getParameter("lastDate");
		String selectionProcess = request.getParameter("selectionProcess");
		String companyWebsite = request.getParameter("companyWebsite");
		
		Placement newPlacement = new Placement(name,qualification,designation, academicCriteria, location,ctcOffered, registrationLink, lastDate, selectionProcess, companyWebsite);
		// saving placement detail
		placementDao.savePlacement(newPlacement);
		// redirect to placementlist
		response.sendRedirect("placement?action=placementlist");
	}

	// update the placement detail
	private void updatePlacement(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// getting placement detail to update database
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String qualification = request.getParameter("qualification");
		String designation = request.getParameter("designation");
		String academicCriteria = request.getParameter("academicCriteria");
		String location = request.getParameter("location");
		String ctcOffered = request.getParameter("ctcOffered");
		String registrationLink = request.getParameter("registrationLink");
		String lastDate = request.getParameter("lastDate");
		String selectionProcess = request.getParameter("selectionProcess");
		String companyWebsite = request.getParameter("companyWebsite");
		
		Placement placement = new Placement(id,name,qualification,designation, academicCriteria, location,ctcOffered, registrationLink, lastDate, selectionProcess, companyWebsite);
		// update placement detail
		placementDao.updatePlacement(placement);
		// redirect to placementlist
		response.sendRedirect("placement?action=placementlist");
	}

	// delete the placement detail
	private void deletePlacement(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// getting placement id to delete corresponding placement detail database
		int id = Integer.parseInt(request.getParameter("id"));
		// delete placement detail
		placementDao.deletePlacement(id);
		// redirect to placementlist
		response.sendRedirect("placement?action=placementlist");
	}
}
