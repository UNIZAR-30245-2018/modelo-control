/**
 * 
 */
package modelo.datos.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.datos.VO.PublicacionVO;

/**
 * @author Jorge Rambla
 *
 */
public class PublicacionDAO {
  public void eliminarPublicacion(int id_publicacion, Connection conexion) {
    try {
      String query = "DELETE FROM publicacion WHERE id_publicacion = ?";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setInt(1, id_publicacion);

      if (ps.executeUpdate() != 1) {
        throw new SQLException(
            "Ha habido problemas a la hora de elimiar la publicacion con el id: "
                + id_publicacion);
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

  public void limpiarReportes(int id_publicacion, Connection conexion) {
    try {
      String query = "UPDATE publicacion SET reports = 0 WHERE id_publicacion = ?";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setInt(1, id_publicacion);

      if (ps.executeUpdate() != 1) {
        throw new SQLException(
            "Ha habido problemas a la hora de limpiar los reportes de la publicacion con el id: "
                + id_publicacion);
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

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
        retVal = new PublicacionVO(rs.getInt(1), rs.getString(2),
            rs.getDate(3).toLocalDate(), (rs.getInt(4) == 0) ? false : true, rs.getInt(5),
            rs.getString(6), rs.getInt(7));
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

  public ArrayList<PublicacionVO> getAll(Connection conexion) {
    ArrayList<PublicacionVO> retVal = new ArrayList<PublicacionVO>();
    try {
      String query = "SELECT * FROM publicacion";

      PreparedStatement ps = conexion.prepareStatement(query);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
      } else {
        do {
          retVal.add(new PublicacionVO(rs.getInt(1), rs.getString(2),
              rs.getDate(3).toLocalDate(), (rs.getInt(4) == 0) ? false : true,
              rs.getInt(5), rs.getString(6), rs.getInt(7)));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

  public ArrayList<PublicacionVO> publicacionesReports(int min, Connection conexion) {
    ArrayList<PublicacionVO> retVal = new ArrayList<PublicacionVO>();
    try {
      String query = "SELECT * FROM publicacion WHERE reports >= ? ORDER BY reports DESC";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setInt(1, min);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
      } else {
        do {
          retVal.add(new PublicacionVO(rs.getInt(1), rs.getString(2),
              rs.getDate(3).toLocalDate(), (rs.getInt(4) == 0) ? false : true,
              rs.getInt(5), rs.getString(6), rs.getInt(7)));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

  public ArrayList<PublicacionVO> publicacionesReportsRange(int min, int max,
      Connection conexion) {
    ArrayList<PublicacionVO> retVal = new ArrayList<PublicacionVO>();
    try {
      String query = "SELECT * FROM publicacion WHERE reports >= ? AND reports <= ? ORDER BY reports DESC";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setInt(1, min);
      ps.setInt(2, max);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
      } else {
        do {
          retVal.add(new PublicacionVO(rs.getInt(1), rs.getString(2),
              rs.getDate(3).toLocalDate(), (rs.getInt(4) == 0) ? false : true,
              rs.getInt(5), rs.getString(6), rs.getInt(7)));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

  public void addPublicacion(PublicacionVO publicacion,Connection conexion) {
    try {
      String query = "INSERT INTO publicacion (usuario, fecha, juego, texto) VALUES (?,?,?,?)";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, publicacion.getUsuario());
      ps.setDate(2, Date.valueOf(publicacion.getFecha()));
      ps.setInt(3, publicacion.getJuego());
      ps.setString(4, publicacion.getTexto());

      if(ps.executeUpdate() != 1) {
          throw new SQLException("Ha habido problemas a la hora de insertar el usuario");
      }
    } catch(Exception e){
          System.err.println("Ha habido una excepcion al añadir una publicacion");
    }
  }

  public ArrayList<PublicacionVO> getPublicacionOfAnUser(String username,Connection conexion) {
    ArrayList<PublicacionVO> listaPublicaciones = new ArrayList<PublicacionVO>();
    try {
      String query = "SELECT * FROM publicacion WHERE usuario = ?";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1,username);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
      } else {
        do {
          listaPublicaciones.add(new PublicacionVO(rs.getInt(1), rs.getString(2),
              rs.getDate(3).toLocalDate(), (rs.getInt(4) == 0) ? false : true,
              rs.getInt(5), rs.getString(6), rs.getInt(7)));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return listaPublicaciones;
  }



}

