package clientencoder;

import costruttore.VincitaTombola;

public class ClientEncoderVincita {

	
public static String tombola(){
		
		String stringadainviare=null;
		
		stringadainviare="VINCITATOMBOLA#";
		
		stringadainviare=stringadainviare+VincitaTombola.getTipodiVincita()+"\n";
		
		return stringadainviare;

		
	}
}
