package clientencoder;

import costruttore.PerRegistrazione;

public class ClientEncoderRegistrazione {
	//produce le stringhe da inviare tramite il socket
	
	public static String registrazione(){
		
		String stringadainviare=null;
		
		stringadainviare="REGISTRAZIONE#";
		stringadainviare=stringadainviare+PerRegistrazione.getNome()+"#";
		stringadainviare=stringadainviare+PerRegistrazione.getCognome()+"#";
		stringadainviare=stringadainviare+PerRegistrazione.getNomeUtente()+"#";
		stringadainviare=stringadainviare+PerRegistrazione.getPsw()+"\n";
		
		
		return stringadainviare;

		
	}
}
