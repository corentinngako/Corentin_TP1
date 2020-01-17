package model;

import java.io.*;

/**
 * classe qui permet d ecrire la liste de machine atteignable dans un fichier
 * 
 * @author CORENTIN NGAKO
 *
 */
public class ThreaEcrire extends Thread {

	String atteinge;

	public void run() {
		ecrireFichier(atteinge);

	}

	public void setParam(String aNom) {
		atteinge = aNom;

	}

	/**
	 * methode qui ecrire dans la liste des machines atteignables dans le fichier
	 * 
	 * @param monText la liste des adresses sous forme de chaine de caracteres la
	 *                sortie est dans le projet TP1RESEAUCONTR
	 */
	private synchronized void ecrireFichier(String monText) {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/main/resources/tp1.txt", true)));
			out.println(monText);
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
}
