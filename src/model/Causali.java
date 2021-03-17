package model;

public class Causali {
	private int IdCausale;
	private String nome, dareAvere;
	public Causali(int idCausale, String nome, String dareAvere) {
		this.IdCausale = idCausale;
		this.nome = nome;
		this.dareAvere = dareAvere;
	}
	public int getIdCausale() {
		return IdCausale;
	}
	public String getNome() {
		return nome;
	}
	public String getDareAvere() {
		return dareAvere;
	}
	public void setIdCausale(int idCausale) {
		IdCausale = idCausale;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDareAvere(String dareAvere) {
		this.dareAvere = dareAvere;
	}
}
