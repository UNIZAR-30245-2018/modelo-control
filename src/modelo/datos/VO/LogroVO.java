package modelo.datos.VO;

/**
 * @author usuario
 *
 */
public class LogroVO {
  private int id_logro;
  private String nombre;
  private String imagen;
  private String descripcion;
  private int experiencia;

  /**
   * @param id
   * @param nombre
   * @param imagen
   * @param descripcion
   * @param experiencia
   * 
   *        Construye el objeto Logro con TODOS los valores
   */
  public LogroVO(int id_logro, String nombre, String imagen, String descripcion,
      int experiencia) {
    super();
    this.id_logro = id_logro;
    this.nombre = nombre;
    this.imagen = (imagen == null) ? "sin_imagen" : imagen;
    this.descripcion = descripcion;
    this.experiencia = experiencia;
  }

  /**
   * @param id
   * @param nombre
   * @param descripcion
   * @param experiencia
   * 
   *        Construye el objeto Logro con el valor de imagen por defecto
   */
  public LogroVO(int id, String nombre, String descripcion, int experiencia) {
    this(id, nombre, null, descripcion, experiencia);
  }

  /**
   * Constructor de objeto vacio
   */
  public LogroVO() {};

  @Override
  public String toString() {
    return "LogroVO {id_logro=" + id_logro + ", nombre=" + nombre + ", imagen=" + imagen
        + ", descripcion=" + descripcion + ", experiencia=" + experiencia + "}";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
    result = prime * result + experiencia;
    result = prime * result + id_logro;
    result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
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
    if (!(obj instanceof LogroVO)) {
      return false;
    }
    LogroVO other = (LogroVO) obj;
    if (descripcion == null) {
      if (other.descripcion != null) {
        return false;
      }
    } else if (!descripcion.equals(other.descripcion)) {
      return false;
    }
    if (experiencia != other.experiencia) {
      return false;
    }
    if (id_logro != other.id_logro) {
      return false;
    }
    if (imagen == null) {
      if (other.imagen != null) {
        return false;
      }
    } else if (!imagen.equals(other.imagen)) {
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
    return id_logro;
  }

  public void setId(int id_logro) {
    this.id_logro = id_logro;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public int getExperiencia() {
    return experiencia;
  }

  public void setExperiencia(int experiencia) {
    this.experiencia = experiencia;
  }

}
