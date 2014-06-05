package costruttore;

public class LoginFail {
	
	private static String Motivo=null;
	
	@SuppressWarnings("static-access")
	public LoginFail(String motivo) {
		this.Motivo=motivo;
	}
	
	public static void setMotivo(String motivo){
		Motivo=motivo;
	}
	
	public static String getMotivo(){
		return Motivo;
	}

}
