package br.dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {
    private EntityManager em;

    public  ProdutoDao(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Produto p){
        this.em.persist(p);
    }

    public Produto buscarPorId(Long id){
        return em.find(Produto.class,id);
    }

    public List<Produto> buscarTodosProdutos(){
        String jpql = "SELECT p FROM Produto  as p";
        return em.createQuery(jpql,Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome){
        String jpql = "SELECT p FROM Produto  as p WHERE p.nome =:name";
        return em.createQuery(jpql,Produto.class).setParameter("name",nome).getResultList();
    }

    public List<Produto> buscarPorNomeDaCategoria(String nome){
        String jpql = "SELECT p FROM Produto  as p WHERE p.categoria.nome =:name";
        return em.createQuery(jpql,Produto.class).setParameter("name",nome).getResultList();
    }

    public BigDecimal buscarPreçoProdutoPorNome(String nome){
        String jpql = "SELECT p.preço FROM Produto  as p WHERE p.categoria.nome =:name";
        return em.createQuery(jpql,BigDecimal.class).setParameter("name",nome).getSingleResult();

    }
}
