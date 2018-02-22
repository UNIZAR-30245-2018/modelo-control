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
        "4564156s4f56s4d56sdf");
    UsuarioVO u2 = new UsuarioVO("yorch044", "Jorge Rambla", "yorch044zgz@gmail.com",
        "4564156s4f56s4d56sdf");
    System.out.println((u.equals(u2)) ? true : false);
    ArrayList<JuegoVO> l = new ArrayList<JuegoVO>();
    l.add(new JuegoVO(121, "AOE HD"));
    l.add(new JuegoVO(122, "AOghnE HD"));
    u.setJuegosCompletados(l);
    System.out.println((u.equals(u2)) ? true : false);
    System.out.println(u);
  }

}
