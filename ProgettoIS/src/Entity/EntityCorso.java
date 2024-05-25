package Entity;
import java.util.List;


public class EntityCorso {
		private int Codice;
		private String Denominazione;
		private int Num_Cfu;
		private String Tipologia;
		private List <EntityEsame> Lista_Esami_Propedeutici;


		    // Constructor
		public EntityCorso(int Codice, String Denominazione, int Num_Cfu, String Tipologia, 
				List<EntityEsame> Lista_Esami_Propedeutici) {
		        this.Codice = Codice;
		        this.Denominazione = Denominazione;
		        this.Num_Cfu = Num_Cfu;
		        this.Tipologia = Tipologia;
		        this.Lista_Esami_Propedeutici = Lista_Esami_Propedeutici;
		    }

		    // Getters
		    public int getCodice() {
		        return Codice;
		    }

		    public String getDenominazione() {
		        return Denominazione;
		    }

		    public int getNumCfu() {
		        return Num_Cfu;
		    }

		    public String getTipologia() {
		        return Tipologia;
		    }

		    public List<EntityEsame> getListaEsamiPropedeutici() {
		        return Lista_Esami_Propedeutici;
		    }

		    // Setters
		    public void setCodice(int Codice) {
		        this.Codice = Codice;
		    }

		    public void setDenominazione(String Denominazione) {
		        this.Denominazione = Denominazione;
		    }

		    public void setNumCfu(int Num_Cfu) {
		        this.Num_Cfu = Num_Cfu;
		    }

		    public void setTipologia(String Tipologia) {
		        this.Tipologia = Tipologia;
		    }

		    public void setListaEsamiPropedeutici(List<EntityEsame> Lista_Esami_Propedeutici) {
		        this.Lista_Esami_Propedeutici = Lista_Esami_Propedeutici;
		    }
		}

		

