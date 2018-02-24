/**
 * 
 */
package modelo.datos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.datos.VO.LogroVO;

/**
 * @author Jorge Rambla
 *
 */
public class LogroDAO {
  public LogroVO getLogro(int id_logro, Connection conexion) {
    LogroVO retVal = new LogroVO();

    try {
      String query = "SELECT * FROM logro WHERE id_logro = ?";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setInt(1, id_logro);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ningun logro con el id: " + id_logro);
      } else {
        retVal = new LogroVO(rs.getInt(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getInt(5));
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;
  }
}
