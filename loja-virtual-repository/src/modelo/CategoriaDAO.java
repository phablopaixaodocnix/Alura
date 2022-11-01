package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Categoria> listar() throws SQLException {
		String sql = "SELECT * FROM CATEGORIA";
		List<Categoria> categorias = new ArrayList<>();

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
					categorias.add(categoria);
					categorias.stream().forEach(ct -> {
						System.out.println(ct.getNome());
						try {
							for (Produto produto : new ProdutoDAO(connection).buscar(ct)) {
								System.out.println(ct.getNome() + " - " + produto.getNome());
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					});
				}
			}
		}

		return categorias;
	}

	public List<Categoria> listarComProdutos() throws SQLException {
		String sql = "SELECT C.ID, C.NOME, P.ID, P.DESCRICAO FROM CATEGORIA C INNER JOIN"
				+ "PRODUTO P ON C.ID = P.CATEGORIA_ID";
		List<Categoria> categorias = new ArrayList<>();

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			Categoria ultima = null;
			pstm.execute();
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					if (ultima == null || !ultima.getNome().equals(rst.getString(2))) {
						Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
						ultima = categoria;
						categorias.add(categoria);
					}
					Produto produto = new Produto(rst.getInt(3),rst.getString(4),rst.getString(5));
					ultima.adicionar(produto);
				}
			}
		}

		return categorias;
	}
}
