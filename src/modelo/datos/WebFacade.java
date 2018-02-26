 /**
 * 
 */
package modelo.datos;

import java.sql.Connection;
import java.sql.SQLException;
import modelo.datos.BD.GestorDeConexionesBD;
import modelo.datos.DAO.UsuarioDAO;
import modelo.datos.VO.UsuarioVO;

/**
 * @author Jorge Rambla
 *
 */
public class WebFacade {
  public static void test(String email) throws SQLException{
    Connection conexion = null;
    
    try {
      conexion = GestorDeConexionesBD.getConnection();
      UsuarioDAO aux = new UsuarioDAO();
      String seudonimo = aux.getSeudonimo(email, conexion);
      System.out.println(seudonimo);
      System.out.println(aux.getEmail(seudonimo, conexion));
      System.out.println(aux.getExperiencia(seudonimo, conexion));
      System.out.println(aux.getImagen(seudonimo, conexion));
      System.out.println(aux.getNivel(seudonimo, conexion));
      System.out.println(aux.getNombre(seudonimo, conexion));
      System.out.println(aux.getPassword(seudonimo, conexion));
      
      System.out.println();
      
      System.out.println(aux.getUsuario(seudonimo, conexion));
      
      System.out.println("Todos los usuarios:");
      
      for (UsuarioVO u : aux.getAllUsuario(conexion)){
        System.out.println(u);
      }
    } catch (Exception e){
      e.printStackTrace(System.err);
      System.out.println("Excepcion en el metodo fachada y no lanza hacia arriba");
    } finally {
      conexion.close();
    }
  }
  
  public static void main(String[] args) throws SQLException {
    test("yorch044zgz@gmail.com");
  }
}
