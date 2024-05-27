package Entity;

import java.sql.Date;

public class EntityEsame {
		private int Valutazione;
		private Boolean Lode;
		private String Note_Docente;
		private int codiceEsame;
		private String UsernameS;
		private Date Data;
		
		public EntityEsame(int Valutazione, boolean Lode, String Note_Docente, Date Data, int codiceEsame, String UsernameS) {
		    super();
			this.Valutazione = Valutazione;
		    this.Lode = Lode;
		    this.Note_Docente =Note_Docente;
		    this.Data = Data;
		    this.codiceEsame = codiceEsame;
		    this.UsernameS = UsernameS;
		    }

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

		    public int getCodiceEsame() {
				return codiceEsame;
			}



			public String getUsernameS() {
				return UsernameS;
			}
			
			public void setCodiceEsame(int codiceEsame) {
				this.codiceEsame = codiceEsame;
			}

			public void setUsernameS(String usernameS) {
				UsernameS = usernameS;
			}

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

