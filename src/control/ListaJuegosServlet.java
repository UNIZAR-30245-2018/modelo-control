package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.datos.VO.JuegoVO;
import modelo.datos.VO.LogroVO;
import modelo.datos.WebFacade;

public class ListaJuegosServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    WebFacade fachada = new WebFacade();
    try {
      ArrayList<JuegoVO> listaJuegos = fachada.getJuegos();
      request.setAttribute("juegos", listaJuegos);
      RequestDispatcher rd = getServletContext().getRequestDispatcher("/verJuegos.jsp");
      rd.forward(request, response);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
