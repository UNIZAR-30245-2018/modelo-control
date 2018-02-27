package modelo.datos.VO;

/**
 * @author Jorge Rambla
 *
 */
public class LogroConseguidoVO {
  private String usuario;
  private int logro;

  /**
   * @param usuario
   * @param logro
   * 
   *        Construye el objeto LogroConseguido con TODOS los parametros
   */
  public LogroConseguidoVO(String usuario, int logro) {
    super();
    this.usuario = usuario;
    this.logro = logro;
  }
  
  /**
   * Constructor de objeto vacio
   */
  public LogroConseguidoVO() {}

  @Override
  public String toString() {
    return "LogroConseguidoVO {\n\tusuario: " + usuario + "\n\tlogro: " + logro + "\n}";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + logro;
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
    if (!(obj instanceof LogroConseguidoVO)) {
      return false;
    }
    LogroConseguidoVO other = (LogroConseguidoVO) obj;
    if (logro != other.logro) {
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

  public int getLogro() {
    return logro;
  }

  public void setLogro(int logro) {
    this.logro = logro;
  }


}
