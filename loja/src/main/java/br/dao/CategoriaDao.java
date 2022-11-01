package br.dao;

import br.com.alura.loja.modelo.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager em;

    public  CategoriaDao(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Categoria c){
        this.em.persist(c);
    }

    //este método basicamente assegura que a categoria c está no estado maneged
    public void atualizar(Categoria c){
        this.em.merge(c);
    }

    public void remover(Categoria c){
        this.em.remove(this.em.merge(c));
    }
}

