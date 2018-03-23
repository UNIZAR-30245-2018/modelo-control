package modelo.datos.VO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jorge Rambla
 *
 */
public class UsuarioVO {
  private String seudonimo;
  private String nombre;
  private String email;
  private String password;
  private String imagen;
  private int experiencia;
  private int nivel;

  private List<UsuarioVO> seguidos;

  private List<JuegoVO> juegosPendientes;
  private List<JuegoVO> juegosEnCurso;
  private List<JuegoVO> juegosCompletados;

  private List<LogroVO> logrosConseguidos;

  private List<PublicacionVO> publicaciones;

  /**
   * @param seudonimo
   * @param nombre
   * @param email
   * @param experiencia
   * @param nivel
   * 
   *        Construye un objeto usuario con TODOS los valores
   */
  public UsuarioVO(String seudonimo, String nombre, String email, String password,
      String imagen, int experiencia, int nivel) {
    super();
    this.seudonimo = seudonimo;
    this.nombre = nombre;
    this.email = email;
    this.imagen = (imagen == null) ? "default" : imagen;
    this.password = password;
    this.experiencia = experiencia;
    this.nivel = nivel;

    seguidos = new ArrayList<UsuarioVO>();

    juegosPendientes = new ArrayList<JuegoVO>();
    juegosEnCurso = new ArrayList<JuegoVO>();
    juegosCompletados = new ArrayList<JuegoVO>();

    logrosConseguidos = new ArrayList<LogroVO>();

    publicaciones = new ArrayList<PublicacionVO>();
  }

  /**
   * @param seudonimo
   * @param nombre
   * @param email
   * @param imagen
   * 
   *        Construye un objeto usuario con los valores de nivel y experiencia por defecto
   */
  public UsuarioVO(String seudonimo, String nombre, String email, String password,
      String imagen) {
    this(seudonimo, nombre, email, imagen, password, 0, 0);
  }

  /**
   * @param seudonimo
   * @param nombre
   * @param email
   * 
   *        Construye un objeto usuario con los valores de imagen, nivel y experiencia por defecto
   */
  public UsuarioVO(String seudonimo, String nombre, String email, String password) {
    this(seudonimo, nombre, email, password, null, 0, 0);
  }


  /**
   * Constructor de objeto vacio
   */
  public UsuarioVO() {};


  @Override
  public String toString() {
    return "UsuarioVO {\n\tseudonimo: " + seudonimo + "\n\tnombre: " + nombre
        + "\n\temail: " + email + "\n\tpassword: " + password + "\n\timagen: " + imagen
        + "\n\texperiencia: " + experiencia + "\n\tnivel: " + nivel + "\n\tseguidos: "
        + seguidos.size() + "\n\tjuegosPendientes: " + juegosPendientes.size()
        + "\n\tjuegosEnCurso: " + juegosEnCurso.size() + "\n\tjuegosCompletados: "
        + juegosCompletados.size() + "\n\tlogrosConseguidos: " + logrosConseguidos.size()
        + "\n\tpublicaciones: " + publicaciones.size() + "\n}";
  }

