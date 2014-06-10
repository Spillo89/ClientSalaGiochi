package costruttore;

public class UtentePrelogin {

	private static String NomeUtente=null;
	private static String Psw=null;
	private static String Azione=null;
	
	
	
	@SuppressWarnings("static-access")
	public UtentePrelogin(String nomeutente, String psw, String azione) {
		super();
		this.NomeUtente=nomeutente;
		this.Psw=psw;
		this.Azione=azione;
	}
	
	public static void setAzione(String azione){
		Azione=azione;
	}
	
	public String getAzione(){
		return Azione;
	}
	
	public static void setNomeUtente(String nomeutente){
		NomeUtente=nomeutente;
	}
	
	public static String getNomeUtente(){
		return NomeUtente;
	}
	
	public static void setPsw(String psw){
		Psw=psw;
	}
	
	public String getPsw(){
		return Psw;
	}

}