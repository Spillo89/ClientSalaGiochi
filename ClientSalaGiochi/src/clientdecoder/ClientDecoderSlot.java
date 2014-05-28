package clientdecoder;

import java.util.StringTokenizer;

import costruttore.LoginFail;
import costruttore.NoCrediti;
import costruttore.RisultatoSlot;
import costruttore.UtentePostlogin;

public class ClientDecoderSlot {
	public static void decoderslot(String stringainiziale){
		
		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		switch (st.nextToken())
		{
			case "KO":
				NoCrediti.setCreditiTotali(Integer.parseInt((st.nextToken())));
			case "OK":
				RisultatoSlot.setValore1(st.nextToken());
				RisultatoSlot.setValore2(st.nextToken());
				RisultatoSlot.setValore3(st.nextToken());
				RisultatoSlot.setRisultato(st.nextToken());
				RisultatoSlot.setCreditiVinti(Integer.parseInt(st.nextToken()));
				RisultatoSlot.setCreditiTotali(Integer.parseInt(st.nextToken()));
			default:
				System.out.println("errore, stringa non riconosciuta");	
		};
		

	}
}
