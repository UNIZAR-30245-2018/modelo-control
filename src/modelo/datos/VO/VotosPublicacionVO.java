package modelo.datos.VO;

import java.time.LocalDate;

/**
 * @author Jorge Rambla
 *
 */
public class VotosPublicacionVO {
  private String usuario;
  private int publicacion;
  private LocalDate fecha;

  /**
   * @param usuario
   * @param publicacion
   * 
   *        Construye el objeto VotosPublicacionVO dados TODOS los parametros
   */
  public VotosPublicacionVO(String usuario, int publicacion, LocalDate fecha) {
    super();
    this.usuario = usuario;
    this.publicacion = publicacion;
    this.fecha = fecha;
  }

  /**
   * Constructor de objeto vacio
   */
  public VotosPublicacionVO() {};



  @Override
  public String toString() {
    return "VotosPublicacionVO {\n\tusuario: " + usuario + "\n\tpublicacion: "
        + publicacion + "\n\tfecha: " + fecha + "\n}";
  }

  public String toSQLInsert() {
    return "INSERT INTO votosPublicacion (usuario, id_publicacion) VALUES (\"" + usuario
        + "\", " + publicacion + ", '" + fecha + "');";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
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
    if (fecha == null) {
      if (other.fecha != null) {
        return false;
      }
    } else if (!fecha.equals(other.fecha)) {
      return false;
    }
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

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

}
