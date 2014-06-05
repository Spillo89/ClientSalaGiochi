package costruttore;

public class NumeroEstratto {

	private static Integer Numero=null;
	
	@SuppressWarnings("static-access")
	public void estrazione(Integer numero){
		this.Numero=numero;
	}

	public static Integer getNumero() {
		return Numero;
	}

	public static void setNumero(Integer numero) {
		Numero = numero;
	}
	
	
}
