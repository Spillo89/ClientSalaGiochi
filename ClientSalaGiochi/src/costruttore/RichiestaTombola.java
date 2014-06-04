package costruttore;

public class RichiestaTombola {
	
private static String NumeroSchede=null;
	
	public void richiesta(Integer numeroschede) {
		this.NumeroSchede=String.valueOf(numeroschede);
	}
	
	public static void setNumeroSchede(Integer numeroschede){
		NumeroSchede=String.valueOf(numeroschede);
	}
	
	public static String getNumeroSchede(){
		return NumeroSchede;
	}

}
