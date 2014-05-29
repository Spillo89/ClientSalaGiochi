package costruttore;

public class PerRegistrazione {
	
	private static String Nome=null;
	private static String Cognome=null;
	private static String NomeUtente=null;
	private static String Psw=null;
	
	public void registra(String nome, String cognome, String nomeutente, String psw) {
		this.Nome=nome;
		this.Cognome=cognome;
		this.NomeUtente=nomeutente;
		this.Psw=psw;
	}

	public static String getNome() {
		return Nome;
	}

	public static void setNome(String nome) {
		Nome = nome;
	}

	public static String getCognome() {
		return Cognome;
	}

	public static void setCognome(String cognome) {
		Cognome = cognome;
	}

	public static String getNomeUtente() {
		return NomeUtente;
	}

	public static void setNomeUtente(String nomeUtente) {
		NomeUtente = nomeUtente;
	}

	public static String getPsw() {
		return Psw;
	}

	public static void setPsw(String psw) {
		Psw = psw;
	}

}
