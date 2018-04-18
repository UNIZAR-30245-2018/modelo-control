package runnables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.datos.BD.GestorDeConexionesBD;
import modelo.datos.DAO.PublicacionDAO;
import modelo.datos.VO.PublicacionVO;

public class GestionReportesLocal {
  public static void muestraAyuda() {
    System.out.println("--help Te muestra la lista de comandos.");
    System.out.println(
        "-g Acceso a la gestión de las publicaciones de 1 en 1 con interfaz textual"
            + "\n\t para gestionarlas individualemente");
    System.out.println("-list Solo muestra las publicaciones");
    System.out.println("-min [MIN] Publicaciones con reports >= MIN");
    System.out.println("-rang [MIN] [MAX] Publicaciones donde MIN <= reports >= MAX");
    System.out.println("--debug Mustra el estado de la ejecucion");
    System.out.println(
        "\n\n Por defecto se ejecutara en modo min, pero hace falta espcificar si es en lista o gestion");
  }
  
  public static void lista(int min, int max, boolean range, boolean debug) throws SQLException{
    Connection conexion = GestorDeConexionesBD.getConnection();

    if(range){
      ArrayList<PublicacionVO> aux = new PublicacionDAO().publicacionesReportsRange(min, max, conexion);
      for (PublicacionVO p : aux){
        System.out.println("ID [" + p.getId_publicacion() + "] - Reports [" + p.getReports() + "]\n\t" + p.getTexto());
      }
    } else {
      ArrayList<PublicacionVO> aux = new PublicacionDAO().publicacionesReports(min, conexion);
      for (PublicacionVO p : aux){
        System.out.println("ID [" + p.getId_publicacion() + "] - Reports [" + p.getReports() + "]\n\t" + p.getTexto());
      }
    }
  }
  
  public static void interfaz(int min, int max, boolean range, boolean debug) throws SQLException, IOException {
    Connection conexion = GestorDeConexionesBD.getConnection();

    if(range && min < max && max != -1){
      ArrayList<PublicacionVO> aux = new PublicacionDAO().publicacionesReportsRange(min, max, conexion);
      for (PublicacionVO p : aux){
        while (true){
          System.out.println("ID [" + p.getId_publicacion() + "] - Reports [" + p.getReports() + "]\n\t" + p.getTexto());
          
          System.out.println("\n1- Eliminar publicación\t2- Eliminar reportes\t3- omitir");
          String n = new BufferedReader(new InputStreamReader(System.in)).readLine();
          
          try {
            int opcion = Integer.parseInt(n);
            
            switch(opcion){
              case 1:
                new PublicacionDAO().eliminarPublicacion(p.getId_publicacion(), conexion);
                break;
              case 2:
                new PublicacionDAO().limpiarReportes(p.getId_publicacion(), conexion);
                break;
              case 3:
                break;
            }
    
          } catch (Exception e) {
            e.printStackTrace(System.err);
          }
          break;
        }
      }
    } else {
      ArrayList<PublicacionVO> aux = new PublicacionDAO().publicacionesReports(min, conexion);
      for (PublicacionVO p : aux){
        while (true){
          System.out.println("ID [" + p.getId_publicacion() + "] - Reports [" + p.getReports() + "]\n\t" + p.getTexto());
          
          System.out.println("\n1- Eliminar publicación\t2- Eliminar reportes\t3- omitir");
          String n = new BufferedReader(new InputStreamReader(System.in)).readLine();
          
          try {
            int opcion = Integer.parseInt(n);
            
            switch(opcion){
              case 1:
                new PublicacionDAO().eliminarPublicacion(p.getId_publicacion(), conexion);
                break;
              case 2:
                new PublicacionDAO().limpiarReportes(p.getId_publicacion(), conexion);
                break;
              case 3:
                break;
            }
    
          } catch (Exception e) {
            e.printStackTrace(System.err);
          }
          break;
        }
      }
    }
    
  }

  public static void main(String[] args) throws SQLException, IOException {
    boolean ready = false;
    boolean ex = true;
    boolean list = false;
    boolean debug = false;
    boolean range = false;
    int min = 0;
    int max = -1;

    if (args.length == 0) {
      System.out.println(
          "Parametros insuficientes escribe el parmetro --help para recibir mas información.");
    } else {
      for (int n = 0; n < args.length; n++) {
        switch (args[n]) {
          case "--help":
            muestraAyuda();
            ex = false;
            break;
          case "-list":
            list = true;
            ready = true;
            break;
          case "-g":
            list = false;
            ready = true;
            break;
          case "--debug":
            debug = true;
            break;
          case "-min":
            if (args.length - (n + 1) > 0) {
              range = false;
              min = Math.abs(Integer.parseInt(args[++n]));
            }
            break;
          case "-rang":
            if (args.length - (n + 2) > 0) {
              range = true;
              min = Math.abs(Integer.parseInt(args[++n]));
              max = Math.abs(Integer.parseInt(args[++n]));
            }
            break;
        }
      }

      // Comienzo de la ejecución
     
      if (ready & ex) {
        if(list) {
          lista(min, max, range, debug);
        } else {
          interfaz(min, max, range, debug);
        }
      } else if (!ex) {
        //Empty
      } else {
        System.out.println(
            "Parametros insuficientes escribe el parmetro --help para recibir mas información.");
      }
    }
  }

}
