package costruttore;

public class ListaGiocatori {
	
	private  String NomeUtente=null;

	public ListaGiocatori(String nomeutente){
		this.NomeUtente=nomeutente;
	}

	public  String getNomeUtente() {
		return NomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		NomeUtente = nomeUtente;
	}
	
}
