/**
 * 
 */
package modelo.datos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.datos.VO.UsuarioVO;

/**
 * @author Jorge Rambla
 *
 */
public class UsuarioDAO {
  
  /**
   * @param seudonimo
   * @param conexion
   * @return UsuarioVO vacio si no existe ningun usuario con el seudonimo especificado <br>
   *         UsuarioVO con el seudonimo especificado
   */
  public UsuarioVO getUsuario(String seudonimo, Connection conexion) {
    UsuarioVO retVal = new UsuarioVO();
    try {
      String query = "SELECT * FROM usuario WHERE seudonimo = ?";

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, seudonimo);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ningun usuario con el seudonimo de " + seudonimo);
      } else {
        retVal = new UsuarioVO(rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return retVal;
  }

  public ArrayList<UsuarioVO> getAllUsuario(Connection conexion) {
    ArrayList<UsuarioVO> retVal = new ArrayList<UsuarioVO>();
    try {
      String query = "SELECT * from usuario";

      PreparedStatement ps = conexion.prepareStatement(query);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException("Error: No hay ningun usuario en la tabla usuario");
      } else {
        while (rs.next()) {
          retVal.add(new UsuarioVO(rs.getString(1), rs.getString(2), rs.getString(3),
              rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
        }
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

  public String getSeudonimo(String email, Connection conexion) {
    String retVal = "Error";
    try {
      String query = "SELECT seudonimo FROM usuario WHERE email = ?";
      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, email);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ningun usuario con el email de " + email);
      } else {
        retVal = rs.getString(1);
      }

    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

  public String getNombre(String seudonimo, Connection conexion) {
    String retVal = "Error";
    try {
      String query = "SELECT nombre FROM usuario WHERE seudonimo = ?";
      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, seudonimo);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ningun usuario con el seudonimo de " + seudonimo);
      } else {
        retVal = rs.getString(1);
      }

    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

  public String getEmail(String seudonimo, Connection conexion) {
    String retVal = "Error";
    try {
      String query = "SELECT email FROM usuario WHERE seudonimo = ?";
      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, seudonimo);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ningun usuario con el seudonimo de " + seudonimo);
      } else {
        retVal = rs.getString(1);
      }

    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

  public String getPassword(String seudonimo, Connection conexion) {
    String retVal = "Error";
    try {
      String query = "SELECT password FROM usuario WHERE seudonimo = ?";
      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, seudonimo);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ningun usuario con el seudonimo de " + seudonimo);
      } else {
        retVal = rs.getString(1);
      }

    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

  public String getImagen(String seudonimo, Connection conexion) {
    String retVal = "Error";
    try {
      String query = "SELECT imagen FROM usuario WHERE seudonimo = ?";
      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, seudonimo);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ningun usuario con el seudonimo de " + seudonimo);
      } else {
        retVal = rs.getString(1);
      }

    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

  public int getNivel(String seudonimo, Connection conexion) {
    int retVal = -1;
    try {
      String query = "SELECT nivel FROM usuario WHERE seudonimo = ?";
      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, seudonimo);

      ResultSet rs = ps.executeQuery();

      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ningun usuario con el seudonimo de " + seudonimo);
      } else {
        retVal = rs.getInt(1);
      }

    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

  public int getExperiencia(String seudonimo, Connection conexion) {
    int retVal = -1;
    try {
      String query = "SELECT experiencia FROM usuario WHERE seudonimo = ?";
      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, seudonimo);

      ResultSet rs = ps.executeQuery();
      if (!rs.first()) {
        throw new SQLException(
            "Error: No se ha encontrado ningun usuario con el seudonimo de " + seudonimo);
      } else {
        retVal = rs.getInt(1);
      }

    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return retVal;
  }

  /**
   * @param seudonimo
   * @param email
   * @param password
   * @param conexion
   * @return true si encuentra un usuario con igual nombre y contraseña, o email y contraseña
   */
  public boolean existeUsuario(String seudonimo, String email, String password,
      Connection conexion) {
    boolean retVal = false;

    try {
      if (seudonimo != null) {
        String query = "SELECT * FROM usuario WHERE seudonimo = ? AND password = ?";

        PreparedStatement ps = conexion.prepareStatement(query);

        ps.setString(1, seudonimo);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.first()) {
          return true;
        }
      } else if (email != null) {
        String query = "SELECT * FROM usuario WHERE email = ? AND password = ?";

        PreparedStatement ps = conexion.prepareStatement(query);

        ps.setString(1, email);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.first()) {
          return true;
        }
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);;
    }
    return retVal;
  }
}
