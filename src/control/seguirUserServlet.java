package control;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.datos.DAO.SeguidorDAO;
import modelo.datos.VO.PublicacionVO;
import modelo.datos.VO.UsuarioVO;
import modelo.datos.WebFacade;

public class seguirUserServlet extends HttpServlet {
  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    WebFacade fachada = new WebFacade();
    try {
      String user = request.getParameter("user");
      String seguido = request.getParameter("seguido");
      String accion = request.getParameter("accion");
      System.out.println(user);
      System.out.println(seguido);
      System.out.println(accion);
      UsuarioVO userVO = fachada.getUser(user);
      UsuarioVO seguidorVO = fachada.getUser(seguido);
      if(accion.equals("seguir")){
        fachada.seguirUsuario(userVO,seguidorVO);
      }
      else{
        fachada.dejarDeSeguirUsuario(userVO,seguidorVO);
      }

      request.getRequestDispatcher("./UsuarioEspecifico.jsp?seudonimo=" + seguidorVO.getSeudonimo()).forward(request, response);
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
