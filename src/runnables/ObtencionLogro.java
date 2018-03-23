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

  public static void obtenerGrEscal(boolean debug) {
    try {
      Connection conexion = GestorDeConexionesBD.getConnection();

      String afortunado =
          new SeguidorDAO().getMasSeguidoMes(Calendar.getInstance().get(Calendar.YEAR),
              Calendar.getInstance().get(Calendar.MONTH) + 1, conexion);
      boolean out =
          new LogroConseguidoDAO().darLogro(afortunado, LISTA_LOGROS[0], conexion);
      if (debug) {
        System.out.println(
            "El afortunado es: " + afortunado + "\nLa ejecución ha resultado: " + out);
      }
    } catch (SQLException e) {
      e.printStackTrace(System.err);
    }
  }

  public static void obtenerElFav(boolean debug){
    try {
      Connection conexion = GestorDeConexionesBD.getConnection();
      String afortunado = new VotosPublicacionDAO().getMasVotadoMes(
          Calendar.getInstance().get(Calendar.YEAR),
          Calendar.getInstance().get(Calendar.MONTH) + 1, conexion);
      boolean out =
          new LogroConseguidoDAO().darLogro(afortunado, LISTA_LOGROS[1], conexion);
      if (debug) {
        System.out.println(
            "El afortunado es: " + afortunado + "\nLa ejecución ha resultado: " + out);
      }
    } catch (SQLException e) {
      e.printStackTrace(System.err);
    }


  }

  public static void main(String[] args){
    boolean completo = false;
    String id_logro = "";
    boolean listo = false;
    boolean ayuda = false;
    boolean debug = false;

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
            if (args.length - (n + 1) > 0) {
              id_logro = args[++n];
              listo = true;
            }
            break;
          case "--list":
            mostrarListaLogros();
            ayuda = true;
            break;
          case "--debug":
            debug = true;
            break;
        }
      }
    }

    if (listo) {
      if (completo) {
        obtenerGrEscal(debug);
        obtenerElFav(debug);
      } else {
        if (id_logro.equals(LISTA_LOGROS[0])) {
          obtenerGrEscal(debug);
        } else if (id_logro.equals(LISTA_LOGROS[1])) {
          obtenerElFav(debug);
        } else {
          System.out.println(
              "Logro desconocido, escribe --list para consultar la lista de logros");
        }
      }
    } else {
      if (!ayuda) {
        System.out.println("Parámetros insuficientes, escribe --help para obtener ayuda");
      }
    }
  }
}
