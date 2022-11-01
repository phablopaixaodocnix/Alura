package modelo;

public class Produto {
	private Integer id;
	private String nome;
	private String Descrição;
	public Produto( String nome, String descrição) {
		super();
		this.nome = nome;
		Descrição = descrição;
	}
	public Produto(Integer id, String nome, String descrição) {
		super();
		this.id = id;
		this.nome = nome;
		this.Descrição = descrição;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrição() {
		return Descrição;
	}
	public void setDescrição(String descrição) {
		Descrição = descrição;
	}
		
}
