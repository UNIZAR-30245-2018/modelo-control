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
import modelo.datos.DAO.SeguidorDAO;
import modelo.datos.VO.JuegoVO;
import modelo.datos.VO.PublicacionVO;
import modelo.datos.VO.UsuarioVO;
import modelo.datos.WebFacade;

public class verUsuariosServlet extends HttpServlet {
  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    WebFacade fachada = new WebFacade();
    response.setContentType("text/html;charset=UTF-8");
    try {
      ArrayList<UsuarioVO> listaUsers = fachada.getUsers();
      request.setAttribute("users", listaUsers);
      RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaUsuarios.jsp");
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
