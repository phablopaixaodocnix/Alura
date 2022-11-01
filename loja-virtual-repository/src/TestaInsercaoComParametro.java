import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory(); // o objeto factory possui um método que retorna a conexão
																// com o banco de dados
		try (Connection connection = factory.recuperarConexao();) { // o objeto connection é a conexão com o banco de
																	// dados
			connection.setAutoCommit(false);

			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome,descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);) { // maneira
																												// segura
																												// de
																												// preparar
																												// um
																												// statement
																												// para
																												// evitar
																												// sql
																												// injections
				// com este try with resources, o médodo close é executado automaticamente
				// com este try catch, ou adiciona todo mundo ou não adiciona ninguem. o commit
				// para o banco de dados é feito só no final
				adicionarVariavel("Tenis", "Nike AirForce", stm);
				adicionarVariavel("Cama", "KingSize", stm);
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Rollback execultado");
				connection.rollback();
			}
		}

	}

	private static void adicionarVariavel(String nome, String descrição, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descrição);
		stm.execute();
		try (ResultSet rst = stm.getGeneratedKeys();) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println(id);
			}
		}

	}

}
