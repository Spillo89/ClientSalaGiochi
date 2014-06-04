package clientdecoder;

import java.util.StringTokenizer;

import pakageClient.SimpleClient;

import costruttore.LoginFail;
import costruttore.NoCrediti;
import costruttore.SchedaTombola;
import costruttore.UtentePostlogin;

public class ClientDecoderIniTombola {
	public static void decoderinitombola(String stringainiziale){
		Integer i=null;
		Integer j=null;

		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		switch (st.nextToken())
		{
		case "KO":
			NoCrediti.setCreditiTotali(Integer.parseInt(st.nextToken()));
			SimpleClient.parolachiave="KO";
		case "OK":
			SchedaTombola.setNumeroSchede(Integer.parseInt(st.nextToken()));
			for(i=0;i<3;i++){
				for(j=0;i<9;i++){
					SchedaTombola.setValoriScheda1(st.nextToken(), i, j);
				}
			}
			for(i=0;i<3;i++){
				for(j=0;i<9;i++){
					SchedaTombola.setValoriScheda2(st.nextToken(), i, j);
				}
			}
			for(i=0;i<3;i++){
				for(j=0;i<9;i++){
					SchedaTombola.setValoriScheda3(st.nextToken(), i, j);
				}
			}
			for(i=0;i<3;i++){
				for(j=0;i<9;i++){
					SchedaTombola.setValoriScheda4(st.nextToken(), i, j);
				}
			}
			SchedaTombola.setCreditiTotali(Integer.parseInt(st.nextToken()));
			SimpleClient.parolachiave="OK";
		default:
			System.out.println("errore, stringa non riconosciuta");	
		};


	}
}
