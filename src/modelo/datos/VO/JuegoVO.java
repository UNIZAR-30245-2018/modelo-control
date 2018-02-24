package modelo.datos.VO;

/**
 * @author Jorge Rambla
 *
 */
public class JuegoVO {
  private int id_juego;
  private String nombre;

  /**
   * @param id_juego
   * @param nombre
   * 
   *        Construye el objeto Juego con TODOS los parametros
   */
  public JuegoVO(int id_juego, String nombre) {
    super();
    this.id_juego = id_juego;
    this.nombre = nombre;
  }

  /**
   * Constructor del objeto vacio
   */
  public JuegoVO() {};

  @Override
  public String toString() {
    return "JuegoVO {id_juego=" + id_juego + ", nombre=" + nombre + "}";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id_juego;
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof JuegoVO)) {
      return false;
    }
    JuegoVO other = (JuegoVO) obj;
    if (id_juego != other.id_juego) {
      return false;
    }
    if (nombre == null) {
      if (other.nombre != null) {
        return false;
      }
    } else if (!nombre.equals(other.nombre)) {
      return false;
    }
    return true;
  }

  public int getId() {
    return id_juego;
  }

  public void setId(int id_juego) {
    this.id_juego = id_juego;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
