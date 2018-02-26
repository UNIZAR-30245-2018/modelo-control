/**
 * 
 */
package modelo.datos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.datos.VO.ListaJuegosVO;

/**
 * @author Jorge Rambla
 *
 */
public class ListaJuegosDAO {
	
	
	/*Método que saca todos los juegos completados de un usuario */
	public ArrayList<ListaJuegosVO> getCompletadosByUser(String user, Connection conexion) {
		ArrayList<ListaJuegosVO> retVal = new ArrayList<>();

	    try {
	      String queryCompletados = "SELECT * FROM juegoCompletado WHERE usuario = ?";

	      PreparedStatement psCompletados = conexion.prepareStatement(queryCompletados);
	      
	      psCompletados.setString(1, user);
	      

	      ResultSet rs = psCompletados.executeQuery();

	      if (!rs.first()) {
	        throw new SQLException(
	            "Error: No se ha encontrado ningún juego completado al usuario " + user);
	      } else {
	    	  while (rs.next()) {
	    		  
	              String usuario = rs.getString("usuario");
	              int juego = rs.getInt("juego");
	              retVal.add(new ListaJuegosVO(juego,usuario));
	          }
	      }
	    } catch (Exception e) {
	      e.printStackTrace(System.err);
	    }

	    return retVal;
		
	}

	/*Método que saca todos los juegos en curso de un usuario */
	public ArrayList<ListaJuegosVO> getEnCursoByUser(String user, Connection conexion) {
		ArrayList<ListaJuegosVO> retVal = new ArrayList<>();

	    try {
	      String queryCompletados = "SELECT * FROM juegoEnCurso WHERE usuario = ?";

	      PreparedStatement psCompletados = conexion.prepareStatement(queryCompletados);
	      
	      psCompletados.setString(1, user);
	      

	      ResultSet rs = psCompletados.executeQuery();

	      if (!rs.first()) {
	        throw new SQLException(
	            "Error: No se ha encontrado ningún juego en curso al usuario " + user);
	      } else {
	    	  while (rs.next()) {
	    		  
	              String usuario = rs.getString("usuario");
	              int juego = rs.getInt("juego");
	              retVal.add(new ListaJuegosVO(juego,usuario));
	          }
	      }
	    } catch (Exception e) {
	      e.printStackTrace(System.err);
	    }

	    return retVal;
		
	}

	/*Método que saca todos los juegos de un usuario de un usuario */
	public ArrayList<ListaJuegosVO> getPendientesByUser(String user, Connection conexion) {
		ArrayList<ListaJuegosVO> retVal = new ArrayList<>();

	    try {
	      String queryCompletados = "SELECT * FROM juegoPendiente WHERE usuario = ?";

	      PreparedStatement psCompletados = conexion.prepareStatement(queryCompletados);
	      
	      psCompletados.setString(1, user);
	      

	      ResultSet rs = psCompletados.executeQuery();

	      if (!rs.first()) {
	        throw new SQLException(
	            "Error: No se ha encontrado ningún juego pendiente al usuario " + user);
	      } else {
	    	  while (rs.next()) {
	    		  
	              String usuario = rs.getString("usuario");
	              int juego = rs.getInt("juego");
	              retVal.add(new ListaJuegosVO(juego,usuario));
	          }
	      }
	    } catch (Exception e) {
	      e.printStackTrace(System.err);
	    }

	    return retVal;
		
	}

	/*Método que saca todos los juegos de un usuario, incluyendo las 3 listas*/
	public ArrayList<ListaJuegosVO> getListaByUser(String user, Connection conexion) {
		ArrayList<ListaJuegosVO> retVal = new ArrayList<>();

	    try {
	     retVal.addAll(getCompletadosByUser(user,conexion));
	     retVal.addAll(getEnCursoByUser(user,conexion));
	     retVal.addAll(getPendientesByUser(user,conexion));
	    } catch (Exception e) {
	      e.printStackTrace(System.err);
	    }

	    return retVal;
	  }
}

