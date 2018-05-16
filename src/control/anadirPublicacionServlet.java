package control;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.datos.VO.PublicacionVO;
import modelo.datos.WebFacade;

public class anadirPublicacionServlet extends HttpServlet {

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    WebFacade fachada = new WebFacade();
    try {
      String user = request.getParameter("seudonimo");
      LocalDate fecha = LocalDate.now();
      String spoiler = request.getParameter("spoiler");
      String juego = request.getParameter("juego");
      String texto = request.getParameter("texto");
      PublicacionVO publicacionVO = new PublicacionVO(user,fecha,Integer.parseInt(juego),texto);
      fachada.anadirPublicacion(publicacionVO);
      request.getRequestDispatcher("verPerfil.jsp").forward(request, response);
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
