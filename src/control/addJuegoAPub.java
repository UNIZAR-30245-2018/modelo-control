package control;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.datos.VO.PublicacionVO;
import modelo.datos.WebFacade;

public class addJuegoAPub extends HttpServlet {
  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      String user = request.getParameter("seudonimo");
      String spoiler = request.getParameter("spoiler");
      String texto = request.getParameter("texto");
      System.out.println(user);
      System.out.println(spoiler);
      System.out.println(texto);

      request.setAttribute("user",user);
      request.setAttribute("spoiler",spoiler);
      request.setAttribute("texto",texto);
      request.getRequestDispatcher("añadirJuegosAPublicacion.jsp").forward(request, response);
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
