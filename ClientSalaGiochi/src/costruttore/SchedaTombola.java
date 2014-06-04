package costruttore;

public class SchedaTombola {
	
	private static Integer NumeroSchede=null;
	private static String ValoriScheda1[][] = new String[3][9];
	private static String ValoriScheda2[][] = new String[3][9];
	private static String ValoriScheda3[][] = new String[3][9];
	private static String ValoriScheda4[][] = new String[3][9];
	private static Integer CreditiTotali=null;
	
	
	public void risultatoslot(Integer numeroschede, String valorischeda1[][], String valorischeda2[][], String valorischeda3[][], String valorischeda4[][], Integer credititotali) {
		this.NumeroSchede=numeroschede;
		this.ValoriScheda1=valorischeda1;
		this.ValoriScheda2=valorischeda2;
		this.ValoriScheda3=valorischeda3;
		this.ValoriScheda4=valorischeda4;
		this.CreditiTotali=credititotali;
	}


	public static Integer getNumeroSchede() {
		return NumeroSchede;
	}


	public static void setNumeroSchede(Integer numeroSchede) {
		NumeroSchede = numeroSchede;
	}


	public static String getValoriScheda1(int i, int j) {
		return ValoriScheda1[i][j];
	}



	public static void setValoriScheda1(String valorischeda1, Integer i, Integer j) {
		ValoriScheda1[i][j] = valorischeda1;
	}


	public static String getValoriScheda2(int i, int j) {
		return ValoriScheda2[i][j];
	}



	public static void setValoriScheda2(String valorischeda2, Integer i, Integer j) {
		ValoriScheda2[i][j] = valorischeda2;
	}


	public static String getValoriScheda3(int i, int j) {
		return ValoriScheda3[i][j];
	}



	public static void setValoriScheda3(String valoriScheda3, Integer i, Integer j) {
		ValoriScheda1[i][j] = valoriScheda3;
	}


	public static String getValoriScheda4(int i, int j) {
		return ValoriScheda4[i][j];
	}


	public static void setValoriScheda4(String valoriScheda4, Integer i, Integer j) {
		ValoriScheda4[i][j] = valoriScheda4;
	}


	public static Integer getCreditiTotali() {
		return CreditiTotali;
	}


	public static void setCreditiTotali(Integer creditiTotali) {
		CreditiTotali = creditiTotali;
	}

}
