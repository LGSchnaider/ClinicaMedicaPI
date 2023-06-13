package controll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CConnection {

	private static Connection conexao;
	private static CConnection instancia;

	private static String DATABASE;
	private static String USER;
	private static String PSW;

	private CConnection() {

	}

	public static void leArquivoBD(String filename) {
		String nomeBanco = null, username = null, password = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			if (reader != null) {
				nomeBanco = reader.readLine();
				username = reader.readLine();
				password = reader.readLine();
			}
			reader.close();

			DATABASE = nomeBanco;
			USER = username;
			PSW = password;

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo: " + e.getMessage());
			return;
		}
	}

	public static CConnection getInstancia() {
		if (instancia == null) {
			instancia = new CConnection();
			leArquivoBD("credentials.txt");
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