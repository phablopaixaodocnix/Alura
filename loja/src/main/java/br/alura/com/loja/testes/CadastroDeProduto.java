package br.alura.com.loja.testes;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import br.dao.ProdutoDao;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {
        cadastrarProduto();
        Long id = 1l;
        EntityManager em = JPAUtil.getEntityManeger();
        ProdutoDao produtoDao = new ProdutoDao(em);
        Produto p = produtoDao.buscarPorId(1L);
        List<Produto> produtos = produtoDao.buscarTodosProdutos();
    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("Celulares");
        Produto celular =  new Produto("iphone","14",new BigDecimal(8000),celulares);

        EntityManager em = JPAUtil.getEntityManeger();
        em.getTransaction().begin();
        em.persist(celulares);
        em.persist(celular);
        celulares.setNome("GALAXY");

        em.flush();
        em.clear();

        celulares = em.merge(celulares);
        celulares.setNome("MOTOROLLA");
        em.flush();
    }
}
