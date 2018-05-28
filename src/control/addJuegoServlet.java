package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.datos.VO.PublicacionVO;
import modelo.datos.VO.UsuarioVO;
import modelo.datos.WebFacade;

public class addJuegoServlet extends HttpServlet {

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("Aqui estoy");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    WebFacade fachada = new WebFacade();
    String email = null;
    String password = null;
    try {
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals("email")) {
            email = cookies[i].getValue();
          }
          if (cookies[i].getName().equals("password")) {
            password = cookies[i].getValue();
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    int id = Integer.parseInt(request.getParameter("id"));
    String lista = request.getParameter("lista");
    try {
      UsuarioVO user = fachada.buscarUsuario(email,password);
      fachada.anadirJuegoAUser(user,id, lista);
      RequestDispatcher rd = getServletContext().getRequestDispatcher("/verJuegos.jsp");
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