  public String toSQLInsert() {
    return "INSERT INTO usuario (seudonimo, nombre, email, password, imagen, experiencia, nivel) VALUES (\""
        + seudonimo + "\", \"" + nombre + "\", \"" + email + "\", \"" + password
        + "\", \"" + imagen + "\", " + experiencia + ", " + nivel + ");";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + experiencia;
    result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
    result =
        prime * result + ((juegosCompletados == null) ? 0 : juegosCompletados.hashCode());
    result = prime * result + ((juegosEnCurso == null) ? 0 : juegosEnCurso.hashCode());
    result =
        prime * result + ((juegosPendientes == null) ? 0 : juegosPendientes.hashCode());
    result =
        prime * result + ((logrosConseguidos == null) ? 0 : logrosConseguidos.hashCode());
    result = prime * result + nivel;
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    result = prime * result + ((seudonimo == null) ? 0 : seudonimo.hashCode());
    result = prime * result + ((publicaciones == null) ? 0 : publicaciones.hashCode());
    result = prime * result + ((seguidos == null) ? 0 : seguidos.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
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
    if (!(obj instanceof UsuarioVO)) {
      return false;
    }
    UsuarioVO other = (UsuarioVO) obj;
    if (email == null) {
      if (other.email != null) {
        return false;
      }
    } else if (!email.equals(other.email)) {
      return false;
    }
    if (experiencia != other.experiencia) {
      return false;
    }
    if (imagen == null) {
      if (other.imagen != null) {
        return false;
      }
    } else if (!imagen.equals(other.imagen)) {
      return false;
    }
    if (password == null) {
      if (other.password != null) {
        return false;
      }
    } else if (!password.equals(other.password)) {
      return false;
    }
    if (juegosCompletados == null) {
      if (other.juegosCompletados != null) {
        return false;
      }
    } else if (!juegosCompletados.equals(other.juegosCompletados)) {
      return false;
    }
    if (juegosEnCurso == null) {
      if (other.juegosEnCurso != null) {
        return false;
      }
    } else if (!juegosEnCurso.equals(other.juegosEnCurso)) {
      return false;
    }
    if (juegosPendientes == null) {
      if (other.juegosPendientes != null) {
        return false;
      }
    } else if (!juegosPendientes.equals(other.juegosPendientes)) {
      return false;
    }
    if (logrosConseguidos == null) {
      if (other.logrosConseguidos != null) {
        return false;
      }
    } else if (!logrosConseguidos.equals(other.logrosConseguidos)) {
      return false;
    }
    if (nivel != other.nivel) {
      return false;
    }
    if (nombre == null) {
      if (other.nombre != null) {
        return false;
      }
    } else if (!nombre.equals(other.nombre)) {
      return false;
    }
    if (seudonimo == null) {
      if (other.seudonimo != null) {
        return false;
      }
    } else if (!seudonimo.equals(other.seudonimo)) {
      return false;
    }
    if (publicaciones == null) {
      if (other.publicaciones != null) {
        return false;
      }
    } else if (!publicaciones.equals(other.publicaciones)) {
      return false;
    }
    if (seguidos == null) {
      if (other.seguidos != null) {
        return false;
      }
    } else if (!seguidos.equals(other.seguidos)) {
      return false;
    }
    return true;
  }

  public String getSeudonimo() {
    return seudonimo;
  }

  public void setSeudonimo(String seudonimo) {
    this.seudonimo = seudonimo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  public int getExperiencia() {
    return experiencia;
  }

  public void setExperiencia(int experiencia) {
    this.experiencia = experiencia;
  }

  public int getNivel() {
    return nivel;
  }

  public void setNivel(int nivel) {
    this.nivel = nivel;
  }

  public List<UsuarioVO> getSeguidos() {
    return seguidos;
  }

  public void setSeguidos(List<UsuarioVO> seguidos) {
    this.seguidos = seguidos;
  }

  public List<JuegoVO> getJuegosPendientes() {
    return juegosPendientes;
  }

  public void setJuegosPendientes(List<JuegoVO> juegosPendientes) {
    this.juegosPendientes = juegosPendientes;
  }

  public List<JuegoVO> getJuegosEnCurso() {
    return juegosEnCurso;
  }

  public void setJuegosEnCurso(List<JuegoVO> juegosEnCurso) {
    this.juegosEnCurso = juegosEnCurso;
  }

  public List<JuegoVO> getJuegosCompletados() {
    return juegosCompletados;
  }

  public void setJuegosCompletados(List<JuegoVO> juegosCompletados) {
    this.juegosCompletados = juegosCompletados;
  }

  public List<LogroVO> getLogrosConseguidos() {
    return logrosConseguidos;
  }

  public void setLogrosConseguidos(List<LogroVO> logrosConseguidos) {
    this.logrosConseguidos = logrosConseguidos;
  }

  public List<PublicacionVO> getPublicaciones() {
    return publicaciones;
  }

  public void setPublicaciones(List<PublicacionVO> publicaciones) {
    this.publicaciones = publicaciones;
  }

  public int getPorcentajeNivel() {
    int divisor = 100 * (int) (nivel / 10 + 1);
    return (int) (((float) this.experiencia / (float) divisor) * 100);
  }
}
