import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory(); //o objeto factory possui um método que retorna a conexão com o banco de dados
		Connection connection = factory.recuperarConexao(); //o objeto connection é a conexão com o banco de dados
		
		PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO(NOME,DESCRICAO) VALUES ('celular','lg k11+')",Statement.RETURN_GENERATED_KEYS); // este é o objeto relativo ao statement do banco de dados
		//boolean retornoMetodoExecute = stm.execute("INSERT INTO PRODUTO(NOME,DESCRICAO) VALUES ('celular','lg k11+')");//o método execute retorna true quando o resultado do sql é uma lista, caso contrario retorna false
		stm.execute();//o método execute execulta o comando sql
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.err.println(id);
		}
		
	}

}
