package Entity;

import java.sql.Date;

public class EntityEsame {
		private int Valutazione;
		private Boolean Lode;
		private String Note_Docente;
		private Date Data;
		
	
		public EntityEsame(int Valutazione, boolean Lode, String Note_Docente, Date Data) {
		    super();
			this.Valutazione = Valutazione;
		    this.Lode = Lode;
		    this.Note_Docente =Note_Docente;
		    this.Data = Data;
		    }

		    // Getters
		    public int getValutazione() {
		        return Valutazione;
		    }

		    public boolean isLode() {
		        return Lode;
		    }

		    public String getNoteDocente() {
		        return Note_Docente;
		    }

		    public Date getData() {
		        return Data;
		    }

		    // Setters
		    public void setValutazione(int Valutazione) {
		        this.Valutazione = Valutazione;
		    }

		    public void setLode(boolean Lode) {
		        this.Lode = Lode;
		    }

		    public void setNoteDocente(String Note_Docente) {
		        this.Note_Docente = Note_Docente;
		    }

		    public void setData(Date Data) {
		        this.Data = Data;
		    }
		}

