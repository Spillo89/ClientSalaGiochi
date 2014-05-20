package clientdecoder;

import java.util.StringTokenizer;

public class ClientDecoder {
	public static String[] dividi(String stringainiziale){
		int i=0;
		String[] stringhe = null;

		StringTokenizer st = new StringTokenizer(stringainiziale, "£");
	     while (st.hasMoreTokens()) {
	    	 stringhe[i]=st.nextToken();
	    	 i++;
	     }


		return stringhe;
	}
}
