/**
 * 
 */
package modelo.datos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import modelo.datos.VO.SeguidorVO;
import modelo.datos.VO.UsuarioVO;

/**
 * @author Jorge Rambla
 *
 */
public class SeguidorDAO {

  public String getMasSeguidoMes(int year, int mes, Connection conexion) {
    String retVal = "error";

    try {
      String query =
          "SELECT usuario_seguido, COUNT(*) FROM seguidor WHERE YEAR(fecha) = ? AND MONTH(fecha) = ? GROUP BY usuario_seguido ORDER BY count(*) DESC LIMIT 1";
      
      PreparedStatement ps = conexion.prepareStatement(query);
      
      ps.setInt(1, year);
      ps.setInt(2, mes);
      
      ResultSet rs = ps.executeQuery();
      
      if (!rs.first()){
        throw new SQLException("Error: No hay usuarios en la base de datos.");
      } else {
        retVal = rs.getString(1);
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

  public ArrayList<SeguidorVO> getListaSeguidos(String user, Connection conexion) {
    ArrayList<SeguidorVO> retVal = new ArrayList<SeguidorVO>();

    try {
      String query = "SELECT * FROM seguidor WHERE usuario = ?";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, user);

      ResultSet rs = ps.executeQuery();

      if (rs.first()) {
        do {
          retVal.add(new SeguidorVO(rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate()));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;
  }

  public ArrayList<SeguidorVO> getListaSeguidores(String user, Connection conexion) {
    ArrayList<SeguidorVO> retVal = new ArrayList<SeguidorVO>();

    try {
      String query = "SELECT * FROM seguidor WHERE usuario_seguido = ?";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, user);

      ResultSet rs = ps.executeQuery();

      if (rs.first()) {
        do {
          retVal.add(new SeguidorVO(rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate()));
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
          retVal.add(new SeguidorVO(rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate()));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;
  }

  public void addSeguidor(UsuarioVO user,UsuarioVO userASeguir,Connection conexion) {

    try {
      String query = "INSERT INTO seguidor(usuario,usuario_seguido,fecha) VALUES (?,?,?)";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, user.getSeudonimo());
      ps.setString(2, userASeguir.getSeudonimo());
      ps.setString(3, LocalDate.now().toString());

      if(ps.executeUpdate() != 1) {
        throw new SQLException("Ha habido problemas a la hora de insertar el seguidor");
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

  public void deleteSeguidor(UsuarioVO user,UsuarioVO userASeguir,Connection conexion) {

    try {
      String query = "DELETE FROM seguidor WHERE usuario = ?  AND usuario_seguido = ?";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, user.getSeudonimo());
      ps.setString(2, userASeguir.getSeudonimo());

      if(ps.executeUpdate() != 1) {
        throw new SQLException("Ha habido problemas a la hora de borrar el seguidor");
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }
}
