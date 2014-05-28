package clientdecoder;

import java.util.Date;
import java.util.StringTokenizer;

import costruttore.*;
public class ClientDecoderLogin {
	public static void decoderlogin(String stringainiziale){
		
		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		switch (st.nextToken())
		{
			case "KO":
				LoginFail.setMotivo(st.nextToken());
			case "OK":
				UtentePostlogin.setNome(st.nextToken());
				UtentePostlogin.setCognome(st.nextToken());
				UtentePostlogin.setCrediti(Integer.parseInt(st.nextToken()));
				UtentePostlogin.setUltimoLogin(st.nextToken());
				UtentePostlogin.setPosizione(Integer.parseInt(st.nextToken()));
			default:
				System.out.println("errore, stringa non riconosciuta");	
		};
		

	}
}
