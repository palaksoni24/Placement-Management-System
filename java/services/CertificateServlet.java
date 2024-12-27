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

import entities.Certificate;
import repository.CertificateDao;

@WebServlet("/certificate")
public class CertificateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CertificateDao certificateDao;

	public void init() {
		certificateDao = new CertificateDao();
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
			case "certificatenew":
				showNewForm(request, response);
				break;
			case "certificateinsert":
				insertCertificate(request, response);
				break;
			case "certificatedelete":
				deleteCertificate(request, response);
				break;
			case "certificateedit":
				showEditForm(request, response);
				break;
			case "certificateupdate":
				updateCertificate(request, response);
				break;
			default:
				listCertificate(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	// Display Certificate Object on views
	private void listCertificate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// get all certificate detail from database and store as a list of user
		List<Certificate> listCertificate = certificateDao.getAllCertificate();
		// setting attribute to display all user details on certificate display page
		request.setAttribute("listCertificate", listCertificate);
		// forward to certificate display page
		RequestDispatcher dispatcher = request.getRequestDispatcher("certificateDisplay.jsp");
		dispatcher.forward(request, response);
	}

	// show certificate registration page
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// forward to certificate index page
		RequestDispatcher dispatcher = request.getRequestDispatcher("certificateIndex.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get the certificate selected id from view to edit its detail
		int id = Integer.parseInt(request.getParameter("id"));
		// get user details using certificate id
		Certificate existingCertificate = certificateDao.getCertificate(id);
		// forward to certificate index page
		RequestDispatcher dispatcher = request.getRequestDispatcher("certificateIndex.jsp");
		// setting attribute to display specific certificate details to edit on
	    request.setAttribute("certificate", existingCertificate);
		dispatcher.forward(request, response);

	}

	// insert the certificate detail
	private void insertCertificate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// getting certificate year college detail to insert in database
		String year = request.getParameter("year");
		String college = request.getParameter("college");
		Certificate newCertificate = new Certificate(year, college);
		// saving certificate detail
		certificateDao.saveCertificate(newCertificate);
		// redirect to certificatelist
		response.sendRedirect("certificate?action=certificatelist");
	}

	// update the certificate detail
	private void updateCertificate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// getting certificate id,year and college detail to update database
		int id = Integer.parseInt(request.getParameter("id"));
		String year = request.getParameter("year");
		String college = request.getParameter("college");
		Certificate certificate = new Certificate(id, year, college);
		// save update certificate detail
		certificateDao.updateCertificate(certificate);
		// redirect to certificatelist
		response.sendRedirect("certificate?action=certificatelist");
	}

	// delete the certificate detail
	private void deleteCertificate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// getting certificate id to delete corresponding certificate detail database
		int id = Integer.parseInt(request.getParameter("id"));
		// save delete certificate detail
		certificateDao.deleteCertificate(id);
		response.sendRedirect("certificate?action=certificatelist");
	}
}
