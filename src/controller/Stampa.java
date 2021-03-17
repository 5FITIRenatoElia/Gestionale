package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;


@WebServlet( {
	"/stampa",
	"/"
} )
public class Stampa extends HttpServlet {
	private static final long serialVersionUID = 0xB14810L;

	protected void service(
			HttpServletRequest request,
			HttpServletResponse response
		) throws
			ServletException,
			IOException {
		response.setContentType("application/json");
		
		response.getWriter().append(
				new AziendeDAO().StampAziende()
			);
		response.getWriter().append(
				model.CausaliDAO.StampCausali()
			);
		
		response.getWriter().append(
				model.MovimentiDAO.StampMovimenti()
			);
		
		//Github test questo commento viene aggiornato anche su Eclipse!
	}
}
