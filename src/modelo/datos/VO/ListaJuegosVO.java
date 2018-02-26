package modelo.datos.VO;

/**
 * @author Jorge Rambla
 *
 */
public class ListaJuegosVO {
  private String usuario;
  private int juego;

  /**
   * @param juego
   * @param usuario
   * 
   *        Construye el objeto ListaJuegosVO con TODOS los parametros
   */
  public ListaJuegosVO(int juego, String usuario) {
    super();
    this.juego = juego;
    this.usuario = usuario;
  }

  /*Constructor vacío*/
  public ListaJuegosVO(){};
  
  
  
  @Override
  public String toString() {
    return "ListaJuegosVO {usuario=" + usuario + ", juego=" + juego + "}";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + juego;
    result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
    if (!(obj instanceof ListaJuegosVO)) {
      return false;
    }
    ListaJuegosVO other = (ListaJuegosVO) obj;
    if (juego != other.juego) {
      return false;
    }
    if (usuario == null) {
      if (other.usuario != null) {
        return false;
      }
    } else if (!usuario.equals(other.usuario)) {
      return false;
    }
    return true;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public int getJuego() {
    return juego;
  }

  public void setJuego(int juego) {
    this.juego = juego;
  }


}
