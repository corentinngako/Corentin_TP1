package model;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * classe qui cree une classe thread accessible sur le reseau
 * 
 * @author CORENTIN NGAKO
 */
public class NouveauThread extends Thread {

	String host;
	static List<String> list = new ArrayList<String>();

	/**
	 * constructeur de la classe
	 * 
	 * @param host
	 */
	public NouveauThread(String host) {
		super();
		this.host = host;
	}

	/**
	 * methode de la classe Thread qui permet de verifier si une adresse est
	 * accessible
	 */
	public void run() {
		try {
			int timeout = 1000;
			if (InetAddress.getByName(host).isReachable(timeout)) {
				String str = InetAddress.getByName(host).getHostAddress().toString();
				list.add(str);
				ThreaEcrire t = new ThreaEcrire();
				t.setParam(str);
				t.start();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<String> getList() {
		return list;
	}

}
