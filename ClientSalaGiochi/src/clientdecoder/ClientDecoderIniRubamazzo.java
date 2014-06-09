package clientdecoder;

import java.util.ArrayList;
import java.util.StringTokenizer;

import pakageClient.SimpleClient;

import costruttore.ListaGiocatori;
import costruttore.NoCrediti;

public class ClientDecoderIniRubamazzo {

	public static ArrayList<ListaGiocatori> lista=new ArrayList<ListaGiocatori>();
	
	public static void decoderinirubamazzo(String stringainiziale){
		ListaGiocatori nomeutente=null;
		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		switch (st.nextToken())
		{
			case "KO":
				NoCrediti.setCreditiTotali(Integer.parseInt(st.nextToken()));
				SimpleClient.parolachiave="KO";
			case "OK":
				if(st.nextElement()!=null){
					nomeutente.setNomeUtente(st.nextToken());
					lista.add(nomeutente);
				}
				SimpleClient.parolachiave="OK";
			default:
				System.out.println("errore, stringa non riconosciuta");	
		};
	}
	
}
