package modelo.datos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.datos.VO.JuegoVO;

/**
 * @author Jorge Rambla
 *
 */
public class JuegoDAO {
  /**
   * @param id_juego
   * @param conexion
   * @return
   */
  public JuegoVO getJuego(int id_juego, Connection conexion) {
    JuegoVO retVal = new JuegoVO();

    try {
      String query = "SELECT * FROM juego WHERE id_juego = ?";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setInt(1, id_juego);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ningun juego con el id: " + id_juego);
      } else {
        retVal = new JuegoVO(rs.getInt(1), rs.getString(2));
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

  public ArrayList<JuegoVO> getAll(Connection conexion) {
    ArrayList<JuegoVO> retVal = new ArrayList<JuegoVO>();
    try {
      String query = "SELECT * from juego";

      PreparedStatement ps = conexion.prepareStatement(query);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException("Error: No hay ningun usuario en la tabla usuario");
      } else {
        do {
          retVal.add(new JuegoVO(rs.getInt(1), rs.getString(2)));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

}
