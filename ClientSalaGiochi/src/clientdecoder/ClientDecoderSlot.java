package clientdecoder;

import java.util.StringTokenizer;

import pakageClient.SimpleClient;

import costruttore.NoCrediti;
import costruttore.RisultatoSlot;

public class ClientDecoderSlot {
	public static void decoderslot(String stringainiziale){
		
		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		switch (st.nextToken())
		{
			case "KO":
				NoCrediti.setCreditiTotali(Integer.parseInt((st.nextToken())));
				SimpleClient.parolachiave="KO";
			case "OK":
				RisultatoSlot.setValore1(st.nextToken());
				RisultatoSlot.setValore2(st.nextToken());
				RisultatoSlot.setValore3(st.nextToken());
				RisultatoSlot.setRisultato(st.nextToken());
				RisultatoSlot.setCreditiVinti(Integer.parseInt(st.nextToken()));
				RisultatoSlot.setCreditiTotali(Integer.parseInt(st.nextToken()));
				SimpleClient.parolachiave="OK";
			default:
				System.out.println("errore, stringa non riconosciuta");	
		};
		

	}
}
