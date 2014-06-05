package costruttore;

public class UtentePostlogin {

	private static String Nome=null;
	private static String Cognome=null;
	private static Integer Crediti=null;
	private static String UltimoLogin=null;
	private static Integer Posizione=null;
	
	
	
	@SuppressWarnings("static-access")
	public UtentePostlogin(String nome, String cognome, Integer crediti, String ultimologin, Integer posizione) {
		this.Nome=nome;
		this.Cognome=cognome;
		this.Crediti=crediti;
		this.UltimoLogin=ultimologin;
		this.Posizione=posizione;
	}
	
	public static void setCrediti(Integer crediti){
		Crediti=crediti;
	}
	
	public Integer getCrediti(){
		return Crediti;
	}
	
	public static void setCognome(String cognome){
		Cognome=cognome;
	}
	
	public String getCognome(){
		return Cognome;
	}
	
	public static void setNome(String nome){
		Nome=nome;
	}
	
	public String getNome(){
		return Nome;
	}
	
	public static void setUltimoLogin(String ultimologin){
		UltimoLogin=ultimologin;
	}
	
	public String getUltimoLogin(){
		return UltimoLogin;
	}
	
	public static void setPosizione(Integer posizione){
		Posizione=posizione;
	}
	
	public Integer getPosizione(){
		return Posizione;
	}

}