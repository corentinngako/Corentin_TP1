package model;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * classe intermediaire qui permet de recevoir la liste des adresses accessibles
 * dans le reseau
 * 
 * @author CORENTIN NGAKO
 */
public class Inter {

	String addresseLocale;
	String addresseReseau;

	public Inter() {
		InetAddress inetAd = null;
		try {
			inetAd = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addresseLocale = inetAd.getHostAddress().toString();
		String[] tab = addresseLocale.split("\\.");
		addresseReseau = tab[0] + "." + tab[1] + "." + tab[2];

	}

	public void genererAdresse() {

		for (int i = 1; i <= 254; i++) {
			String host = addresseReseau + "." + i;
			NouveauThread thread = new NouveauThread(host);
			thread.start();
		}
	}

}
