import modelo.datos.VO.UsuarioVO;
import modelo.datos.WebFacade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        System.out.println(username + " " + pass);
        UsuarioVO usuario = null;
        WebFacade fachada = new WebFacade();
        try {
            usuario = fachada.buscarUsuario(username, pass);
            if(usuario == null){
                out.println("Mal");
            }
            else{
                out.println("Bien");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
