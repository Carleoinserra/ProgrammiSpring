package app;

public class prodotto {

	
	private String nome;
	private String marca;
	private double prezzo;
	private int qnt;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getQnt() {
		return qnt;
	}
	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	@Override
	public String toString() {
		return "nome= " + nome + ", marca= " + marca + ", prezzo= " + prezzo + ", qnt= " + qnt;
	}
	
	
}
