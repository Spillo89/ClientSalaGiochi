package clientdecoder;

import java.util.StringTokenizer;

import costruttore.LoginFail;
import costruttore.NumeroEstratto;

public class ClientDecoderEstrazione {
	
public static void decoderestrazione(String stringainiziale){
		
		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		switch (st.nextToken())
		{
			case "KO":
				LoginFail.setMotivo(st.nextToken());
			case "OK":
				NumeroEstratto.setNumero(Integer.parseInt(st.nextToken()));
			default:
				System.out.println("errore, stringa non riconosciuta");	
		};
		

	}

}
