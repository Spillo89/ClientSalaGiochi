package costruttore;

public class SchedaTombola {
	
	private static Integer NumeroSchede=null;
	private static Integer ValoriScheda1[][] = new Integer[3][9];
	private static Integer ValoriScheda2[][] = new Integer[3][9];
	private static Integer ValoriScheda3[][] = new Integer[3][9];
	private static Integer ValoriScheda4[][] = new Integer[3][9];
	private static Integer CreditiTotali=null;
	
	
	public void risultatoslot(Integer numeroschede, Integer valorischeda1[][], Integer valorischeda2[][], Integer valorischeda3[][], Integer valorischeda4[][], Integer credititotali) {
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


	public static Integer[][] getValoriScheda1() {
		return ValoriScheda1;
	}


	public static void setValoriScheda1(Integer valorischeda1, Integer i, Integer j) {
		ValoriScheda1[i][j] = valorischeda1;
	}


	public static Integer[][] getValoriScheda2() {
		return ValoriScheda2;
	}


	public static void setValoriScheda2(Integer valorischeda2, Integer i, Integer j) {
		ValoriScheda2[i][j] = valorischeda2;
	}


	public static Integer[][] getValoriScheda3() {
		return ValoriScheda3;
	}


	public static void setValoriScheda3(Integer valoriScheda3, Integer i, Integer j) {
		ValoriScheda1[i][j] = valoriScheda3;
	}


	public static Integer[][] getValoriScheda4() {
		return ValoriScheda4;
	}


	public static void setValoriScheda4(Integer valoriScheda4, Integer i, Integer j) {
		ValoriScheda4[i][j] = valoriScheda4;
	}


	public static Integer getCreditiTotali() {
		return CreditiTotali;
	}


	public static void setCreditiTotali(Integer creditiTotali) {
		CreditiTotali = creditiTotali;
	}

}
