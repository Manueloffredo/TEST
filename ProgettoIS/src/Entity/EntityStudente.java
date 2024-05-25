package Entity;

import java.util.List;

public class EntityStudente {
	    private String Username;
	    private String Password;
	    private int Pin;
	    private String Nome;
	    private String Cognome;
	    private List<EntityEsame> Lista_Esami_Svolti; //????????????????????????????
	    private Double MediaPonderata;
	    private Double MediaAritmetica;
	    public EntityStudente(String Username,String Password,int Pin,String Nome, String Cognome,
	    					List<EntityEsame> Lista_Esami_Svolti,Double MediaPonderata, Double MediaAritmetica) 
	    
	    {
	    	super();
	    	this.Username=Username;
	    	this.Password=Password;
	    	this.Pin=Pin;
	    	this.Nome=Nome;
	    	this.Cognome=Cognome;
	    	this.Lista_Esami_Svolti=Lista_Esami_Svolti;			//??????????????????????
	    	this.MediaPonderata=MediaPonderata;
	    	this.MediaAritmetica=MediaAritmetica;
	
	    }
	    	// Getters
	        public String getUsername() {
	            return Username;
	        }

	        public String getPassword() {
	            return Password;
	        }

	        public int getPin() {
	            return Pin;
	        }

	        public String getNome() {
	            return Nome;
	        }

	        public String getCognome() {
	            return Cognome;
	        }

	        public List<EntityEsame> getEsami_Svolti() {
	            return Lista_Esami_Svolti;						//????????????????????????
	        }

	        public Double getMediaPonderata() {
	            return MediaPonderata;
	        }

	        public Double getMediaAritmetica() {
	            return MediaAritmetica;
	        }

	        // Setters
	        public void setUsername(String Username) {
	            this.Username = Username;
	        }

	        public void setPassword(String Password) {
	            this.Password = Password;
	        }

	        public void setPin(int Pin) {
	            this.Pin = Pin;
	        }

	        public void setNome(String Nome) {
	            this.Nome = Nome;
	        }

	        public void setCognome(String Cognome) {
	            this.Cognome = Cognome;
	        }

	        public void setEsami(List<EntityEsame> Lista_esami_Svolti) {
	            this.Lista_Esami_Svolti = Lista_Esami_Svolti;			//????????????????????????
	        }

	        public void setMediaPonderata(Double MediaPonderata) {
	            this.MediaPonderata = MediaPonderata;
	        }

	        public void setMediaAritmetica(Double MediaAritmetica) {
	            this.MediaAritmetica = MediaAritmetica;
	        }
	    }


