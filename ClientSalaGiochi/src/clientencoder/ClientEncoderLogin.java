package clientencoder;

import pakageClient.SimpleClient;
import costruttore.PerRegistrazione;

public class ClientEncoderLogin {
	
	public static String login(){

		String stringadainviare=null;
		
		SimpleClient.parolachiave="LOGIN";

		stringadainviare="LOGIN#";

		stringadainviare=stringadainviare+PerRegistrazione.getNomeUtente()+"#";
		stringadainviare=stringadainviare+PerRegistrazione.getPsw()+"\n";


		return stringadainviare;


	}

}
