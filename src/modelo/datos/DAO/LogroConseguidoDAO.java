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

  public boolean darLogro(String usuario, String logro, Connection conexion) {
    boolean retVal = false;
    try {
      String query =
          "INSERT INTO logroConseguido (usuario, id_logro) VALUES (?,?)";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, usuario);
      ps.setString(2, logro);

      if ((ps.executeUpdate()) != 1) {
        throw new SQLException("Ha habido problemas a la hora de insertar el logro: " + logro + " al usuario " + usuario);
      } else {
        retVal = true;
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

  /* Método que saca todos los logros conseguidos de un usuario */
  public ArrayList<LogroConseguidoVO> getCompletadosByUser(String user,
      Connection conexion) {
    ArrayList<LogroConseguidoVO> retVal = new ArrayList<LogroConseguidoVO>();

    try {
      String query = "SELECT * FROM logroConseguido WHERE usuario = ?";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, user);


      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ningun juego completado al usuario " + user);
      } else {
        do {
          retVal.add(new LogroConseguidoVO(rs.getString(1), rs.getString(2)));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;

  }

  public ArrayList<LogroConseguidoVO> getAll(Connection conexion) {
    ArrayList<LogroConseguidoVO> retVal = new ArrayList<LogroConseguidoVO>();

    try {
      String query = "SELECT * FROM logroConseguido";

      PreparedStatement ps = conexion.prepareStatement(query);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
      } else {
        do {
          retVal.add(new LogroConseguidoVO(rs.getString(1), rs.getString(2)));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;

  }
}
