/**
 * 
 */
package runnables;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.datos.BD.GestorDeConexionesBD;
import modelo.datos.DAO.JuegoDAO;
import modelo.datos.DAO.ListaJuegosDAO;
import modelo.datos.DAO.LogroConseguidoDAO;
import modelo.datos.DAO.LogroDAO;
import modelo.datos.DAO.PublicacionDAO;
import modelo.datos.DAO.SeguidorDAO;
import modelo.datos.DAO.UsuarioDAO;
import modelo.datos.DAO.VotosPublicacionDAO;
import modelo.datos.VO.JuegoVO;
import modelo.datos.VO.ListaJuegosVO;
import modelo.datos.VO.LogroConseguidoVO;
import modelo.datos.VO.LogroVO;
import modelo.datos.VO.PublicacionVO;
import modelo.datos.VO.SeguidorVO;
import modelo.datos.VO.UsuarioVO;
import modelo.datos.VO.VotosPublicacionVO;

/**
 * @author usuario
 *
 */
public class CopiaBD {
  public static void muestraAyuda() {
    System.out.println("-help Te muestra la lista de comandos.");
    System.out.println(
        "-dir [directorio] [nombre del fichero] Te permite establecer el directorio donde se va a guardar el fichero.");
    System.out.println(
        "-form [SQL/JSON] Te permite elegir si quieres el formato de salida en JSON o SQL,\n\t por defecto es SQL.");
    System.out.println(
        "-p Hace una copia de seguridad de la BD ligera, es decir lo esencial. Esta opción es por defecto.");
    System.out.println(
        "-c Hace una copia de seguridad completa, este parametro tiene mas peso que -p");
    System.out
        .println("--debug Activa la salida por consola de cada una de las acciones");
  }

  public static void copiaSQL(String ruta, boolean completa, boolean debug)
      throws SQLException, IOException {
    Connection conexion = GestorDeConexionesBD.getConnection();
    FileWriter fw = new FileWriter(new File(ruta));
    ArrayList<UsuarioVO> aux = new UsuarioDAO().getAllUsuario(conexion);
    for (UsuarioVO u : aux) {
      if (debug) {
        System.out.println(u.toSQLInsert());
      }
      fw.write(u.toSQLInsert() + "\n");
    }

    ArrayList<ListaJuegosVO> aux2 = new ListaJuegosDAO().getAllLista(conexion);
    for (ListaJuegosVO lj : aux2) {
      if (debug) {
        System.out.println(lj.toSQLInsert());
      }
      fw.write(lj.toSQLInsert() + "\n");
    }

    ArrayList<LogroConseguidoVO> aux3 = new LogroConseguidoDAO().getAll(conexion);
    for (LogroConseguidoVO lc : aux3) {
      if (debug) {
        System.out.println(lc.toSQLInsert());
      }
      fw.write(lc.toSQLInsert() + "\n");
    }

    ArrayList<PublicacionVO> aux4 = new PublicacionDAO().getAll(conexion);
    for (PublicacionVO p : aux4) {
      if (debug) {
        System.out.println(p.toSQLInsert());
      }
      fw.write(p.toSQLInsert() + "\n");
    }

    ArrayList<SeguidorVO> aux5 = new SeguidorDAO().getAll(conexion);
    for (SeguidorVO s : aux5) {
      if (debug) {
        System.out.println(s.toSQLInsert());
      }
      fw.write(s.toSQLInsert() + "\n");
    }

    ArrayList<VotosPublicacionVO> aux6 = new VotosPublicacionDAO().getAll(conexion);
    for (VotosPublicacionVO vp : aux6) {
      if (debug) {
        System.out.println(vp.toSQLInsert());
      }
      fw.write(vp.toSQLInsert() + "\n");
    }

    if (completa) {
      ArrayList<JuegoVO> aux7 = new JuegoDAO().getAll(conexion);
      for (JuegoVO j : aux7) {
        if (debug) {
          System.out.println(j.toSQLInsert());
        }
        fw.write(j.toSQLInsert() + "\n");
      }

      ArrayList<LogroVO> aux8 = new LogroDAO().getAll(conexion);
      for (LogroVO l : aux8) {
        if (debug) {
          System.out.println(l.toSQLInsert());
        }
        fw.write(l.toSQLInsert() + "\n");
      }

    }
    fw.close();
  }

