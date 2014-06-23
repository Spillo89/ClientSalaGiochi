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
				break;
			case "OK":
				NumeroEstratto.setNumero(Integer.parseInt(st.nextToken()));
				break;
			default:
				System.out.println("errore, stringa non riconosciuta");	
		};
		

	}

}
