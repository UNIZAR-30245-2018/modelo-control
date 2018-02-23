package modelo.datos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jorge Rambla
 *
 */
public class JuegoDAO {
	public String getSeudonimo(String email, Connection conexion) {
		String retVal = "Error";
		try {
			String query = "SELECT seudonimo FROM usuario WHERE email = ?";
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				throw new SQLException("Error: No se ha encontrado ningun usuario con el email de " + email);
			} else {
				retVal = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return retVal;
	}

	public String getNombre(String seudonimo, Connection conexion) {
		String retVal = "Error";
		try {
			String query = "SELECT nombre FROM usuario WHERE seudonimo = ?";
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, seudonimo);

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				throw new SQLException("Error: No se ha encontrado ningun usuario con el seudonimo de " + seudonimo);
			} else {
				retVal = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return retVal;
	}

	public String getEmail(String seudonimo, Connection conexion) {
		String retVal = "Error";
		try {
			String query = "SELECT email FROM usuario WHERE seudonimo = ?";
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, seudonimo);

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				throw new SQLException("Error: No se ha encontrado ningun usuario con el seudonimo de " + seudonimo);
			} else {
				retVal = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return retVal;
	}

	public String getPassword(String seudonimo, Connection conexion) {
		String retVal = "Error";
		try {
			String query = "SELECT password FROM usuario WHERE seudonimo = ?";
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, seudonimo);

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				throw new SQLException("Error: No se ha encontrado ningun usuario con el seudonimo de " + seudonimo);
			} else {
				retVal = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return retVal;
	}

	public String getImagen(String seudonimo, Connection conexion) {
		String retVal = "Error";
		try {
			String query = "SELECT imagen FROM usuario WHERE seudonimo = ?";
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, seudonimo);

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				throw new SQLException("Error: No se ha encontrado ningun usuario con el seudonimo de " + seudonimo);
			} else {
				retVal = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return retVal;
	}

	public int getNivel(String seudonimo, Connection conexion) {
		int retVal = -1;
		try {
			String query = "SELECT nivel FROM usuario WHERE seudonimo = ?";
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, seudonimo);

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				throw new SQLException("Error: No se ha encontrado ningun usuario con el seudonimo de " + seudonimo);
			} else {
				retVal = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return retVal;
	}

	public int getExperiencia(String seudonimo, Connection conexion) {
		int retVal = -1;
		try {
			String query = "SELECT experiencia FROM usuario WHERE seudonimo = ?";
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, seudonimo);

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				throw new SQLException("Error: No se ha encontrado ningun usuario con el seudonimo de " + seudonimo);
			} else {
				retVal = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return retVal;
	}

}
