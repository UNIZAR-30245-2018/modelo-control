 /**
 * 
 */
package modelo.datos;

import java.sql.Connection;
import java.sql.SQLException;
import modelo.datos.BD.GestorDeConexionesBD;
import modelo.datos.DAO.JuegoDAO;
import modelo.datos.DAO.UsuarioDAO;
import modelo.datos.VO.JuegoVO;
import modelo.datos.VO.UsuarioVO;

/**
 * @author Jorge Rambla
 *
 */
public class WebFacade {
	
  public void insertarUsuario(UsuarioVO usuario) throws SQLException {
	  Connection conexion = null;
	  try {
		  conexion = GestorDeConexionesBD.getConnection();
		  new UsuarioDAO().insertarUsuario(usuario, conexion);
	  } catch (Exception e) {
		  e.printStackTrace(System.err);
	  } finally {
		  conexion.close();
	  }
  }

  public UsuarioVO buscarUsuario(String email,String pass) throws java.sql.SQLException {
	  Connection conexion = null;
	  UsuarioVO devolver = null;
	  try {
		  conexion = GestorDeConexionesBD.getConnection();
		  UsuarioDAO usuarioDAO = new UsuarioDAO();
		  if (usuarioDAO.existeUsuario(email,email,pass,conexion)) {
			  //throw new SQLException("Problemas con la clave!!!!");
			  devolver = usuarioDAO.getUsuario(email,conexion);
		  }
		  else {
			  devolver = null;
		  }
	  } catch (Exception e) {
		  e.printStackTrace(System.err);
	  } finally {
		  conexion.close();
	  }
	  return devolver;
  }
  
  public static void main(String[] args) throws SQLException {
    
  }
}
