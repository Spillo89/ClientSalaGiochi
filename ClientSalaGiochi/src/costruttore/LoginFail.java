package costruttore;

public class LoginFail {
	
	private static String Motivo=null;
	
	public LoginFail(String motivo) {
		this.Motivo=motivo;
	}
	
	public static void setMotivo(String motivo){
		Motivo=motivo;
	}
	
	public String getMotivo(){
		return Motivo;
	}

}
