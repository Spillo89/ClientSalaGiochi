package clientdecoder;

import java.util.ArrayList;
import java.util.StringTokenizer;

import pakageClient.SimpleClient;
import costruttore.Carta;
import costruttore.LoginFail;

public class ClientDecoderRubamazzo {

	public static ArrayList<Carta> CarteinMano=new ArrayList<Carta>();
	public static ArrayList<Carta> CarteinBanco=new ArrayList<Carta>();
	public static Carta CartainCima0=null;
	public static Carta CartainCima1=null;
	public static Carta CartainCima2=null;
	public static Carta CartainCima3=null;

	public static void decoderestrazione(String stringainiziale){

		Carta carta=new Carta(null, null);
		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		switch (st.nextToken())
		{
		case "KO":
			LoginFail.setMotivo(st.nextToken());
		case "OK":

			while(st.nextElement() != "CARTEINMANO"){
				carta.setVal(Integer.parseInt(st.nextToken()));
				carta.setSeme(st.nextToken());

				CarteinMano.add(carta);
			}
			while(st.nextElement()!="CARTEINBANCO"){
				carta.setVal(Integer.parseInt(st.nextToken()));
				carta.setSeme(st.nextToken());

				CarteinBanco.add(carta);
			}
			
			carta.setVal(Integer.parseInt(st.nextToken()));
			carta.setSeme(st.nextToken());
			
			CartainCima0=carta;
			
			if(st.nextElement()!=null){
				carta.setVal(Integer.parseInt(st.nextToken()));
				carta.setSeme(st.nextToken());
				
				CartainCima1=carta;
			}
			if(st.nextElement()!=null){
				carta.setVal(Integer.parseInt(st.nextToken()));
				carta.setSeme(st.nextToken());
				
				CartainCima2=carta;
			}
			if(st.nextElement()!=null){
				carta.setVal(Integer.parseInt(st.nextToken()));
				carta.setSeme(st.nextToken());
				
				CartainCima3=carta;
			}
			SimpleClient.parolachiave="OK";
		default:
			System.out.println("errore, stringa non riconosciuta");	
		};


	}
	
}
