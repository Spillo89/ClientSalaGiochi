//scegliere se registrarsi o loggare

package registrazione;

import java.util.Scanner;

public class Opzione {

	public static String[] opzione(){

		String stringa=null;
		String[] stringhe=null;

		System.out.println("premere R per registrarsi o L per effettuare il login se sei già registrato");

		Scanner scanner = new Scanner(System.in); 

		stringa = scanner.nextLine(); 

		if(stringa.equalsIgnoreCase("r")){
			stringhe=Registrami.registrazione();
			stringhe[0]="REGISTAZIONE";							//se devo registrarmi mando al server la 3a cella con una r che lui controllerà prima di fare tutto
		}else{
			stringhe=Login.login();
			stringhe[0]="LOGIN";							//se devo loggare mando l
		}

		scanner.close();

		return stringhe;	
	}
}
