package costruttore;

public class NoCrediti {
	
	private static Integer CreditiTotali=null;
	
	public NoCrediti(Integer credititotali) {
		this.CreditiTotali=credititotali;
	}
	
	public static void setCreditiTotali(Integer credititotali){
		CreditiTotali=credititotali;
	}
	
	public Integer getCreditiTotali(){
		return CreditiTotali;
	}

}