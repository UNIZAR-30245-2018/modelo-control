/**
 * 
 */
package modelo.datos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.datos.VO.PublicacionVO;

/**
 * @author Jorge Rambla
 *
 */
public class PublicacionDAO {
  public PublicacionVO getPublicacion(int id_publicacion, Connection conexion) {
    PublicacionVO retVal = new PublicacionVO();
    try {
      String query = "SELECT * FROM publicacion WHERE id_publicacion = ?";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setInt(1, id_publicacion);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ninguna publicacion con el id " + id_publicacion);
      } else {
        retVal =
            new PublicacionVO(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(),
                (rs.getInt(4) == 0) ? false : true, rs.getInt(5), rs.getString(6));
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;
  }
}
