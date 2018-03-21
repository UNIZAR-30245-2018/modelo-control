/**
 * 
 */
package modelo.datos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.datos.VO.VotosPublicacionVO;

/**
 * @author Jorge Rambla
 *
 */
public class VotosPublicacionDAO {
  public ArrayList<VotosPublicacionVO> getVotosPorUsuario(String user,
      Connection conexion) {
    ArrayList<VotosPublicacionVO> retVal = new ArrayList<VotosPublicacionVO>();

    try {
      String query = "SELECT * FROM votosPublicacion WHERE usuario = ?";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, user);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ningun usuario de nombre " + user);
      } else {
        do {
          retVal.add(new VotosPublicacionVO(rs.getString(1), rs.getInt(2)));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;
  }

  public ArrayList<VotosPublicacionVO> getVotosPorPublicacion(int id_pub,
      Connection conexion) {
    ArrayList<VotosPublicacionVO> retVal = new ArrayList<VotosPublicacionVO>();

    try {
      String query = "SELECT * FROM votosPublicacion WHERE id_publicacion = ?";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setInt(1, id_pub);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ninguna publicacion con un id: " + id_pub);
      } else {
        do {
          retVal.add(new VotosPublicacionVO(rs.getString(1), rs.getInt(2)));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;
  }

  public ArrayList<VotosPublicacionVO> getAll(Connection conexion) {
    ArrayList<VotosPublicacionVO> retVal = new ArrayList<VotosPublicacionVO>();

    try {
      String query = "SELECT * FROM votosPublicacion";

      PreparedStatement ps = conexion.prepareStatement(query);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
      } else {
        do {
          retVal.add(new VotosPublicacionVO(rs.getString(1), rs.getInt(2)));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;
  }

}
