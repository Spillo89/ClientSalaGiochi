package clientdecoder;

import java.util.StringTokenizer;

import costruttore.LoginFail;
import costruttore.NoCrediti;
import costruttore.SchedaTombola;
import costruttore.UtentePostlogin;

public class ClientDecoderTombola {
	public static void decodertombola(String stringainiziale){
		Integer i=null;
		Integer j=null;

		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		switch (st.nextToken())
		{
		case "KO":
			NoCrediti.setCreditiTotali(Integer.parseInt(st.nextToken()));
		case "OK":
			SchedaTombola.setNumeroSchede(Integer.parseInt(st.nextToken()));
			for(i=0;i<3;i++){
				for(j=0;i<9;i++){
					SchedaTombola.setValoriScheda1(Integer.parseInt(st.nextToken()), i, j);
				}
			}
			for(i=0;i<3;i++){
				for(j=0;i<9;i++){
					SchedaTombola.setValoriScheda2(Integer.parseInt(st.nextToken()), i, j);
				}
			}
			for(i=0;i<3;i++){
				for(j=0;i<9;i++){
					SchedaTombola.setValoriScheda3(Integer.parseInt(st.nextToken()), i, j);
				}
			}
			for(i=0;i<3;i++){
				for(j=0;i<9;i++){
					SchedaTombola.setValoriScheda4(Integer.parseInt(st.nextToken()), i, j);
				}
			}
			SchedaTombola.setCreditiTotali(Integer.parseInt(st.nextToken()));
		default:
			System.out.println("errore, stringa non riconosciuta");	
		};


	}
}
