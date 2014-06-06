package costruttore;

public class Classifica {
	
	private static String NomeUtente=null;
	private static Integer Punti=null;
	
	@SuppressWarnings("static-access")
	public void registra(String nomeutente, Integer punti) {
		this.NomeUtente=nomeutente;
		this.Punti=punti;
	}

	public static String getNomeUtente() {
		return NomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		NomeUtente = nomeUtente;
	}

	public static Integer getPunti() {
		return Punti;
	}

	public void setPunti(Integer punti) {
		Punti = punti;
	}
	
}
