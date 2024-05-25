package Entity;

import java.util.List;

public class EntitySegreteriaStudenti {
	private List<EntityCorso> corsi;
	private List<EntityDocente> listaDocenti;
	
	public EntitySegreteriaStudenti(List<EntityCorso> corsi, List<EntityDocente> listaDocenti) {
		super();
		this.corsi = corsi;
		this.listaDocenti = listaDocenti;
	}

	public List<EntityCorso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<EntityCorso> corsi) {
		this.corsi = corsi;
	}

	public List<EntityDocente> getListaDocenti() {
		return listaDocenti;
	}

	public void setListaDocenti(List<EntityDocente> listaDocenti) {
		this.listaDocenti = listaDocenti;
	}
	
	
}
