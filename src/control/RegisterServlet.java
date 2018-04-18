package control;

import modelo.datos.VO.UsuarioVO;
import modelo.datos.WebFacade;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email= request.getParameter("email");
        String seudonimo = request.getParameter("seudonimo");
        String name= request.getParameter("name");
        String pass = request.getParameter("password");
        WebFacade fachada = new WebFacade();
        try {
            if(fachada.existeEmail(email)){
                response.sendRedirect("Login.jsp");
            }
            else{
                fachada.insertarUsuario(seudonimo, name, email, pass);
                Cookie cookiee = new Cookie("email",email);
				Cookie cookiep = new Cookie("password",pass);
				response.addCookie(cookiee);
				response.addCookie(cookiep); 
				response.sendRedirect("verPerfil.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
    }
  }
}
