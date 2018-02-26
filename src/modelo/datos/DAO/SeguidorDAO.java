/**
 * 
 */
package modelo.datos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import modelo.datos.VO.SeguidorVO;

/**
 * @author Jorge Rambla
 *
 */
public class SeguidorDAO {
	 public ArrayList<SeguidorVO> getListaSeguidores(String user, Connection conexion) {
		 ArrayList<SeguidorVO> retVal = new ArrayList<SeguidorVO>();

		    try {
		      String query = "SELECT * FROM seguidor WHERE usuario = ?";

		      PreparedStatement ps = conexion.prepareStatement(query);

		      ps.setString(1, user);

		      ResultSet rs = ps.executeQuery();

		      if (!rs.first()) {
		        throw new SQLException(
		            "Error: No se ha encontrado ningun usuario de nombre " + user);
		      } else {
		    	 while(rs.next()){
		    		 	retVal.add(new SeguidorVO(rs.getString(1), rs.getString(2)));
		    	 }
		      }
		    } catch (Exception e) {
		      e.printStackTrace(System.err);
		    }

		    return retVal;
		  }
}
