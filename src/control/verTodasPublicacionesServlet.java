package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.datos.VO.PublicacionVO;
import modelo.datos.WebFacade;

public class verTodasPublicacionesServlet extends HttpServlet {

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    WebFacade fachada = new WebFacade();
    try {
      ArrayList<PublicacionVO> listaPublicaciones = fachada.getPublicaciones();
      request.setAttribute("publicaciones", listaPublicaciones);
      RequestDispatcher rd = getServletContext().getRequestDispatcher("/verPublicaciones.jsp");
      rd.forward(request, response);
    } catch (SQLException e) {
      e.printStackTrace();
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
