package modelo.datos.VO;

import java.util.ArrayList;

/**
 * @author Jorge Rambla
 *
 */
public class test {


  /**
   * @param args
   */
  public static void main(String[] args) {
    UsuarioVO u = new UsuarioVO("yorch044", "Jorge Rambla", "yorch044zgz@gmail.com",
        "4564156s4f56s4d56sdf", null, 80, 10);
    System.out.println(u.getPorcentajeNivel());
  }

}
