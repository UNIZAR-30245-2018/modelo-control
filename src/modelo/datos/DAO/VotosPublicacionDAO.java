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
  public String getMasVotadoMes(int year, int mes, Connection conexion) {
    String retVal = "error";

    try {
      String query = "SELECT usuario FROM publicacion WHERE id_publicacion = "
          + "(SELECT id_publicacion FROM votosPublicacion WHERE YEAR(fecha) = ? AND MONTH(fecha) = ? GROUP BY id_publicacion ORDER BY COUNT(*) LIMIT 1)";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setInt(1, year);
      ps.setInt(2, mes);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException("Error: No hay publicaciones en la base de datos.");
      } else {
        retVal = rs.getString(1);
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

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
          retVal.add(new VotosPublicacionVO(rs.getString(1), rs.getInt(2),
              rs.getDate(3).toLocalDate()));
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
          retVal.add(new VotosPublicacionVO(rs.getString(1), rs.getInt(2),
              rs.getDate(3).toLocalDate()));
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
          retVal.add(new VotosPublicacionVO(rs.getString(1), rs.getInt(2),
              rs.getDate(3).toLocalDate()));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;
  }

}
