package costruttore;

public class RisultatoSlot {
	
	private static String Valore1=null;
	private static String Valore2=null;
	private static String Valore3=null;
	private static String Risultato=null;
	private static Integer CreditiVinti=null;
	private static Integer CreditiTotali=null;
	
	public void risultatoslot(String valore1, String valore2, String valore3, String risultato, Integer creditivinti, Integer credititotali) {
		this.Valore1=valore1;
		this.Valore2=valore2;
		this.Valore3=valore3;
		this.Risultato=risultato;
		this.CreditiVinti=creditivinti;
		this.CreditiTotali=credititotali;
	}
	
	
	public static String getRisultato() {
		return Risultato;
	}


	public static void setRisultato(String risultato) {
		Risultato = risultato;
	}


	public static String getValore1() {
		return Valore1;
	}

	public static void setValore1(String valore1) {
		Valore1 = valore1;
	}

	public static String getValore2() {
		return Valore2;
	}

	public static void setValore2(String valore2) {
		Valore2 = valore2;
	}

	public static String getValore3() {
		return Valore3;
	}

	public static void setValore3(String valore3) {
		Valore3 = valore3;
	}

	public static Integer getCreditiVinti() {
		return CreditiVinti;
	}

	public static void setCreditiVinti(Integer creditiVinti) {
		CreditiVinti = creditiVinti;
	}

	public static void setCreditiTotali(Integer credititotali){
		CreditiTotali=credititotali;
	}
	
	public Integer getCreditiTotali(){
		return CreditiTotali;
	}

}