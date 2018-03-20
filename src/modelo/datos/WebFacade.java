 /**
 * 
 */
package modelo.datos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.datos.BD.GestorDeConexionesBD;
import modelo.datos.DAO.JuegoDAO;
import modelo.datos.DAO.ListaJuegosDAO;
import modelo.datos.DAO.LogroDAO;
import modelo.datos.DAO.UsuarioDAO;
import modelo.datos.VO.JuegoVO;
import modelo.datos.VO.ListaJuegosVO;
import modelo.datos.VO.LogroVO;
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

  public void insertarUsuario(String seudonimo, String nombre, String email, String password) throws SQLException {
	  Connection conexion = null;
	  try {
		  conexion = GestorDeConexionesBD.getConnection();
		  UsuarioVO usuario = new UsuarioVO(seudonimo, nombre, email, password);
		  new UsuarioDAO().insertarUsuario(usuario, conexion);
	  } catch (Exception e) {
		  e.printStackTrace(System.err);
	  } finally {
		  conexion.close();
	  }
  }

  public boolean existeEmail(String email) throws SQLException {
	  Connection conexion = null;
	  Boolean existe = false;
	  try {
		  conexion = GestorDeConexionesBD.getConnection();
		  existe =  new UsuarioDAO().existeEmail(email, conexion);
	  } catch (Exception e) {
		  e.printStackTrace(System.err);
	  } finally {
		  conexion.close();
	  }
	  return existe;
  }

  public void añadirJuegosEnCursoUser(UsuarioVO user) throws SQLException {
      Connection conexion = null;
      try {
          conexion = GestorDeConexionesBD.getConnection();
          UsuarioDAO usuarioDAO = new UsuarioDAO();
          if (user != null) {
              //throw new SQLException("Problemas con la clave!!!!");
              user.setJuegosEnCurso(usuarioDAO.getEnCursoByUser(user.getNombre(),conexion));
          }
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

  public UsuarioVO getUser(String identificacion) throws java.sql.SQLException{
	  Connection conexion = null;
	  UsuarioVO devolver = null;
	  try {
		  conexion = GestorDeConexionesBD.getConnection();
		  UsuarioDAO usuarioDAO = new UsuarioDAO();
		  devolver = usuarioDAO.getUsuario(identificacion,conexion);
	  } catch (Exception e) {
		  e.printStackTrace(System.err);
	  } finally {
		  conexion.close();
	  }
	  return devolver;

  }


  public ArrayList<LogroVO> getLogros() throws  java.sql.SQLException{
	  Connection conexion = null;
	  ArrayList<LogroVO> devolver = null;
	  try {
		  conexion = GestorDeConexionesBD.getConnection();
		  LogroDAO logroDAO = new LogroDAO();
		  devolver = logroDAO.getAllLogro(conexion);
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
