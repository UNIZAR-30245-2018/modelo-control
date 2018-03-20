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

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        WebFacade fachada = new WebFacade();
        try {
            if(fachada.buscarUsuario(email, pass) == null){
                response.sendRedirect("mal.html");
            }
            else{
                Cookie cookiee = new Cookie("email",email);
                Cookie cookiep = new Cookie("password",pass);
                response.addCookie(cookiee);
                response.addCookie(cookiep);
                UsuarioVO user = fachada.getUser(email);
                fachada.añadirJuegosEnCursoUser(user);
                request.setAttribute("user", user);
                request.getRequestDispatcher("Usuario.jsp").forward(request, response);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
