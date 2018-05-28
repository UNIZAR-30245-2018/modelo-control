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
import modelo.datos.DAO.PublicacionDAO;
import modelo.datos.DAO.UsuarioDAO;
import modelo.datos.VO.JuegoVO;
import modelo.datos.VO.ListaJuegosVO;
import modelo.datos.VO.LogroVO;
import modelo.datos.VO.PublicacionVO;
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

  public void insertarUsuario(String seudonimo, String nombre, String email,
      String password) throws SQLException {
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
      existe = new UsuarioDAO().existeEmail(email, conexion);
    } catch (Exception e) {
      e.printStackTrace(System.err);
    } finally {
      conexion.close();
    }
    return existe;
  }

  public void anadirJuegosEnCursoUser(UsuarioVO user) throws SQLException {

    Connection conexion = null;
    try {
      conexion = GestorDeConexionesBD.getConnection();
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      if (user != null) {
        // throw new SQLException("Problemas con la clave!!!!");
        user.setJuegosEnCurso(usuarioDAO.getEnCursoByUser(user.getSeudonimo(), conexion));
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    } finally {
      conexion.close();
    }

  }

  public UsuarioVO buscarUsuario(String email, String pass) throws java.sql.SQLException {
    Connection conexion = null;
    UsuarioVO devolver = null;
    try {
      conexion = GestorDeConexionesBD.getConnection();
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      if (usuarioDAO.existeUsuarioEmail(email, pass, conexion)) {
    	  devolver = usuarioDAO.getUsuarioEmail(email, conexion);
      } else if (usuarioDAO.existeUsuarioSeudonimo(email, pass, conexion)) {
    	  devolver = usuarioDAO.getUsuario(email, conexion);
      } else {
    	  devolver = null;
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    } finally {
      conexion.close();
    }
    return devolver;
  }

  public UsuarioVO getUser(String identificacion) throws java.sql.SQLException {
    Connection conexion = null;
    UsuarioVO devolver = null;
    try {
      conexion = GestorDeConexionesBD.getConnection();
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      devolver = usuarioDAO.getUsuario(identificacion, conexion);
    } catch (Exception e) {
      e.printStackTrace(System.err);
    } finally {
      conexion.close();
    }
    return devolver;

  }
  
  public String getEmail(String identificacion) throws java.sql.SQLException {
	    Connection conexion = null;
	    String devolver = null;
	    try {
	      conexion = GestorDeConexionesBD.getConnection();
	      UsuarioDAO usuarioDAO = new UsuarioDAO();
	      if (usuarioDAO.existeEmail(identificacion, conexion)) {
	    	  devolver = identificacion;
	      } else {
	    	  devolver = usuarioDAO.getEmail(identificacion, conexion);
	      }
	    } catch (Exception e) {
	      e.printStackTrace(System.err);
	    } finally {
	      conexion.close();
	    }
	    return devolver;

	  }

  public ArrayList<LogroVO> getLogros() throws java.sql.SQLException {
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

  public ArrayList<JuegoVO> getJuegos() throws java.sql.SQLException {
    Connection conexion = null;
    ArrayList<JuegoVO> devolver = null;
    try {
      conexion = GestorDeConexionesBD.getConnection();
      JuegoDAO juegoDAO = new JuegoDAO();
      devolver = juegoDAO.getAll(conexion);
    } catch (Exception e) {
      e.printStackTrace(System.err);
    } finally {
      conexion.close();
    }
    return devolver;
  }

  public ArrayList<PublicacionVO> getPublicaciones() throws java.sql.SQLException {
    Connection conexion = null;
    ArrayList<PublicacionVO> devolver = null;
    try {
      conexion = GestorDeConexionesBD.getConnection();
      PublicacionDAO publicacionDAO = new PublicacionDAO();
      devolver = publicacionDAO.getAll(conexion);
    } catch (Exception e) {
      e.printStackTrace(System.err);
    } finally {
      conexion.close();
    }
    return devolver;
  }

  public ArrayList<PublicacionVO> getPublicacionesOfAnUser(String user) throws java.sql.SQLException {
    Connection conexion = null;
    ArrayList<PublicacionVO> devolver = null;
    try {
      conexion = GestorDeConexionesBD.getConnection();
      PublicacionDAO publicacionDAO = new PublicacionDAO();
      devolver = publicacionDAO.getPublicacionOfAnUser(user,conexion);
    } catch (Exception e) {
      e.printStackTrace(System.err);
    } finally {
      conexion.close();
    }
    return devolver;
  }
  public void anadirPublicacion(PublicacionVO pub) throws java.sql.SQLException {
    Connection conexion = null;
    try {
      conexion = GestorDeConexionesBD.getConnection();
      PublicacionDAO publicacionDAO = new PublicacionDAO();
      publicacionDAO.addPublicacion(pub,conexion);
    } catch (Exception e) {
      e.printStackTrace(System.err);
    } finally {
      conexion.close();
    }
  }

  public void anadirJuegoAUser(UsuarioVO user, int id_juego, String lista) throws SQLException {

    Connection conexion = null;
    try {
      conexion = GestorDeConexionesBD.getConnection();
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      if (user != null) {
    	switch (lista) {
    	case "pendiente": 
    		usuarioDAO.insertarJuegoPendiente(user, id_juego, conexion);
    		user.setJuegosPendientes(usuarioDAO.getPendientesByUser(user.getSeudonimo(), conexion));
    		break;
      	case "enCurso": 
      		usuarioDAO.insertarJuegoEnCurso(user, id_juego, conexion);
      		user.setJuegosEnCurso(usuarioDAO.getEnCursoByUser(user.getSeudonimo(), conexion));
      		break;
    	case "Completado": 
    		usuarioDAO.insertarJuegoCompletado(user, id_juego, conexion);
    		user.setJuegosCompletados(usuarioDAO.getCompletadosByUser(user.getSeudonimo(), conexion));
			break;
    	}
        // throw new SQLException("Problemas con la clave!!!!");
       
        
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    } finally {
      conexion.close();
    }

  }

  public static void main(String[] args) throws SQLException {

  }
}
