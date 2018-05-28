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
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {
    /**
   * 
   */
  private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
		List<String> listaErrores = new ArrayList<String>();
		String errorLogin = "";
        WebFacade fachada = new WebFacade();
        try {
    		if (email == null || email.trim().equals(new String(""))){
    			errorLogin ="El campo email no puede estar vacio";
    			listaErrores.add(errorLogin);
    			request.setAttribute("errores", listaErrores);
    			request.getRequestDispatcher("Login.jsp").forward(request, response);
    		}
        	if (pass == null || pass.trim().equals(new String(""))){
    			errorLogin ="El campo password no puede estar vacio";
    			listaErrores.add(errorLogin);
    			request.setAttribute("errores", listaErrores);
    			request.getRequestDispatcher("Login.jsp").forward(request, response);
    		}
        		
        	
            if(fachada.buscarUsuario(email, pass) == null){
            	errorLogin ="El usuario no coincide con el password";
				listaErrores.add(errorLogin);
				request.setAttribute("errores", listaErrores);
				request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            else{
            	email = fachada.getEmail(email);
                Cookie cookiee = new Cookie("email",email);
                Cookie cookiep = new Cookie("password",pass);
                response.addCookie(cookiee);
                response.addCookie(cookiep);
                UsuarioVO user = fachada.buscarUsuario(email,pass);
                fachada.anadirJuegosUser(user);
                request.setAttribute("user", user);
                request.getRequestDispatcher("verPerfil.jsp").forward(request, response);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
