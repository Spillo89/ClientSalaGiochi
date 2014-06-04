package clientencoder;

import costruttore.RichiestaTombola;

public class ClientEncoderVincita {

	
public static String tombola(){
		
		String stringadainviare=null;
		
		stringadainviare="VINCITATOMBOLA#";
		
		stringadainviare=stringadainviare+RichiestaTombola.getNumeroSchede()+"\n";
		
		return stringadainviare;

		
	}
}
