package modelo.datos.VO;

/**
 * @author Jorge Rambla
 *
 */
public class VotosPublicacionVO {
  private String usuario;
  private int publicacion;

  /**
   * @param usuario
   * @param publicacion
   * 
   *        Construye el objeto VotosPublicacionVO dados TODOS los parametros
   */
  public VotosPublicacionVO(String usuario, int publicacion) {
    super();
    this.usuario = usuario;
    this.publicacion = publicacion;
  }

  @Override
  public String toString() {
    return "VotosPublicacionVO {usuario=" + usuario + ", publicacion=" + publicacion
        + "}";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + publicacion;
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
    if (!(obj instanceof VotosPublicacionVO)) {
      return false;
    }
    VotosPublicacionVO other = (VotosPublicacionVO) obj;
    if (publicacion != other.publicacion) {
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

  public int getPublicacion() {
    return publicacion;
  }

  public void setPublicacion(int publicacion) {
    this.publicacion = publicacion;
  }

}
