package clientdecoder;

import java.util.Date;
import java.util.StringTokenizer;

import pakageClient.SimpleClient;

import costruttore.*;
public class ClientDecoderLogin {
	public static void decoderlogin(String stringainiziale){
		
		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		switch (st.nextToken())
		{
			case "KO":
				LoginFail.setMotivo(st.nextToken());
				SimpleClient.parolachiave="KO";
			case "OK":
				UtentePostlogin.setNome(st.nextToken());
				UtentePostlogin.setCognome(st.nextToken());
				UtentePostlogin.setCrediti(Integer.parseInt(st.nextToken()));
				UtentePostlogin.setUltimoLogin(st.nextToken());
				UtentePostlogin.setPosizione(Integer.parseInt(st.nextToken()));
				SimpleClient.parolachiave="KO";
			default:
				System.out.println("errore, stringa non riconosciuta");	
		};
		

	}
}
