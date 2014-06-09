package costruttore;

public class ListaGiocatori {
	
	private static String NomeUtente=null;

	@SuppressWarnings("static-access")
	public ListaGiocatori(String nomeutente){
		this.NomeUtente=nomeutente;
	}

	public static String getNomeUtente() {
		return NomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		NomeUtente = nomeUtente;
	}
	
}
