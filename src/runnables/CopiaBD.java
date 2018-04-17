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
import modelo.datos.DAO.ListaJuegosDAO;
import modelo.datos.DAO.LogroConseguidoDAO;
import modelo.datos.DAO.PublicacionDAO;
import modelo.datos.DAO.UsuarioDAO;
import modelo.datos.VO.ListaJuegosVO;
import modelo.datos.VO.LogroConseguidoVO;
import modelo.datos.VO.PublicacionVO;
import modelo.datos.VO.UsuarioVO;

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
    System.out.println("-p Hace una copia de seguridad de la BD ligera, es decir lo esencial. Esta opción es por defecto.");
    System.out.println("-c Hace una copia de seguridad completa, este parametro tiene mas peso que -p");
  }
  
  public static void copiaSQL(String ruta, boolean completa) throws SQLException, IOException{
    Connection conexion = GestorDeConexionesBD.getConnection();
    FileWriter fw = new FileWriter(new File(ruta));
    ArrayList<UsuarioVO> aux = new UsuarioDAO().getAllUsuario(conexion);
    for(UsuarioVO u : aux){
      //System.out.println(u.toSQLInsert());
      fw.write(u.toSQLInsert() + "\n");
    }
    
    ArrayList<ListaJuegosVO> aux2 = new ListaJuegosDAO().getAllLista(conexion);
    for(ListaJuegosVO lj : aux2){
      //System.out.println(lj.toSQLInsert());
      fw.write(lj.toSQLInsert() + "\n");
    }

    ArrayList<LogroConseguidoVO> aux3 = new LogroConseguidoDAO().getAll(conexion);
    for (LogroConseguidoVO lc : aux3){
      //System.out.println(lc.toSQLInsert());
      fw.write(lc.toSQLInsert() + "\n");
    }
    
    ArrayList<PublicacionVO> aux4 = new PublicacionDAO().getAll(conexion);
    for (PublicacionVO p : aux4){
      //System.out.println(p.toSQLInsert());
      fw.write(p.toSQLInsert() + "\n");
    }
    
    // Lista seguidor
    // Lista votosPublicacion
    if (completa){
      // Lista juegos
      // Lista logros
    }
    fw.close();
  }
  
  public static void copiaJSON(String ruta, boolean completa) throws SQLException, IOException{
    Connection conexion = GestorDeConexionesBD.getConnection();
    FileWriter fw = new FileWriter(new File(ruta));
    ArrayList<UsuarioVO> aux = new UsuarioDAO().getAllUsuario(conexion);
    for(UsuarioVO u : aux){
      //System.out.println(u);
      fw.write(u + "\n");
    }
    
    ArrayList<ListaJuegosVO> aux2 = new ListaJuegosDAO().getAllLista(conexion);
    for(ListaJuegosVO lj : aux2){
      //System.out.println(lj);
      fw.write(lj + "\n");
    }
    
    ArrayList<LogroConseguidoVO> aux3 = new LogroConseguidoDAO().getAll(conexion);
    for (LogroConseguidoVO lc : aux3){
      //System.out.println(lc);
      fw.write(lc + "\n");
    }
    
    
    ArrayList<PublicacionVO> aux4 = new PublicacionDAO().getAll(conexion);
    for (PublicacionVO p : aux4){
      //System.out.println(p);
      fw.write(p + "\n");
    }
    
    
    // Lista seguidor
    // Lista votosPublicacion
    if (completa){
      // Lista juegos
      // Lista logros
    }
    fw.close();
  }

  public static void main(String[] args) throws SQLException, IOException {
    boolean ready = false;
    boolean completa = false;
    boolean ex = true;
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
            if (args[++p].toLowerCase().equals("json")){
              formato = "json";
            }
            break;
          case "-c":
            completa = true;
            break;
        }
      }
      
      String ruta = dir + "/" + nombre + "." + formato;
     if (ready && ex){
       if (formato.equals("sql")){
         copiaSQL(ruta, completa);
       } else {
         copiaJSON(ruta, completa);
       }
     } else if(!ex){
     } else {
       System.out.println("Argumentos insfucientes falta especificar -dir, escribe -help para recibir ayuda");
     }
      
    }

  }

}
