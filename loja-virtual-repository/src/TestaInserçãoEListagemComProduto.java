import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import modelo.ProdutoDAO;
import modelo.Produto;

public class TestaInserçãoEListagemComProduto {
	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("Comoda","Comoda Horizontal");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvarProduto(comoda);
			List<Produto> listaDeProdutos = produtoDAO.listar();
		}
	}
}
