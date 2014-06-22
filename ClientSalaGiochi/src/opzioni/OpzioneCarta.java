package opzioni;

import java.util.Scanner;

import clientdecoder.ClientDecoderRubamazzo;
import costruttore.Carta;

public class OpzioneCarta {

	@SuppressWarnings("null")
	public static Carta opzionecarta() {

		Carta carta=null;
		Boolean esiste=false;
		while(esiste==false){
			System.out.println("tra le carte che hai in mano, che sono: ");
			for(int j=0;j<ClientDecoderRubamazzo.CarteinMano.size();j++){
				System.out.println(""+ClientDecoderRubamazzo.CarteinMano.get(j));
			}
			System.out.println("Scegline una inserendo il numero");

			Scanner scanner = new Scanner(System.in); 

			String stringa = scanner.nextLine();

			carta.setVal(Integer.parseInt(stringa));

			System.out.println("e una lettera per indicare il simbolo(B per bastoni, S per Spade, D per denari e C per coppe)");

			stringa = scanner.nextLine();

			carta.setSeme(stringa);
			
			esiste=controllacarta(carta);

			scanner.close();
		}

		return carta;
	}

	public static Boolean controllacarta(Carta carta){

		Boolean esiste=false;

		for(Integer i=0; i<ClientDecoderRubamazzo.CarteinMano.size()||esiste==true;i++){
			if(carta.equals(ClientDecoderRubamazzo.CarteinMano.get(i))){
				esiste=true;
			}
		}

		return esiste;
	}

}
