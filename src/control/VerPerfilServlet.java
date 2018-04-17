package control;


import modelo.datos.VO.UsuarioVO;
import modelo.datos.WebFacade;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class VerPerfilServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String user= request.getParameter("user");
        WebFacade fachada = new WebFacade();
        try {
            UsuarioVO usuarioVO = fachada.getUser(user);
            request.setAttribute("user",usuarioVO);
            RequestDispatcher rd = request.getRequestDispatcher("/verPerfil.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            }
    }

}
