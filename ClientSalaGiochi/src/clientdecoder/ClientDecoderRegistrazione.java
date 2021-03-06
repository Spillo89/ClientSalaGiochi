package clientdecoder;

import java.util.StringTokenizer;

import pakageClient.SimpleClient;

import costruttore.LoginFail;
import costruttore.UtentePostlogin;

public class ClientDecoderRegistrazione {
	
	public static void decoderregistrazione(String stringainiziale){
		
		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		switch (st.nextToken())
		{
			case "KO":
				LoginFail.setMotivo(st.nextToken());
				SimpleClient.parolachiave="KO";
				break;
			case "OK":
				UtentePostlogin.setNome(st.nextToken());
				UtentePostlogin.setCognome(st.nextToken());
				UtentePostlogin.setCrediti(Integer.parseInt(st.nextToken()));
				UtentePostlogin.setPosizione(Integer.parseInt(st.nextToken()));
				SimpleClient.parolachiave="OK";
				break;
			default:
				System.out.println("errore, stringa non riconosciuta");	
		};
		

	}

}
