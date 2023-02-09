package controle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conection {
	private static Connection conection;
	private static Conection instancia;
	private static final String DATABASE = "hr";
	private static final String USER = "aluno";
	private static final String PSW = "aluno";
	
	private Conection() {}
	
	public Conection getInstancia() {
		if (instancia == null) {
			instancia = new Conection();
		}
		return instancia;
	}
	
	public static Connection link() { //cria conecção com a variavel de memória
		try {
			conection = DriverManager.getConnection(
					"jbbc:mysql://localhost/"
					+ DATABASE + "?serverTimezone=UTC",
					USER, PSW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conection;
	}
	
	public static boolean closeConection() {
		try {
			conection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
}
