package clientencoder;

import costruttore.Carta;

public class ClientEncoderRubamazzo {

public static String rubamazzo(Carta carta){
		
		String stringadainviare=null;
		
		
		
		stringadainviare="RUBAMAZZO#";
		
		stringadainviare=stringadainviare+carta.getVal()+"#";
		stringadainviare=stringadainviare+carta.getSeme()+"\n";
		
		
		return stringadainviare;

		
	}
	
}
