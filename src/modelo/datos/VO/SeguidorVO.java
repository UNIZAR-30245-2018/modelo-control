package modelo.datos.VO;

import java.time.LocalDate;

/**
 * @author Jorge Rambla
 *
 */
public class SeguidorVO {
  private String usuario;
  private String usuario_seguido;
  private LocalDate fecha;

  /**
   * @param usuario
   * @param usuario_seguido
   * 
   *        Construye el objeto usuario_seguidor con TODOS los datos
   */
  public SeguidorVO(String usuario, String usuario_seguido, LocalDate fecha) {
    super();
    this.usuario = usuario;
    this.usuario_seguido = usuario_seguido;
    this.fecha = fecha;
  }

  /**
   * Constructor de objeto vacio
   */
  public SeguidorVO() {};

  @Override
  public String toString() {
    return "SeguidorVO {\n\tusuario: " + usuario + "\n\tusuario_seguido: "
        + usuario_seguido + "\n\tfecha: " + fecha + "\n}";
  }

  public String toSQLInsert() {
    return "INSERT INTO seguidor (usuario, usuario_seguido, fecha) VALUES (\"" + usuario
        + "\", \"" + usuario_seguido + "\", '" + fecha + "');";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
    result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
    result =
        prime * result + ((usuario_seguido == null) ? 0 : usuario_seguido.hashCode());
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
    if (fecha == null) {
      if (other.fecha != null) {
        return false;
      }
    } else if (!fecha.equals(other.fecha)) {
      return false;
    }
    if (usuario == null) {
      if (other.usuario != null) {
        return false;
      }
    } else if (!usuario.equals(other.usuario)) {
      return false;
    }
    if (usuario_seguido == null) {
      if (other.usuario_seguido != null) {
        return false;
      }
    } else if (!usuario_seguido.equals(other.usuario_seguido)) {
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

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }


}
