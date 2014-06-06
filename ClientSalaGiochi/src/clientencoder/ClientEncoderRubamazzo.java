package clientencoder;

public class ClientEncoderRubamazzo {

public static String rubamazzo(){
		
		String stringadainviare=null;
		
		
		
		stringadainviare="RUBAMAZZO#";
		
		stringadainviare=stringadainviare+Rubamazzo.getCartaGiocata()+"\n";
		
		return stringadainviare;

		
	}
	
}
