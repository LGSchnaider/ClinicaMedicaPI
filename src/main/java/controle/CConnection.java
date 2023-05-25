package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CConnection {

	private static Connection conexao;
	private static CConnection instancia;
	private static final String DATABASE = "ClinicaPi";
	private static final String USER = "root";
	private static final String PSW = "aluno";

	private CConnection() {

	}

	public static CConnection getInstancia() {
		if (instancia == null) {
			instancia = new CConnection();
		}
		return instancia;
	}

	public Connection conectar() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE + "?serverTimezone=UTC", USER,
					PSW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexao;
	}

	public boolean fechaConexao() {
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}