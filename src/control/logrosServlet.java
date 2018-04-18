package control;

import modelo.datos.VO.LogroVO;
import modelo.datos.VO.UsuarioVO;
import modelo.datos.WebFacade;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class logrosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        WebFacade fachada = new WebFacade();
        try {
            ArrayList<LogroVO> listaLogros = fachada.getLogros();
            request.setAttribute("logros", listaLogros);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("verLogros.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
