package modelo.datos.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorDeConexionesBD {
	
	private final static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	private final static String DRIVER_URL = "jdbc:mysql://localhost:3306/fsistInBD";
	private final static String USER = "usuarioSIBD";
	private final static String PASSWORD = "claveSIBD";
		
	static {			
		try {
			Class.forName(DRIVER_CLASS_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace(System.err);
		}	
	}

	private GestorDeConexionesBD(){
	}
	
	public final static Connection getConnection()
		throws SQLException {
			return DriverManager.getConnection(DRIVER_URL, USER, PASSWORD);
	}
}
