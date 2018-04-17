package modelo.datos.VO;

/**
 * @author Jorge Rambla
 *
 */
public class ListaJuegosVO {
  private String usuario;
  private int juego;
  private int tipo;

  /**
   * @param juego
   * @param usuario
   * 
   *        Construye el objeto ListaJuegosVO con TODOS los parametros
   */
  public ListaJuegosVO(int juego, String usuario, int tipo) {
    super();
    this.juego = juego;
    this.usuario = usuario;
    this.tipo = tipo;
  }

  /**
   * Constructor de objeto vacio
   */
  public ListaJuegosVO(){};
  
   @Override
  public String toString() {
    return "ListaJuegosVO {\n\tusuario: " + usuario + "\n\tjuego: " + juego + "\n\ttipo: "
        + tipo + "\n}";
  }
   
   public String toSQLInsert(){
     String tabla = "";
     switch(tipo){
       case 0:
         tabla = "juegoPendiente";
         break;
       case 1:
         tabla = "juegoEnCurso";
         break;
       case 2:
         tabla = "juegoCompletado";
         break;
     }
     return "INSERT INTO " + tabla + "(usuario, id_juego) VALUES (\"" + usuario + "\", " + juego + ");"; 
   }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + juego;
    result = prime * result + tipo;
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
    if (!(obj instanceof ListaJuegosVO)) {
      return false;
    }
    ListaJuegosVO other = (ListaJuegosVO) obj;
    if (juego != other.juego) {
      return false;
    }
    if (tipo != other.tipo) {
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

  public int getJuego() {
    return juego;
  }

  public void setJuego(int juego) {
    this.juego = juego;
  }

  public int getTipo() {
    return tipo;
  }

  public void setTipo(int tipo) {
    this.tipo = tipo;
  }


}
