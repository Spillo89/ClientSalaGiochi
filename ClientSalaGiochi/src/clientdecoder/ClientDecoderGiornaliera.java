package clientdecoder;

import java.util.ArrayList;
import java.util.StringTokenizer;

import pakageClient.SimpleClient;

import costruttore.Classifica;
import costruttore.LoginFail;

public class ClientDecoderGiornaliera {

	public static ArrayList<Classifica> classifica=new ArrayList<Classifica>();

	public static void decoderestrazione(String stringainiziale){

		Classifica clas=new Classifica();
		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		switch (st.nextToken())
		{
		case "KO":
			LoginFail.setMotivo(st.nextToken());
			break;
		case "OK":

			while(st.nextElement() != null){
				clas.setNomeUtente(st.nextToken());
				clas.setPunti(Integer.parseInt(st.nextToken()));

				classifica.add(clas);
			}
			SimpleClient.parolachiave="OK";
			break;
		default:
			System.out.println("errore, stringa non riconosciuta");	
		};


	}
}
