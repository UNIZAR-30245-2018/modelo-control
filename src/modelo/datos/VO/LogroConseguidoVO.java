package modelo.datos.VO;

/**
 * @author Jorge Rambla
 *
 */
public class LogroConseguidoVO {
  private String usuario;
  private String logro;

  /**
   * @param usuario
   * @param logro
   * 
   *        Construye el objeto LogroConseguido con TODOS los parametros
   */
  public LogroConseguidoVO(String usuario, String logro) {
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
  
  public String toSQLInsert() {
    return "INSERT INTO logroConseguido (usuario, id_logro) VALUES (\"" + usuario + "\", \"" + logro + "\");";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((logro == null) ? 0 : logro.hashCode());
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
    if (logro == null) {
      if (other.logro != null) {
        return false;
      }
    } else if (!logro.equals(other.logro)) {
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

  public String getLogro() {
    return logro;
  }

  public void setLogro(String logro) {
    this.logro = logro;
  }


}
