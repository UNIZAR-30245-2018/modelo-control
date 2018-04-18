package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrearUsuarioServlet
 */
public class CerrarSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CerrarSesionServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());

		try {
			Cookie cookiel = null;
			Cookie cookiec = null;
			cookiel = new Cookie("email", "");
			cookiec = new Cookie("password", "");
			cookiel.setMaxAge(0);
			cookiec.setMaxAge(0);
			response.addCookie(cookiel);
			response.addCookie(cookiec);
			request.setAttribute("registro", "true");
			response.sendRedirect("Login.jsp");

		} catch (Exception e) {
			e.printStackTrace(System.err);
			response.sendRedirect("error.jsp?id=error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}