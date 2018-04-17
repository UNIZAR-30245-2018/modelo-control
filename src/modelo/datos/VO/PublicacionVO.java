package modelo.datos.VO;

import java.time.LocalDate;

/**
 * @author Jorge Rambla
 *
 */
public class PublicacionVO {
  private int id_publicacion;
  private String usuario;
  private LocalDate fecha;
  private boolean spoiler;
  private int juego;
  private String texto;

  /**
   * @param id_publicacion
   * @param usuario
   * @param fecha
   * @param spoiler
   * @param juego
   * @param texto
   * 
   *        Construye el objeto PublicacionVO con TODOS los parametros
   */
  public PublicacionVO(int id_publicacion, String usuario, LocalDate fecha,
      boolean spoiler, int juego, String texto) {
    super();
    this.id_publicacion = id_publicacion;
    this.usuario = usuario;
    this.fecha = fecha;
    this.spoiler = spoiler;
    this.juego = juego;
    this.texto = texto;
  }

  /**
   * @param id_publicacion
   * @param usuario
   * @param fecha
   * @param juego
   * @param texto
   * 
   *        Construye el objeto PublicacionVO con el paremtro spoiler por defecto
   */
  public PublicacionVO(int id_publicacion, String usuario, LocalDate fecha, int juego,
      String texto) {
    this(id_publicacion, usuario, fecha, false, juego, texto);
  }

  /**
   * Constructor de objeto vacio
   */
  public PublicacionVO() {}

  @Override
  public String toString() {
    return "PublicacionVO {\n\tid_publicacion: " + id_publicacion + "\n\tusuario: "
        + usuario + "\n\tfecha: " + fecha + "\n\tspoiler: " + spoiler + "\n\tjuego: "
        + juego + "\n\ttexto: " + texto + "\n}";
  }

  public String toSQLInsert() {
    int sp = (spoiler) ? 1 : 0;
    return "INSERT INTO publicacion (id_publicacion, usuario, fecha, spoiler, juego, texto) VALUES ("
        + id_publicacion + ", \"" + usuario + "\", '" + fecha + "', " + sp + ", " + 0
        + ", \"" + texto + "\");";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
    result = prime * result + id_publicacion;
    result = prime * result + juego;
    result = prime * result + (spoiler ? 1231 : 1237);
    result = prime * result + ((texto == null) ? 0 : texto.hashCode());
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
    if (!(obj instanceof PublicacionVO)) {
      return false;
    }
    PublicacionVO other = (PublicacionVO) obj;
    if (fecha == null) {
      if (other.fecha != null) {
        return false;
      }
    } else if (!fecha.equals(other.fecha)) {
      return false;
    }
    if (id_publicacion != other.id_publicacion) {
      return false;
    }
    if (juego != other.juego) {
      return false;
    }
    if (spoiler != other.spoiler) {
      return false;
    }
    if (texto == null) {
      if (other.texto != null) {
        return false;
      }
    } else if (!texto.equals(other.texto)) {
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

  public int getId_publicacion() {
    return id_publicacion;
  }

  public void setId_publicacion(int id_publicacion) {
    this.id_publicacion = id_publicacion;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public int getJuego() {
    return juego;
  }

  public void setJuego(int juego) {
    this.juego = juego;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public boolean esSpoiler() {
    return spoiler;
  }

  public void setSpoiler(boolean spoiler) {
    this.spoiler = spoiler;
  }
}
