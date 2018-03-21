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
        do {
          retVal.add(new SeguidorVO(rs.getString(1), rs.getString(2)));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;
  }
  
  public ArrayList<SeguidorVO> getAll(Connection conexion) {
    ArrayList<SeguidorVO> retVal = new ArrayList<SeguidorVO>();

    try {
      String query = "SELECT * FROM seguidor";

      PreparedStatement ps = conexion.prepareStatement(query);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
      } else {
        do {
          retVal.add(new SeguidorVO(rs.getString(1), rs.getString(2)));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;
  }
}
