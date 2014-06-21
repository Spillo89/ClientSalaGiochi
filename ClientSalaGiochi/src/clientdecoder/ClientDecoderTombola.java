package clientdecoder;

import java.util.StringTokenizer;

import costruttore.LoginFail;
import costruttore.VincitaTombola;

public class ClientDecoderTombola {
		public static void decodertombola(String stringainiziale){

			StringTokenizer st = new StringTokenizer(stringainiziale, "#");
			switch (st.nextToken())
			{
			case "KO":
				LoginFail.setMotivo(st.nextToken());
			case "OK":
				VincitaTombola.setVincita(Integer.parseInt(st.nextToken()));
				VincitaTombola.setTipodiVincita(st.nextToken());
			default:
				System.out.println("errore, stringa non riconosciuta");	
			};


		}
}
