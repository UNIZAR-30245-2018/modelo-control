package modelo.datos.VO;

/**
 * @author usuario
 *
 */
public class LogroVO {
  private String id_logro;
  private String nombre;
  private String imagen;
  private String imagen_conseguido;
  private String descripcion;
  private int experiencia;
  private boolean secreto;

  /**
   * @param id_logro
   * @param nombre
   * @param imagen
   * @param descripcion
   * @param experiencia
   * 
   *        Construye el objeto Logro con TODOS los valores
   */
  public LogroVO(String id_logro, String nombre, String imagen, String imagen_conseguido, String descripcion,
      int experiencia, boolean secreto) {
    super();
    this.id_logro = id_logro;
    this.nombre = nombre;
    this.imagen = (imagen == null) ? "sin_imagen" : imagen;
    this.imagen_conseguido = (imagen_conseguido == null) ? "sin_imagen_2" : imagen_conseguido;
    this.descripcion = descripcion;
    this.experiencia = experiencia;
    this.secreto = secreto;
  }

  /**
   * @param id
   * @param nombre
   * @param descripcion
   * @param experiencia
   * 
   *        Construye el objeto Logro con el valor de imagen por defecto
   */
  public LogroVO(String id, String nombre, String descripcion, int experiencia) {
    this(id, nombre, null, null, descripcion, experiencia, false);
  }

  /**
   * Constructor de objeto vacio
   */
  public LogroVO() {};

  @Override
  public String toString() {
    return "LogroVO {\n\tid_logro: " + id_logro + "\n\tnombre: " + nombre + "\n\timagen: "
        + imagen + "\n\timagen_conseguido: " + imagen_conseguido + "\n\tdescripcion: "
        + descripcion + "\n\texperiencia: " + experiencia + "\n\tsecreto: " + secreto
        + "\n}";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
    result = prime * result + experiencia;
    result = prime * result + ((id_logro == null) ? 0 : id_logro.hashCode());
    result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
    result =
        prime * result + ((imagen_conseguido == null) ? 0 : imagen_conseguido.hashCode());
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    result = prime * result + (secreto ? 1231 : 1237);
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
    if (id_logro == null) {
      if (other.id_logro != null) {
        return false;
      }
    } else if (!id_logro.equals(other.id_logro)) {
      return false;
    }
    if (imagen == null) {
      if (other.imagen != null) {
        return false;
      }
    } else if (!imagen.equals(other.imagen)) {
      return false;
    }
    if (imagen_conseguido == null) {
      if (other.imagen_conseguido != null) {
        return false;
      }
    } else if (!imagen_conseguido.equals(other.imagen_conseguido)) {
      return false;
    }
    if (nombre == null) {
      if (other.nombre != null) {
        return false;
      }
    } else if (!nombre.equals(other.nombre)) {
      return false;
    }
    if (secreto != other.secreto) {
      return false;
    }
    return true;
  }

  public String getId() {
    return id_logro;
  }

  public void setId(String id_logro) {
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

  public String getId_logro() {
    return id_logro;
  }

  public void setId_logro(String id_logro) {
    this.id_logro = id_logro;
  }

  public String getImagen_conseguido() {
    return imagen_conseguido;
  }

  public void setImagen_conseguido(String imagen_conseguido) {
    this.imagen_conseguido = imagen_conseguido;
  }

  public boolean isSecreto() {
    return secreto;
  }

  public void setSecreto(boolean secreto) {
    this.secreto = secreto;
  }

  public void setExperiencia(int experiencia) {
    this.experiencia = experiencia;
  }

}
