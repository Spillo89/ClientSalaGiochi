package clientencoder;

import costruttore.RichiestaTombola;

public class ClientEncoderTombola {
public static String tombola(){
		
		String stringadainviare=null;
		
		stringadainviare="TOMBOLA#";
		
		stringadainviare=stringadainviare+RichiestaTombola.getNumeroSchede()+"\n";
		
		
		return stringadainviare;

		
	}
}
