package Entity;

public class EntityDocente {
	private String Matricola;
	private String Nome;
	private String Cognome;
	
	public EntityDocente(String Matricola,String Nome,String Cognome){
		this.Matricola=Matricola;
		this.Nome=Nome;
		this.Cognome=Cognome;
	}
	public String getMatricola() {
		return Matricola;
	}
	public void setMatricola(String Matricola){
		this.Matricola=Matricola;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String Nome){
		this.Nome=Nome;
	}
	
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String Cognome){
		this.Cognome=Cognome;
	}
}
