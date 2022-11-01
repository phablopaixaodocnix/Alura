import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaRemocao {

		public static void main(String[] args) throws SQLException {
			ConnectionFactory conectionFactory = new ConnectionFactory();
			Connection connection = conectionFactory.recuperarConexao();
			PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
			stm.setInt(1, 2);
			stm.execute();
			Integer linhasModificadas = stm.getUpdateCount();
			System.out.println(linhasModificadas);
			ResultSet rst = stm.getResultSet();
		}
}
