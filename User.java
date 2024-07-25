package app;

public class User {
    private String nome;
    private String anni;
    
	public User() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAnni() {
		return anni;
	}

	public void setAnni(String anni) {
		this.anni = anni;
	}

	@Override
	public String toString() {
		return "User [nome=" + nome + ", anni=" + anni + "]";
	}
	
	

    
}