/**
 * 
 */
package modelo.datos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.datos.VO.ListaJuegosVO;

/**
 * @author Jorge Rambla
 *
 */
public class ListaJuegosDAO {


  /* Método que saca todos los juegos completados de un usuario */
  public ArrayList<ListaJuegosVO> getCompletadosByUser(String user, Connection conexion) {
    ArrayList<ListaJuegosVO> retVal = new ArrayList<>();

    try {
      String queryCompletados = "SELECT * FROM juegoCompletado WHERE usuario = ?";

      PreparedStatement psCompletados = conexion.prepareStatement(queryCompletados);

      psCompletados.setString(1, user);


      ResultSet rs = psCompletados.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ningún juego completado al usuario " + user);
      } else {
        do {
          retVal.add(new ListaJuegosVO(rs.getInt(2), rs.getString(1), 2));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;

  }

  /* Método que saca todos los juegos en curso de un usuario */
  public ArrayList<ListaJuegosVO> getEnCursoByUser(String user, Connection conexion) {
    ArrayList<ListaJuegosVO> retVal = new ArrayList<>();

    try {
      String queryCompletados = "SELECT * FROM juegoEnCurso WHERE usuario = ?";

      PreparedStatement psCompletados = conexion.prepareStatement(queryCompletados);

      psCompletados.setString(1, user);


      ResultSet rs = psCompletados.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ningún juego en curso al usuario " + user);
      } else {
        do {
          retVal.add(new ListaJuegosVO(rs.getInt(2), rs.getString(1), 1));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;

  }

  /* Método que saca todos los juegos de un usuario de un usuario */
  public ArrayList<ListaJuegosVO> getPendientesByUser(String user, Connection conexion) {
    ArrayList<ListaJuegosVO> retVal = new ArrayList<>();

    try {
      String queryPendientes = "SELECT * FROM juegoPendiente WHERE usuario = ?";

      PreparedStatement psPendientes = conexion.prepareStatement(queryPendientes);

      psPendientes.setString(1, user);


      ResultSet rs = psPendientes.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ningún juego pendiente al usuario " + user);
      } else {
        do {
          retVal.add(new ListaJuegosVO(rs.getInt(2), rs.getString(1), 0));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;

  }

  /* Método que saca todos los juegos de un usuario, incluyendo las 3 listas */
  public ArrayList<ListaJuegosVO> getListaByUser(String user, Connection conexion) {
    ArrayList<ListaJuegosVO> retVal = new ArrayList<ListaJuegosVO>();

    try {
      retVal.addAll(getCompletadosByUser(user, conexion));
      retVal.addAll(getEnCursoByUser(user, conexion));
      retVal.addAll(getPendientesByUser(user, conexion));
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;
  }

  public ArrayList<ListaJuegosVO> getAllLista(Connection conexion) {
    ArrayList<ListaJuegosVO> retVal = new ArrayList<ListaJuegosVO>();

    try {
      String query = "SELECT * FROM juegoPendiente";

      PreparedStatement ps = conexion.prepareStatement(query);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
      } else {
        do {
          retVal.add(new ListaJuegosVO(rs.getInt(2), rs.getString(1), 0));
        } while (rs.next());
      }

      query = "SELECT * FROM juegoEnCurso";

      ps = conexion.prepareStatement(query);

      rs = ps.executeQuery();

      if (!rs.first()) {
      } else {
        do {
          retVal.add(new ListaJuegosVO(rs.getInt(2), rs.getString(1), 1));
        } while (rs.next());
      }


      query = "SELECT * FROM juegoCompletado";

      ps = conexion.prepareStatement(query);

      rs = ps.executeQuery();

      if (!rs.first()) {
      } else {
        do {
          retVal.add(new ListaJuegosVO(rs.getInt(2), rs.getString(1), 2));
        } while (rs.next());
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;
  }
}

