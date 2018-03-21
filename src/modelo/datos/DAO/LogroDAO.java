/**
 * 
 */
package modelo.datos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.datos.VO.LogroVO;

/**
 * @author Jorge Rambla
 *
 */
public class LogroDAO {
  /**
   * @param id_logro
   * @param conexion
   * @return
   */
  public LogroVO getLogro(String id_logro, Connection conexion) {
    LogroVO retVal = new LogroVO();

    try {
      String query = "SELECT * FROM logro WHERE id_logro = ?";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, id_logro);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ningun logro con el id: " + id_logro);
      } else {
        retVal = new LogroVO(rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5), rs.getInt(6),
            (rs.getInt(7) == 0) ? false : true);
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

  public ArrayList<LogroVO> getAll(Connection conexion) {
    ArrayList<LogroVO> retVal = new ArrayList<LogroVO>();
    try {
      String query = "SELECT * from logro";

      PreparedStatement ps = conexion.prepareStatement(query);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException("Error: No hay ningun usuario en la tabla usuario");
      } else {
        do {
          retVal.add(new LogroVO(rs.getString(1), rs.getString(2), rs.getString(3),
              rs.getString(4), rs.getString(5), rs.getInt(6),
              (rs.getInt(7) == 0) ? false : true));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }
}
