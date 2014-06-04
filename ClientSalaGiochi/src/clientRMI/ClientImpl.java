package clientRMI;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import commonsRMI.Server;
import commonsRMImulti.Client;
import commonsRMImulti.ServerAccept;


public class ClientImpl extends UnicastRemoteObject implements Client {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String host = "127.0.0.1";
	private static final String url = "rmi://"+host+"/server";
	//Costruttore di default
	public ClientImpl() throws RemoteException{}
	public static void main(String[] args) throws RemoteException {
		(new ClientImpl()).start();
	}
	//Metodo di callback del server
	public void attivoDa(String attivoDa) throws RemoteException {
		System.out.println("Ricevuto dal server: " + attivoDa);
	}
	private void start() {
		try {
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new SecurityManager());
			Registry registry = LocateRegistry.getRegistry(host);
			ServerAccept stub = (ServerAccept) registry.lookup(url);
			int numero = (new Random()).nextInt(100);
			Server server = (Server) stub.login("client_"+numero, this);
			InfoUtenti utenti = ((commonsRMImulti.Server) server).getInfoUtenti();
			System.out.println("Utenti connessi: "+utenti.getNumUtenti());
			ArrayList<String> utentiNomi = utenti.getClientNames();
			//Ordino la collections
			Collections.sort(utentiNomi);
			Iterator<String> stringIterator = utentiNomi.iterator();
			while(stringIterator.hasNext()){
				System.out.println("\t"+stringIterator.next());
			}
			System.out.println("Mi metto in sleep");
			Thread.sleep(8000); //Attendo 8 secondi
			//Se il numero casuale estratto precedente è pari termino
			//correttamente se dispari simulo un errore di comunicazione
			if(numero%2==0)
				((commonsRMImulti.Server) server).termina(); //Segnalo l’uscita al thread
			System.exit(0); //Esco
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
		}
	}
}