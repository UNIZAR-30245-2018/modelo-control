/**
 *
 */
package modelo.datos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.datos.VO.JuegoVO;
import modelo.datos.VO.SeguidorVO;
import modelo.datos.VO.UsuarioVO;

/**
 * @author Jorge Rambla
 *
 */
public class UsuarioDAO {

	/**
	 * @param seudonimo
	 * @param conexion
	 * @return UsuarioVO vacio si no existe ningun usuario con el seudonimo
	 *         especificado <br>
	 *         UsuarioVO con el seudonimo especificado
	 */
	public UsuarioVO getUsuario(String seudonimo, Connection conexion) {
		UsuarioVO retVal = new UsuarioVO();
		try {
			String query = "SELECT * FROM usuario WHERE seudonimo = ?";

			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, seudonimo);

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				throw new SQLException("Error: No se ha encontrado ningun usuario con el seudonimo de " + seudonimo);
			} else {
				retVal = new UsuarioVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		return retVal;
	}

	public UsuarioVO getUsuarioEmail(String email, Connection conexion) {
		UsuarioVO retVal = new UsuarioVO();
		try {
			String query = "SELECT * FROM usuario WHERE email = ?";

			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				throw new SQLException("Error: No se ha encontrado ningun usuario con el email " + email);
			} else {
				retVal = new UsuarioVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		return retVal;
	}

	public ArrayList<UsuarioVO> getAllUsuario(Connection conexion) {
		ArrayList<UsuarioVO> retVal = new ArrayList<UsuarioVO>();
		try {
			String query = "SELECT * from usuario";

			PreparedStatement ps = conexion.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				throw new SQLException("Error: No hay ningun usuario en la tabla usuario");
			} else {
				do {
					retVal.add(new UsuarioVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(6), rs.getInt(7)));
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return retVal;
	}

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

	/**
	 * @param seudonimo
	 * @param password
	 * @param conexion
	 * @return true si encuentra un usuario con igual nombre y contraseña, o email y
	 *         contraseña
	 */
	public boolean existeUsuarioSeudonimo(String seudonimo, String password, Connection conexion) {
		boolean retVal = false;

		try {
			if (seudonimo != null) {
				String query = "SELECT * FROM usuario WHERE seudonimo = ? AND password = ?";

				PreparedStatement ps = conexion.prepareStatement(query);

				ps.setString(1, seudonimo);
				ps.setString(2, password);

				ResultSet rs = ps.executeQuery();

				if (rs.first()) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return retVal;
	}

	public boolean existeUsuarioEmail(String email, String password, Connection conexion) {
		boolean retVal = false;

		try {
			if (email != null) {
				String query = "SELECT * FROM usuario WHERE email = ? AND password = ?";

				PreparedStatement ps = conexion.prepareStatement(query);

				ps.setString(1, email);
				ps.setString(2, password);

				ResultSet rs = ps.executeQuery();

				if (rs.first()) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return retVal;
	}

	public boolean existeEmail(String email, Connection conexion) {
		boolean retVal = false;

		try {
			if (email != null) {
				String query = "SELECT * FROM usuario WHERE email = ?";

				PreparedStatement ps = conexion.prepareStatement(query);

				ps.setString(1, email);

				ResultSet rs = ps.executeQuery();

				if (rs.first()) {
					retVal = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return retVal;
	}

	public boolean existeSeudonimo(String seudonimo, Connection conexion) {
		boolean retVal = false;

		try {
			if (seudonimo != null) {
				String query = "SELECT * FROM usuario WHERE seudonimo = ?";

				PreparedStatement ps = conexion.prepareStatement(query);

				ps.setString(1, seudonimo);

				ResultSet rs = ps.executeQuery();

				if (rs.first()) {
					retVal = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return retVal;
	}

	public void insertarUsuario(UsuarioVO usuario, Connection conexion) {
		try {
			String query = "INSERT INTO usuario (seudonimo, nombre, email, password) VALUES (?,?,?,?)";

			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, usuario.getSeudonimo());
			ps.setString(2, usuario.getNombre());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getPassword());

			if(ps.executeUpdate() != 1) {
				throw new SQLException("Ha habido problemas a la hora de insertar el usuario");
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	/*Método que saca todos los juegos completados de un usuario */
	public ArrayList<JuegoVO> getEnCursoByUser(String user, Connection conexion) {
		ArrayList<JuegoVO> retVal = new ArrayList<>();
		JuegoDAO juegoDAO = new JuegoDAO();
		try {
			String queryCompletados = "SELECT * FROM juegoEnCurso WHERE usuario = ?";

			PreparedStatement psCompletados = conexion.prepareStatement(queryCompletados);

			psCompletados.setString(1, user);


			ResultSet rs = psCompletados.executeQuery();

			if (!rs.first()) {
				throw new SQLException(
						"Error: No se ha encontrado ningún juego en curso al usuario " + user);
			} else {
				while (rs.next()) {
					int juego = rs.getInt("id_juego");

					retVal.add(juegoDAO.getJuego(juego,conexion));
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		return retVal;

	}

	public ArrayList<JuegoVO> getCompletosByUser(String user, Connection conexion) {
		ArrayList<JuegoVO> retVal = new ArrayList<>();
		JuegoDAO juegoDAO = new JuegoDAO();
		try {
			String queryCompletados = "SELECT * FROM juegoCompletado WHERE usuario = ?";

			PreparedStatement psCompletados = conexion.prepareStatement(queryCompletados);

			psCompletados.setString(1, user);


			ResultSet rs = psCompletados.executeQuery();

			if (!rs.first()) {
				throw new SQLException(
						"Error: No se ha encontrado ningún juego completado al usuario " + user);
			} else {
				while (rs.next()) {

					int juego = rs.getInt("id_juego");

					retVal.add(juegoDAO.getJuego(juego,conexion));
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		return retVal;

	}

	public ArrayList<JuegoVO> getPendientesByUser(String user, Connection conexion) {
		ArrayList<JuegoVO> retVal = new ArrayList<>();
		JuegoDAO juegoDAO = new JuegoDAO();
		try {
			String queryCompletados = "SELECT * FROM juegoPendiente WHERE usuario = ?";

			PreparedStatement psCompletados = conexion.prepareStatement(queryCompletados);

			psCompletados.setString(1, user);


			ResultSet rs = psCompletados.executeQuery();

			if (!rs.first()) {
				throw new SQLException(
						"Error: No se ha encontrado ningún juego pendiente al usuario " + user);
			} else {
				while (rs.next()) {
					int juego = rs.getInt("id_juego");

					retVal.add(juegoDAO.getJuego(juego,conexion));
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		return retVal;

	}

	public void insertarJuegoEnCurso(UsuarioVO usuario, String id,Connection conexion) {
		try {
			String query = "INSERT INTO juegoEnCurso (usuario,id_juego) VALUES (?,?)";

			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, usuario.getSeudonimo());
			ps.setString(2, id);

			if(ps.executeUpdate() != 1) {
				throw new SQLException("Ha habido problemas a la hora de insertar el usuario");
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	public void insertarJuegoPendiente(UsuarioVO usuario, String id,Connection conexion) {
		try {
			String query = "INSERT INTO juegoPendiente (usuario,id_juego) VALUES (?,?)";

			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, usuario.getSeudonimo());
			ps.setString(2, id);

			if(ps.executeUpdate() != 1) {
				throw new SQLException("Ha habido problemas a la hora de insertar el usuario");
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	public void insertarJuegoCompletado(UsuarioVO usuario, String id,Connection conexion) {
		try {
			String query = "INSERT INTO juegoCompletado (usuario,id_juego) VALUES (?,?)";

			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, usuario.getSeudonimo());
			ps.setString(2, id);

			if(ps.executeUpdate() != 1) {
				throw new SQLException("Ha habido problemas a la hora de insertar el usuario");
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	public boolean sonSeguidores(UsuarioVO usuario, UsuarioVO sigue,Connection conexion) {
		boolean res = false;
		try {
			String query = "SELECT * FROM  seguidor WHERE usuario = ? AND usuario_seguido = ?";

			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, usuario.getSeudonimo());
			ps.setString(2, sigue.getSeudonimo());

			ResultSet rs = ps.executeQuery();

			if (rs.first()) {
				res = true;
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return res;
	}

	public ArrayList<SeguidorVO> getSeguidos(String usuario,Connection conexion) {
		ArrayList<SeguidorVO> retVal = new ArrayList<>();
		try {
			String query = "SELECT * FROM seguidor WHERE usuario = ?";

			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, usuario);

			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				do{
					String user = rs.getString("usuario");
					String userSeguido = rs.getString("usuario_seguido");
					LocalDate fecha = rs.getDate("fecha").toLocalDate();
					retVal.add(new SeguidorVO(user,userSeguido,fecha));}
				while (rs.next());
			}
			else{
				System.out.println("No se ha encontrado ningun seguidoo");
			}
	} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
}
