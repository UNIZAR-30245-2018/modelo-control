/**
 * 
 */
package modelo.datos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.datos.VO.LogroConseguidoVO;

/**
 * @author Jorge Rambla
 *
 */
public class LogroConseguidoDAO {

		/*M�todo que saca todos los logros conseguidos de un usuario */
		public ArrayList<LogroConseguidoVO> getCompletadosByUser(String user, Connection conexion) {
			ArrayList<LogroConseguidoVO> retVal = new ArrayList<>();

		    try {
		      String query = "SELECT * FROM logroConseguido WHERE usuario = ?";

		      PreparedStatement ps= conexion.prepareStatement(query);
		      
		      ps.setString(1, user);
		      

		      ResultSet rs = ps.executeQuery();

		      if (!rs.first()) {
		        throw new SQLException(
		            "Error: No se ha encontrado ningun juego completado al usuario " + user);
		      } else {
		    	  while (rs.next()) {
		              String usuario = rs.getString("usuario");
		              int juego = rs.getInt("juego");
		              retVal.add(new LogroConseguidoVO(usuario,juego));
		          }
		      }
		    } catch (Exception e) {
		      e.printStackTrace(System.err);
		    }

		    return retVal;
			
		}
}
