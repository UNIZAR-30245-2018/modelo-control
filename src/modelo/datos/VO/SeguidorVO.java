package modelo.datos.VO;

/**
 * @author Jorge Rambla
 *
 */
public class SeguidorVO {
  private String usuario;
  private String usuario_seguido;

  /**
   * @param usuario
   * @param usuario_seguido
   * 
   *        Construye el objeto usuario_seguidor con TODOS los datos
   */
  public SeguidorVO(String usuario, String usuario_seguido) {
    super();
    this.usuario = usuario;
    this.usuario_seguido = usuario_seguido;
  }
/**
 * Constructor de objeto vacio
 */
  public SeguidorVO(){};
  
  @Override
public String toString() {
  return "SeguidorVO {\n\tusuario: " + usuario + "\n\tusuario_seguido: " + usuario_seguido
      + "\n}";
}
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result =
        prime * result + ((usuario_seguido == null) ? 0 : usuario_seguido.hashCode());
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
    if (!(obj instanceof SeguidorVO)) {
      return false;
    }
    SeguidorVO other = (SeguidorVO) obj;
    if (usuario_seguido == null) {
      if (other.usuario_seguido != null) {
        return false;
      }
    } else if (!usuario_seguido.equals(other.usuario_seguido)) {
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


  public String getUsuario_seguido() {
    return usuario_seguido;
  }


  public void setUsuario_seguido(String usuario_seguido) {
    this.usuario_seguido = usuario_seguido;
  }


}
