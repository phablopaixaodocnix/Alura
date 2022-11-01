package br.com.alura.loja.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descrição;   
    private BigDecimal preço;
    private LocalDate dataCadastro = LocalDate.now();
    @ManyToOne
    private Categoria categoria;

    public Produto(String nome, String descrição, BigDecimal preço, Categoria categoria) {
        this.nome = nome;
        this.descrição = descrição;
        this.preço = preço;
        this.categoria = categoria;
    }

    public long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getDescrição() {
        return descrição;
    }
    public BigDecimal getPreço() {
        return preço;
    }
    public Categoria getCategoria() {
        return categoria;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }
    public void setPreço(BigDecimal preço) {
        this.preço = preço;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
