package model;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * classe qui permet de collecter les informations de l adresse ip
 * 
 * @author CORENTIN NGAKO
 */
public class Information {

	private String nomId;

	private String nomCplId;

	private String IpID;

	private String ipBoucle;
	
   /**
    * methode qui retourne le nom associé a  l adresse locale 
    * @return   une chaine de caractere
    */
	public String afficherNom() {
		try {
			InetAddress inetAd = InetAddress.getLocalHost();
			nomId = inetAd.getHostName().toString();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nomId;

	}
	/**
	 * methode qui retourne le nom complet de l ordinateur associé a l adresse ip 
	 * @return une chaine de caractere
	 */
	public String afficherNomComplet() {
		return nomCplId = this.afficherNom() + " " + this.afficherIpLocale();

	}
	/**
	 * methode qui retourne l adresse ip locale
	 * @return une chaine de caractere
	 */
	public String afficherIpLocale() {
		try {
			InetAddress inetAd = InetAddress.getLocalHost();
			IpID = inetAd.getHostAddress().toString();
			// IpID=InetAddress.getLoopbackAddress().toString();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return IpID;
	}
	/**
	 * methode qui retourne l ip boucle machine local
	 * @return  une chaine de caractere sous la forme "localhost/ip"
	 */
	public String afficherIpBoucle() {
		ipBoucle = InetAddress.getLoopbackAddress().toString();
		;
		// InetAddress.getLoopbackAddress());
		return ipBoucle;

	}
	/**
	 * methode qui retourne le nom de domaine et le numero de port
	 * @param idNomDomaine le nom de domaine
	 * @return une chaine de caractere sous form "ip:ip =*publique, port:n0 port"
	 */
	public String recupererNomDomaine(String idNomDomaine) {

		String ip = null;
		URL url = null;
		try {
			url = new URL("http://idNomDomaine");
			ip = "ip: " + (InetAddress.getByName(idNomDomaine).getHostAddress()).toString() + ", port :"
					+ url.getDefaultPort();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ip.toString();

	}

}
