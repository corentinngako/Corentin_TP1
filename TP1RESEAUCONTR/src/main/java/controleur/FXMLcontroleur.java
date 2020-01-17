package controleur;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Information;
import model.Inter;
import model.NouveauThread;

public class FXMLcontroleur implements Initializable {

	ObservableList<String> obstemp = FXCollections.observableArrayList();

	private Information info = new Information();

	@FXML
	private TextField nomId;

	@FXML
	private TextField nomCplId;

	@FXML
	private TextField IpID;

	@FXML
	private TextField ipBoucle;

	@FXML
	private TextField idNomDomaine;

	@FXML
	private TextField idInformation;

	@FXML
	private ListView<String> idListe;

	@FXML
	private Button idObtenirNom;

	@FXML
	private TextField idAffNom;

	@FXML
	private Button idQuitter;

	@FXML
	private Button idObtenirInfo;

	/**
	 * affiche le nom complet de l ordinateur chaque fois qu'on appuie sur le
	 * boutton "obtenit nom complet"
	 * 
	 * @param event
	 */
	@FXML
	private void obtenirNom(ActionEvent event) {
		String str = (idListe.getSelectionModel().getSelectedItem()).toString();

		try {

			idAffNom.setText(InetAddress.getByName(str).getCanonicalHostName());

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * fermer l application quand on appuie sur le boutton "Quitter"
	 */
	@FXML
	public void quitter(ActionEvent event) {

		System.exit(0);

	}

	/**
	 * methode qui permet d obtenir les informations sur une adresse Ip ( IP + port)
	 * 
	 * @param event
	 */
	@FXML
	public void obtenirInfo(ActionEvent event) {
		String str = idNomDomaine.getText();
		String str2 = info.recupererNomDomaine(str);
		idInformation.setText(str2);

	}

	/**
	 * methode de l interface initialize qui permet d initialiser l interface
	 */
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		info.afficherNom();
		nomId.setText(info.afficherNom());
		IpID.setText(info.afficherIpLocale());
		nomCplId.setText(info.afficherNomComplet());
		ipBoucle.setText(info.afficherIpBoucle());

		idListe.setItems(FXCollections.observableArrayList("Chargement..."));
		Inter inter = new Inter();
		inter.genererAdresse();

		idListe.setItems(FXCollections.observableArrayList(NouveauThread.getList()));

	}
}
