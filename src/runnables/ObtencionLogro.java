/**
 * 
 */
package runnables;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import modelo.datos.BD.GestorDeConexionesBD;
import modelo.datos.DAO.LogroConseguidoDAO;
import modelo.datos.DAO.SeguidorDAO;
import modelo.datos.DAO.VotosPublicacionDAO;

/**
 * @author Jorge Rambla
 * @version 0.5.0
 *
 */
public class ObtencionLogro {
  private static final String[] LISTA_LOGROS = {"gr_escal", "el_fav"};


  public static void mostrarAyuda() {
    System.out.println("--help Te muestra la lista de comandos.");
    System.out.println("-c Comprueba todos los logros");
    System.out.println(
        "-id [id_logro] Ejecuta la obtencion del logro cuya id sea [id_logro]\n\tSolo para los logros obtenidos temporalmente");
    System.out.println("--list Muestra la lista de logros");
  }

  public static void mostrarListaLogros() {
    System.out.println("Lista de los logros obtenidos temporalmente:");
    for (String logro : LISTA_LOGROS) {
      System.out.println("\t- " + logro);
    }
  }

  public static void obtenerGrEscal() throws SQLException {
    Connection conexion = GestorDeConexionesBD.getConnection();
    String afortunado = new SeguidorDAO()
        .getMasSeguidoMes(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH) + 1, conexion);
    System.out.println("El afortunado es: " + afortunado);
    new LogroConseguidoDAO().darLogro(afortunado, LISTA_LOGROS[0], conexion);
  }

  public static void obtenerElFav() throws SQLException {
    Connection conexion = GestorDeConexionesBD.getConnection();
    String afortunado = new VotosPublicacionDAO().getMasVotadoMes(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH) + 1, conexion);
    System.out.println("El afortunado es: " + afortunado);
    new LogroConseguidoDAO().darLogro(afortunado, LISTA_LOGROS[1], conexion);
  }

  public static void main(String[] args) throws SQLException {
    boolean completo = false;
    String id_logro = "";
    boolean listo = false;
    boolean ayuda = false;

    if (args.length == 0) {
      System.out.println("Parámetros insuficientes, escribe --help para obtener ayuda");
    } else {
      for (int n = 0; n < args.length; n++) {
        switch (args[n]) {
          case "--help":
            mostrarAyuda();
            break;
          case "-c":
            completo = true;
            listo = true;
            break;
          case "-id":
            id_logro = args[++n];
            listo = true;
            break;
          case "--list":
            mostrarListaLogros();
            ayuda = true;
            break;
        }
      }
    }

    if (listo) {
      if (completo) {
        obtenerGrEscal();
        obtenerElFav();
      } else {
        if (id_logro.equals(LISTA_LOGROS[0])) {
          obtenerGrEscal();
        } else {
          obtenerElFav();
        }
      }
    } else {
      if (!ayuda) {
        System.out.println("Parámetros insuficientes, escribe --help para obtener ayuda");
      }
    }
  }
}