  public static void copiaJSON(String ruta, boolean completa, boolean debug)
      throws SQLException, IOException {
    Connection conexion = GestorDeConexionesBD.getConnection();
    FileWriter fw = new FileWriter(new File(ruta));
    ArrayList<UsuarioVO> aux = new UsuarioDAO().getAllUsuario(conexion);
    for (UsuarioVO u : aux) {
      if (debug) {
        System.out.println(u);
      }
      fw.write(u + "\n");
    }

    ArrayList<ListaJuegosVO> aux2 = new ListaJuegosDAO().getAllLista(conexion);
    for (ListaJuegosVO lj : aux2) {
      if (debug) {
        System.out.println(lj);
      }
      fw.write(lj + "\n");
    }

    ArrayList<LogroConseguidoVO> aux3 = new LogroConseguidoDAO().getAll(conexion);
    for (LogroConseguidoVO lc : aux3) {
      if (debug) {
        System.out.println(lc);
      }
      fw.write(lc + "\n");
    }

    ArrayList<PublicacionVO> aux4 = new PublicacionDAO().getAll(conexion);
    for (PublicacionVO p : aux4) {
      if (debug) {
        System.out.println(p);
      }
      fw.write(p + "\n");
    }

    ArrayList<SeguidorVO> aux5 = new SeguidorDAO().getAll(conexion);
    for (SeguidorVO s : aux5) {
      if (debug) {
        System.out.println(s);
      }
      fw.write(s + "\n");
    }

    ArrayList<VotosPublicacionVO> aux6 = new VotosPublicacionDAO().getAll(conexion);
    for (VotosPublicacionVO vp : aux6) {
      if (debug) {
        System.out.println(vp);
      }
      fw.write(vp + "\n");
    }

    if (completa) {
      ArrayList<JuegoVO> aux7 = new JuegoDAO().getAll(conexion);
      for (JuegoVO j : aux7) {
        if (debug) {
          System.out.println(j);
        }
        fw.write(j + "\n");
      }

      ArrayList<LogroVO> aux8 = new LogroDAO().getAll(conexion);
      for (LogroVO l : aux8) {
        if (debug) {
          System.out.println(l);
        }
        fw.write(l + "\n");
      }
    }
    fw.close();
  }

  public static void main(String[] args) throws SQLException, IOException {
    boolean ready = false;
    boolean completa = false;
    boolean ex = true;
    boolean debug = false;
    String dir = "";
    String nombre = "output";
    String formato = "sql";
    if (args.length == 0) {
      System.out.println(
          "Parametros insuficientes escribe el parmetro -help para recibir mas información.");
    } else {
      for (int p = 0; p < args.length; p++) {
        switch (args[p]) {
          case "-help":
            muestraAyuda();
            ex = false;
            break;
          case "-dir":
            dir = args[++p];
            nombre = args[++p];
            ready = true;
            break;
          case "-form":
            if (args[++p].toLowerCase().equals("json")) {
              formato = "json";
            }
            break;
          case "-c":
            completa = true;
            break;
          case "--debug":
            debug = true;
            break;
        }
      }

      String ruta = dir + "/" + nombre + "." + formato;
      System.out.println(ruta);
      if (ready && ex) {
        if (formato.equals("sql")) {
          copiaSQL(ruta, completa, debug);
        } else {
          copiaJSON(ruta, completa, debug);
        }
      } else if (!ex) {
      } else {
        System.out.println(
            "Argumentos insfucientes falta especificar -dir, escribe -help para recibir ayuda");
      }

    }

  }

}
